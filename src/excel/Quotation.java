package excel;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;
import view.MainWindow;

/**
 *
 * @author Supun Nakandala
 */
public class Quotation {

    private ArrayList<QuationObject> objects = new ArrayList<QuationObject>();
    private int startRow = 18;
    private int itemDescriptionCol = 0;
    private int rangeCol = 1;
    private int compositionCol = 2;
    private int sizeCol = 3;
    private int quantityCol = 4;
    private int unitPriceCol = 5;
    private int discountCol = 6;
    private int subTotalCol = 7;
    private int valueCol = 7;

    private ArrayList<ItemSummaryObject> items = new ArrayList<ItemSummaryObject>();
    private int summaryStartRow = 3;
    private int itemNoCol = 0;
    private int itemCol = 1;
    private int typeCol = 2;
    private int fabricTypeCol = 3;
    private int fiberPaddingCol = 4;
    private int sizeCol2 = 5;
    private int quantityCol2 = 6;
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

    public void addQuatationObject(QuationObject obj, ItemSummaryObject item) {
        objects.add(obj);
        items.add(item);
    }

    public void clearQuatation() {
        this.objects = new ArrayList<QuationObject>();
        this.items = new ArrayList<ItemSummaryObject>();
    }

    public void exportQuatation() throws Exception {
        //Read the spreadsheet that needs to be updated
        FileInputStream input_document = new FileInputStream(new File("Quotation-Template.xls"));
        //Access the workbook
        HSSFWorkbook workbook = new HSSFWorkbook(input_document);
        //Access the worksheet, so that we can update / modify it.
        HSSFSheet worksheet = workbook.getSheetAt(0);

        if (objects.size() > 0) {
            for (int i = 0; i < objects.size() - 1; i++) {
                copyRow(workbook, worksheet, startRow + i, startRow + i + 1);
            }
            Cell cell;
            for (int i = 0; i < objects.size(); i++) {
                int currentRow = startRow + i;
                QuationObject object = objects.get(i);

                cell = worksheet.getRow(currentRow).getCell(itemDescriptionCol);
                cell.setCellValue(object.getItemDescription());

                cell = worksheet.getRow(currentRow).getCell(rangeCol);
                cell.setCellValue(object.getRange());

                cell = worksheet.getRow(currentRow).getCell(compositionCol);
                cell.setCellValue(object.getComposition());

                cell = worksheet.getRow(currentRow).getCell(sizeCol);
                cell.setCellValue(object.getSize());

                cell = worksheet.getRow(currentRow).getCell(quantityCol);
                cell.setCellValue(object.getQuantity());

                cell = worksheet.getRow(currentRow).getCell(unitPriceCol);
                cell.setCellValue(object.getUnitPrice());

                cell = worksheet.getRow(currentRow).getCell(discountCol);
                cell.setCellValue(object.getDiscount());

                cell = worksheet.getRow(currentRow).getCell(valueCol);
                cell.setCellFormula("E" + (currentRow + 1) + "*F" + (currentRow + 1) + "-G" + (currentRow + 1));

            }
            cell = worksheet.getRow(startRow + objects.size()).getCell(subTotalCol);
            String start = "H" + (startRow + 1);
            String end = "H" + (startRow + objects.size());
            cell.setCellFormula("SUM(" + start + ":" + end + ")");

        }

        HSSFSheet consumption_worksheet = workbook.getSheetAt(2);
        int row = 4;
        Cell cell;
        
        int max = Math.max(MainWindow.globalFaric.size(), MainWindow.globalPadding.size());
        max = Math.max(max, MainWindow.globalTaffata.size());
        
        for(int i=0;i<max;i++){
            copyRow(workbook, consumption_worksheet, 4 + i, 4 + i + 1);
        }

        if (MainWindow.globalFaric != null) {
            Set keys = MainWindow.globalFaric.keySet();
            for (int i = 0; i < keys.size(); i++) {
                String key = (String) keys.toArray()[i];
                String val = String.format("%.2f",MainWindow.globalFaric.get(key)) + "";

                cell = consumption_worksheet.getRow(row).getCell(0);
                cell.setCellValue(key);

                cell = consumption_worksheet.getRow(row).getCell(1);
                cell.setCellValue(val);
                row++;
            }
        }

        row = 4;

        if (MainWindow.globalPadding != null) {
            Set keys = MainWindow.globalPadding.keySet();
            for (int i = 0; i < keys.size(); i++) {
                String key = (String) keys.toArray()[i];
                String val = String.format("%.2f",MainWindow.globalPadding.get(key)) + "";

                cell = consumption_worksheet.getRow(row).getCell(3);
                cell.setCellValue(key);

                cell = consumption_worksheet.getRow(row).getCell(4);
                cell.setCellValue(val);
                row++;
            }
        }

        row = 0;

        if (MainWindow.globalTaffata != null) {
            Set keys = MainWindow.globalTaffata.keySet();
            for (int i = 0; i < keys.size(); i++) {
                String key = (String) keys.toArray()[i];
                String val = String.format("%.2f",MainWindow.globalTaffata.get(key)) + "";

                cell = consumption_worksheet.getRow(row).getCell(6);
                cell.setCellValue(key);

                cell = consumption_worksheet.getRow(row).getCell(7);
                cell.setCellValue(val);
                row++;
            }
        }

        //Access the worksheet, so that we can update / modify it.
        HSSFSheet summary_worksheet = workbook.getSheetAt(1);

        //making the number of sheets required.
        int noOfItems = items.size();

        for (int i = 1; i < noOfItems; i++) {
            workbook.cloneSheet(3);
            workbook.setSheetName(i + 3, "Item " + (i + 1));
            copyRow(workbook, summary_worksheet, summaryStartRow + i - 1, summaryStartRow + i);
        }

        for (int i = 0; i < noOfItems; i++) {
            SummaryObject summary = items.get(i).getSummaryObject();
            ArrayList<Map.Entry<String, String>> productSpecs = items.get(i).getProductSpecs();
            ArrayList<Map.Entry<String, String>> costDescs = items.get(i).getCostDecription();
            ArrayList<Map.Entry<String, String>> manufacSpecs = items.get(i).getManufacSpecs();

            //adding to summary
            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(itemNoCol);
            cell.setCellValue("Item " + (i + 1));

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(itemCol);
            cell.setCellValue(summary.getItem());

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(typeCol);
            cell.setCellValue(summary.getType());

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(fabricTypeCol);
            cell.setCellValue(summary.getFabricType());

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(fiberPaddingCol);
            cell.setCellValue(summary.getFiberPadding());

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(sizeCol2);
            cell.setCellValue(summary.getSize());

            cell = summary_worksheet.getRow(summaryStartRow + i).getCell(quantityCol2);
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
            HSSFSheet detail_worksheet = workbook.getSheetAt(i + 3);

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
        FileOutputStream output_file = new FileOutputStream(new File("Quotation.xls"));
        //write changes

        workbook.write(output_file);
        //close the stream

        output_file.close();

        //opening quotation file
        Desktop dt = Desktop.getDesktop();
        dt.open(new File("Quotation.xls"));
    }
}
