package export;

public class ExportModel {

    private String productName = "";
    private String productRange = "";
    private String productSize = "";
    private Double totalMaterialCost = 0.0;
    private Double labourCost = 0.0;
    private Double productionOverHead = 0.0;
    private Double totalCostPerUnit = 0.0;
    private Double netSellingPrice = 0.0;
    private Double taxes = 0.0;
    private Double grossSellingPrice = 0.0;

    public Double getProductionOverHead() {
        return productionOverHead;
    }

    public void setProductionOverHead(Double productionOverHead) {
        this.productionOverHead = productionOverHead;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public Double getGrossSellingPrice() {
        return grossSellingPrice;
    }

    public void setGrossSellingPrice(Double grossSellingPrice) {
        this.grossSellingPrice = grossSellingPrice;
    }

    public Double getLabourCost() {
        return labourCost;
    }

    public void setLabourCost(Double labourCost) {
        this.labourCost = labourCost;
    }

    public Double getNetSellingPrice() {
        return netSellingPrice;
    }

    public void setNetSellingPrice(Double netSellingPrice) {
        this.netSellingPrice = netSellingPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductRange() {
        return productRange;
    }

    public void setProductRange(String productRange) {
        this.productRange = productRange;
    }

    public Double getTaxes() {
        return taxes;
    }

    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }

    public Double getTotalCostPerUnit() {
        return totalCostPerUnit;
    }

    public void setTotalCostPerUnit(Double totalCostPerUnit) {
        this.totalCostPerUnit = totalCostPerUnit;
    }

    public Double getTotalMaterialCost() {
        return totalMaterialCost;
    }

    public void setTotalMaterialCost(Double totalMaterialCost) {
        this.totalMaterialCost = totalMaterialCost;
    }
}
