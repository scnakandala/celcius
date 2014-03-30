package excel;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *
 * @author Supun Nakandala
 */
public class CostingSummary {

    private ArrayList<ItemSummaryObject> items;
    private int summaryStartRow = 3;
    private int itemNoCol = 0;
    private int itemCol = 1;
    private int typeCol = 2;
    private int fabricTypeCol = 3;
    private int fiberPaddingCol = 4;
    private int sizeCol = 5;
    private int quantityCol = 6;
    private int cpuCol = 7;
    private int markUpCol = 9;
    private int taxCol = 11;
    private int totalCostCol = 8;
    private int netSellingPriceCol = 10;
    private int grossSellingPriceCol = 12;
    private int netValCol = 13;
    private int grossValCol = 14;
    private int detailsStartRow = 3;
    private int prodSpecCol = 0;
    private int prodCPUCol = 3;
    private int prodManSpecCol = 6;

    public CostingSummary() {
        this.items = new ArrayList<ItemSummaryObject>();
    }

    public void addItem(ItemSummaryObject item) {
        items.add(item);
    }

    public void clearItems() {
        this.items = new ArrayList<ItemSummaryObject>();
    }

    private void copyRow(HSSFWorkbook workbook, HSSFSheet worksheet, int sourceRowNum, int destinationRowNum) {
        // Get the source / new row
        HSSFRow newRow = worksheet.getRow(destinationRowNum);
        HSSFRow sourceRow = worksheet.getRow(sourceRowNum);

        // If the row exist in destination, push down all rows by 1 else create a new row
        if (newRow != null) {
            worksheet.shiftRows(destinationRowNum, worksheet.getLastRowNum(), 1);
        } else {
            newRow = worksheet.createRow(destinationRowNum);
        }

        // Loop through source columns to add to new row
        for (int i = 0; i < sourceRow.getLastCellNum(); i++) {
            // Grab a copy of the old/new cell
            HSSFCell oldCell = sourceRow.getCell(i);
            HSSFCell newCell = newRow.createCell(i);

            // If the old cell is null jump to next cell
            if (oldCell == null) {
                newCell = null;
                continue;
            }

            // Copy style from old cell and apply to new cell
            HSSFCellStyle newCellStyle = workbook.createCellStyle();
            newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
            ;
            newCell.setCellStyle(newCellStyle);

            // If there is a cell comment, copy
            if (oldCell.getCellComment() != null) {
                newCell.setCellComment(oldCell.getCellComment());
            }

            // If there is a cell hyperlink, copy
            if (oldCell.getHyperlink() != null) {
                newCell.setHyperlink(oldCell.getHyperlink());
            }

            // Set the cell data type
            newCell.setCellType(oldCell.getCellType());

            // Set the cell data value
            switch (oldCell.getCellType()) {
                case Cell.CELL_TYPE_BLANK:
                    newCell.setCellValue(oldCell.getStringCellValue());
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    newCell.setCellValue(oldCell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_ERROR:
                    newCell.setCellErrorValue(oldCell.getErrorCellValue());
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    newCell.setCellFormula(oldCell.getCellFormula());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    newCell.setCellValue(oldCell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    newCell.setCellValue(oldCell.getRichStringCellValue());
                    break;
            }
        }

        // If there are are any merged regions in the source row, copy to new row
        for (int i = 0; i < worksheet.getNumMergedRegions(); i++) {
            CellRangeAddress cellRangeAddress = worksheet.getMergedRegion(i);
            if (cellRangeAddress.getFirstRow() == sourceRow.getRowNum()) {
                CellRangeAddress newCellRangeAddress = new CellRangeAddress(newRow.getRowNum(),
                        (newRow.getRowNum()
                        + (cellRangeAddress.getLastRow() - cellRangeAddress.getFirstRow())),
                        cellRangeAddress.getFirstColumn(),
                        cellRangeAddress.getLastColumn());
                worksheet.addMergedRegion(newCellRangeAddress);
            }
        }
    }

    public void exportSummary() throws IOException {
        //Read the spreadsheet that needs to be updated
        FileInputStream input_document = new FileInputStream(new File("Costing Summary-Template.xls"));
        //Access the workbook
        HSSFWorkbook workbook = new HSSFWorkbook(input_document);
        //Access the worksheet, so that we can update / modify it.
        HSSFSheet summary_worksheet = workbook.getSheetAt(0);

        //making the number of sheets required.
        int noOfItems = items.size();

        for (int i = 1; i < noOfItems; i++) {
            workbook.cloneSheet(i);
            workbook.setSheetName(i + 1, "Item " + (i + 1));
            copyRow(workbook, summary_worksheet, summaryStartRow + i - 1, summaryStartRow + i);
        }

        for (int i = 0; i < noOfItems; i++) {
            SummaryObject summary = items.get(i).getSummaryObject();
            ArrayList<Map.Entry<String, String>> productSpecs = items.get(i).getProductSpecs();
            ArrayList<Map.Entry<String, String>> costDescs = items.get(i).getCostDecription();
            ArrayList<Map.Entry<String, String>> manufacSpecs = items.get(i).getManufacSpecs();

            //adding to summary
            Cell cell = summary_worksheet.getRow(summaryStartRow + i).getCell(itemNoCol);
            cell.setCellValue("Item " + (i + 1));

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(itemCol);
            cell.setCellValue(summary.getItem());

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(typeCol);
            cell.setCellValue(summary.getType());

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(fabricTypeCol);
            cell.setCellValue(summary.getFabricType());

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(fiberPaddingCol);
            cell.setCellValue(summary.getFiberPadding());

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(sizeCol);
            cell.setCellValue(summary.getSize());

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(quantityCol);
            cell.setCellValue(summary.getQuantity());

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(cpuCol);
            cell.setCellValue(summary.getCostPerUnit());

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(markUpCol);
            cell.setCellValue(summary.getMarkUp());

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(taxCol);
            cell.setCellValue(summary.getTax());

            //setting formulas
            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(totalCostCol);
            cell.setCellFormula("G" + (summaryStartRow + i + 1) + "*H" + (summaryStartRow + i + 1));

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(netSellingPriceCol);
            cell.setCellFormula("H" + (summaryStartRow + i + 1) + "*(1+J" + (summaryStartRow + i + 1) + "/100)");

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(grossSellingPriceCol);
            cell.setCellFormula("K" + (summaryStartRow + i + 1) + "*(1+L" + (summaryStartRow + i + 1) + "/100)");

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(netValCol);
            cell.setCellFormula("G" + (summaryStartRow + i + 1) + "*K" + (summaryStartRow + i + 1));

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(grossValCol);
            cell.setCellFormula("G" + (summaryStartRow + i + 1) + "*M" + (summaryStartRow + i + 1));

            //adding detailed description
            HSSFSheet detail_worksheet = workbook.getSheetAt(i + 1);

            cell = detail_worksheet.getRow(0).getCell(0);
            cell.setCellValue(items.get(i).getItemName());
            
            int maxRows = Math.max(productSpecs.size(), Math.max(costDescs.size(), productSpecs.size()));
            for (int j = 0; j < maxRows - 1; j++) {
                copyRow(workbook, detail_worksheet, detailsStartRow + j, detailsStartRow + j + 1);
            }

            Iterator it = productSpecs.iterator();
            int k = 0;
            while (it.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();

                cell = detail_worksheet.getRow(detailsStartRow + k).getCell(prodSpecCol);
                cell.setCellValue(entry.getKey());

                cell = detail_worksheet.getRow(detailsStartRow + k).getCell(prodSpecCol + 1);
                cell.setCellValue(entry.getValue());

                k++;
            }

            it = costDescs.iterator();
            k = 0;
            while (it.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();

                cell = detail_worksheet.getRow(detailsStartRow + k).getCell(prodCPUCol);
                cell.setCellValue(entry.getKey());

                cell = detail_worksheet.getRow(detailsStartRow + k).getCell(prodCPUCol + 1);
                cell.setCellValue(entry.getValue());
                k++;
            }

            it = manufacSpecs.iterator();
            k = 0;
            while (it.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();

                cell = detail_worksheet.getRow(detailsStartRow + k).getCell(prodManSpecCol);
                cell.setCellValue(entry.getKey());

                cell = detail_worksheet.getRow(detailsStartRow + k).getCell(prodManSpecCol + 1);
                cell.setCellValue(entry.getValue());

                k++;
            }
        }

        //re evalauting the formulas
        HSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);

        //Close the InputStream
        input_document.close();
        //Open FileOutputStream to write updates
        FileOutputStream output_file = new FileOutputStream(new File("Costing Summary.xls"));
        //write changes
        workbook.write(output_file);
        //close the stream
        output_file.close();


        //opening Costing file
        Desktop dt = Desktop.getDesktop();
        dt.open(new File("Costing Summary.xls"));
    }

    public static void main(String[] args) throws Exception {
        //for testing purposes.
        CostingSummary summary = new CostingSummary();
        try {
            SummaryObject obj = new SummaryObject("Bed Sheet", "Classic", "Capoc Material", "", "45X43", 1, 232.23, 50, 14.28);

            ArrayList<Map.Entry<String, String>> hm = new ArrayList<Map.Entry<String, String>>();
            hm.add(new SimpleEntry<String, String>("Hello", "World"));
            hm.add(new SimpleEntry<String, String>("Hello1", "World"));
            hm.add(new SimpleEntry<String, String>("Hello2", "World"));
            
            ItemSummaryObject itemObject = new ItemSummaryObject("Bed Sheet", obj, hm, hm, hm);

            summary.addItem(itemObject);
            summary.addItem(itemObject);

            summary.exportSummary();
        } catch (Exception ex) {
            //custom title, custom icon
            JOptionPane.showMessageDialog(new JFrame(),
                    "Please close any existing Costing Summary files and try again",
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}