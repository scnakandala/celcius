package viewmodels;

import java.util.HashMap;
import java.util.HashSet;

public class AbstractViewModel {
    //inputs
    private Double margin = 0.0;
    private Double taxRate = 0.0;
    private Double otherCost = 0.0;
    
    public Double getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(Double otherCost) {
        this.otherCost = otherCost;
    }
    
    //outputs
    private Double netSellingPrice = 0.0;
    private Double taxes = 0.0;
    private Double grossSellingPrice = 0.0;

    public HashMap getFabric() {
        return fabric;
    }

    public void setFabric(HashMap fabric) {
        this.fabric = fabric;
    }

    public HashMap getTaffata() {
        return taffata;
    }

    public void setTaffata(HashMap taffata) {
        this.taffata = taffata;
    }

    public HashMap getPadding() {
        return padding;
    }

    public void setPadding(HashMap padding) {
        this.padding = padding;
    }
    
    private HashMap fabric = new HashMap();
    private HashMap taffata = new HashMap();
    private HashMap padding = new HashMap();

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
