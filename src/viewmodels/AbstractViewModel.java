package viewmodels;

public class AbstractViewModel {
    //inputs
    private Double margin = 0.0;
    private Double taxRate = 0.0;


    //outputs
    private Double netSellingPrice = 0.0;
    private Double taxes = 0.0;
    private Double grossSellingPrice = 0.0;

    public Double getMargin() {
        return margin;
    }

    public void setMargin(Double margin) {
        this.margin = margin;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Double getGrossSellingPrice() {
        return grossSellingPrice;
    }

    public void setGrossSellingPrice(Double grossSellingPrice) {
        this.grossSellingPrice = grossSellingPrice;
    }

    public Double getNetSellingPrice() {
        return netSellingPrice;
    }

    public void setNetSellingPrice(Double netSellingPrice) {
        this.netSellingPrice = netSellingPrice;
    }

    public Double getTaxes() {
        return taxes;
    }

    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }
}
