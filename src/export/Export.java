package export;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Export {

    private ExportModel model;
    private String html;
    private String fileName = "celcius.html";

    public Export(ExportModel m) {
        this.model = m;
    }

    public void openFile() {
        generateHTML();
        try {
            createHTMLFile();
            openHTMLFile();
        } catch (IOException ex) {
            Logger.getLogger(Export.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateHTML() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);

        html = "<html xmlns:ice=\"http://ns.adobe.com/incontextediting\"><script src=\"includes/ice/ice.js\" type=\"text/javascript\"></script>";
        html = html + "<h1>Celcius Solutions (Pvt) Ltd</h1>";
        html = html + "<p>" + dateFormat.format(date) + "</p>";
        html = html + "<textarea cols=\"40\" rows=\"1\"></textarea>";
        html = html + "</br></br>";
        html = html + "<table width=\"342\" border=\"1\" cellspacing=\"2\" cellpadding=\"2\">";
        html = html + "<tr>";
        html = html + "<th width=\"215\" scope=\"row\"><div align=\"left\">Product Name&nbsp;</div></th>";
        html = html + "<td width=\"107\"><div align=\"right\">" + model.getProductName() + "</div></td>";
        html = html + "</tr>";
        html = html + "<tr>";
        html = html + "<th width=\"215\" scope=\"row\"><div align=\"left\">Product Range&nbsp;</div></th>";
        html = html + "<td width=\"107\"><div align=\"right\">" + model.getProductRange() + "</div></td>";
        html = html + "</tr>";
        html = html + "<tr>";
        html = html + "<th width=\"215\" scope=\"row\"><div align=\"left\">Total Material Cost Per Unit&nbsp;</div></th>";
        html = html + "<td width=\"107\"><div align=\"right\">" + format.format(model.getTotalMaterialCost()) + "</div></td>";
        html = html + "</tr>";
        html = html + "<tr>";
        html = html + "<th width=\"215\" scope=\"row\"><div align=\"left\">Labour Cost Per Unit&nbsp;</div></th>";
        html = html + "<td width=\"107\"><div align=\"right\">" + format.format(model.getLabourCost()) + "</div></td>";
        html = html + "</tr>";
        html = html + "<tr>";
        html = html + "<th width=\"215\" scope=\"row\"><div align=\"left\">Production Overheads Per Unit&nbsp;</div></th>";
        html = html + "<td width=\"107\"><div align=\"right\">" + format.format(model.getProductionOverHead()) + "</div></td>";
        html = html + "</tr>";
        html = html + "<tr>";
        html = html + "<th width=\"215\" scope=\"row\"><div align=\"left\">Total Cost Per Unit&nbsp;</div></th>";
        html = html + "<td width=\"107\"><div align=\"right\">" + format.format(model.getTotalCostPerUnit()) + "</div></td>";
        html = html + "</tr>";
        html = html + "<tr>";
        html = html + "<th width=\"215\" scope=\"row\"><div align=\"left\">Net Selling Price&nbsp;</div></th>";
        html = html + "<td width=\"107\"><div align=\"right\">" + format.format(model.getNetSellingPrice()) + "</div></td>";
        html = html + "</tr>";
        html = html + "<tr>";
        html = html + "<th width=\"215\" scope=\"row\"><div align=\"left\">Taxes&nbsp;</div></th>";
        html = html + "<td width=\"107\"><div align=\"right\">" + format.format(model.getTaxes()) + "</div></td>";
        html = html + "</tr>";
        html = html + "<tr>";
        html = html + "<th width=\"215\" scope=\"row\"><div align=\"left\">Gross Selling Price&nbsp;</div></th>";
        html = html + "<td width=\"107\"><div align=\"right\"><b>" + format.format(model.getGrossSellingPrice()) + "</b></div></td>";
        html = html + "</tr>";
        html = html + "</table>";
    }

    private void createHTMLFile() throws IOException {
        File file = new File(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(html, 0, html.length());
        writer.close();
    }

    private void openHTMLFile() throws IOException {
        File file = new File(fileName);
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
    }

    public static void main(String[] args) throws IOException {
        ExportModel model = new ExportModel();
        model.setProductName("Cot Sheet");
        model.setProductRange("Classic");
        model.setTotalMaterialCost(1002.02);

        Export export = new Export(model);
        export.openFile();
    }
}
