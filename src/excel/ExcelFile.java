package excel;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Supun Nakandala
 */
public class ExcelFile {

    private HSSFWorkbook workbook;
    private int hOffset;
    private int vOffset;
    private int numberOfItems;

    public ExcelFile() {
        hOffset = 0;
        vOffset = 2;
        numberOfItems = 0;
        workbook = new HSSFWorkbook();
        initialize();
    }

    private void initialize() {
//        HSSFSheet sheet = workbook.createSheet("Sample sheet");
//
//        Map<String, Object[]> data = new HashMap<String, Object[]>();
//        data.put("1", new Object[]{"Emp No.", "Name", "Salary"});
//        data.put("2", new Object[]{1d, "John", 1500000d});
//        data.put("3", new Object[]{2d, "Sam", 800000d});
//        data.put("4", new Object[]{3d, "Dean", 700000d});
//
//        Set<String> keyset = data.keySet();
//        int rownum = 0;
//        for (String key : keyset) {
//            Row row = sheet.createRow(rownum++);
//            Object[] objArr = data.get(key);
//            int cellnum = 0;
//            for (Object obj : objArr) {
//                Cell cell = row.createCell(cellnum++);
//                if (obj instanceof Date) {
//                    cell.setCellValue((Date) obj);
//                } else if (obj instanceof Boolean) {
//                    cell.setCellValue((Boolean) obj);
//                } else if (obj instanceof String) {
//                    cell.setCellValue((String) obj);
//                } else if (obj instanceof Double) {
//                    cell.setCellValue((Double) obj);
//                }
//            }
//        }

        HSSFSheet sheet = workbook.createSheet("Summary Sheet");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(hOffset + 0);
        cell.setCellValue("Summary");

        row = sheet.createRow(vOffset + 0);
        cell = row.createCell(hOffset + 0);
        cell.setCellValue("Item Number");

        cell = row.createCell(hOffset + 1);
        cell.setCellValue("Item");

        cell = row.createCell(hOffset + 2);
        cell.setCellValue("Type");

        cell = row.createCell(hOffset + 3);
        cell.setCellValue("Fabric Type");

        cell = row.createCell(hOffset + 4);
        cell.setCellValue("Fiber/Padding");

        cell = row.createCell(hOffset + 5);
        cell.setCellValue("Size");

        cell = row.createCell(hOffset + 6);
        cell.setCellValue("Quantity");

        cell = row.createCell(hOffset + 7);
        cell.setCellValue("Gross Selling Price");

        cell = row.createCell(hOffset + 8);
        cell.setCellValue("Price");

    }

    public void export() {
        try {
            FileOutputStream out = new FileOutputStream(new File("\\costing.xls"));
            workbook.write(out);
            out.close();
            Desktop dt = Desktop.getDesktop();
            dt.open(new File("\\costing.xls"));
        } catch (Exception e) {
            //dialog for error in opening the excel file
        }
    }

    public void addOrderItem(String[] summary, String[][] specs, String[][] cpus, String[][] manParams, String title) {
        HSSFSheet sheet = workbook.getSheet("Summary Sheet");
        numberOfItems++;
        Row row = sheet.createRow(vOffset + numberOfItems);
        Cell cell = row.createCell(hOffset + 0);
        cell.setCellValue(Double.parseDouble("" + numberOfItems));

        cell = row.createCell(hOffset + 1);
        cell.setCellValue(summary[0]);

        cell = row.createCell(hOffset + 2);
        cell.setCellValue(summary[1]);

        cell = row.createCell(hOffset + 3);
        cell.setCellValue(summary[2]);

        cell = row.createCell(hOffset + 4);
        cell.setCellValue(summary[3]);

        cell = row.createCell(hOffset + 5);
        cell.setCellValue(summary[4]);

        cell = row.createCell(hOffset + 6);
        cell.setCellValue(Double.parseDouble(summary[5]));

        cell = row.createCell(hOffset + 7);
        cell.setCellValue(Double.parseDouble(summary[6].replaceAll(",", "")));

        cell = row.createCell(hOffset + 8);
        cell.setCellValue(summary[7]);

        HSSFSheet itemSheet = workbook.createSheet("Item " + numberOfItems);

        row = itemSheet.createRow(0);
        cell = row.createCell(hOffset + 0);
        cell.setCellValue(title);

        int row_number = vOffset;

        row_number += 2;
        row = itemSheet.createRow(row_number);
        cell = row.createCell(hOffset + 0);
        cell.setCellValue("Product Specifications");
        row_number++;
        for (int i = 0; i < specs[0].length; i++) {
            row = itemSheet.createRow(row_number);
            cell = row.createCell(hOffset + 0);
            cell.setCellValue(specs[0][i]);
            cell = row.createCell(hOffset + 1);
            cell.setCellValue(specs[1][i]);
            row_number++;
        }
        row_number++;
        row = itemSheet.createRow(row_number);
        cell = row.createCell(hOffset + 0);
        cell.setCellValue("Cost Per Unit");
        row_number++;
        for (int i = 0; i < cpus[0].length; i++) {
            row = itemSheet.createRow(row_number);
            cell = row.createCell(hOffset + 0);
            cell.setCellValue(cpus[0][i]);
            cell = row.createCell(hOffset + 1);
            cell.setCellValue(cpus[1][i]);
            row_number++;
        }
        row_number++;
        row = itemSheet.createRow(row_number);
        cell = row.createCell(hOffset + 0);
        cell.setCellValue("Manufacturing Parameters");
        row_number++;
        for (int i = 0; i < manParams[0].length; i++) {
            row = itemSheet.createRow(row_number);
            cell = row.createCell(hOffset + 0);
            cell.setCellValue(manParams[0][i]);
            cell = row.createCell(hOffset + 1);
            cell.setCellValue(manParams[1][i]);
            row_number++;
        }
        row_number++;
    }
}