package excel;

/**
 *
 * @author Supun Nakandala
 */
public class QuationObject {

    private String itemDescription;
    private String Range;
    private String Composition;
    private String size;
    private int quantity;
    private double unitPrice;
    private double discount;
    private double value;

    public QuationObject(String itemDescription, String Range, String Composition, String size, int quantity, double unitPrice, double discount, double value) {
        this.itemDescription = itemDescription;
        this.Range = Range;
        this.Composition = Composition;
        this.size = size;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.value = value;
    }

    public QuationObject(String itemDescription, String Range, String Composition, String size, int quantity, double unitPrice) {
        this.itemDescription = itemDescription;
        this.Range = Range;
        this.Composition = Composition;
        this.size = size;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = 0.0;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getRange() {
        return Range;
    }

    public String getComposition() {
        return Composition;
    }

    public String getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int q) {
        this.quantity = q;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public double getValue() {
        return value;
    }
}
