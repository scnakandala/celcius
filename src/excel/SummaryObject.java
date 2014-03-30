package excel;

/**
 *
 * @author Supun Nakandala
 */
public class SummaryObject {

    private String item;
    private String type;
    private String fabricType;
    private String fiberPadding;
    private String size;
    private int quantity;
    private double costPerUnit;
    private double markUp;
    private double tax;

    public SummaryObject(String item, String type, String fabricType, String fiberPadding, String size, int quantity, double costPerUnit, double markUp, double tax) {
        this.item = item;
        this.type = type;
        this.fabricType = fabricType;
        this.fiberPadding = fiberPadding;
        this.size = size;
        this.quantity = quantity;
        this.costPerUnit = costPerUnit;
        this.markUp = markUp;
        this.tax = tax;
    }

    public String getItem() {
        return item;
    }

    public String getType() {
        return type;
    }

    public String getFabricType() {
        return fabricType;
    }

    public String getFiberPadding() {
        return fiberPadding;
    }

    public String getSize() {
        return size;
    }

    public void setQuantity(int q) {
        this.quantity = q;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCostPerUnit() {
        return costPerUnit;
    }

    public double getMarkUp() {
        return markUp;
    }

    public double getTax() {
        return tax;
    }
}
