package excel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * @author Supun Nakandala
 */
public class ItemSummaryObject {
    private String itemName;
    private SummaryObject summaryObject;
    private ArrayList<Entry<String, String>> productSpecs;
    private ArrayList<Entry<String, String>> costDecription;
    private ArrayList<Entry<String, String>> manufacSpecs;
    
    
    public ItemSummaryObject(String itemName, SummaryObject summaryObject, ArrayList<Entry<String, String>> productSpecs, ArrayList<Entry<String, String>> costDecription, ArrayList<Entry<String, String>> manufacSpecs) {
        this.itemName = itemName;
        this.summaryObject = summaryObject;
        this.productSpecs = productSpecs;
        this.costDecription = costDecription;
        this.manufacSpecs = manufacSpecs;
    }

    public String getItemName() {
        return itemName;
    }

    public SummaryObject getSummaryObject() {
        return summaryObject;
    }

    public ArrayList<Entry<String, String>> getProductSpecs() {
        return productSpecs;
    }

    public ArrayList<Entry<String, String>> getCostDecription() {
        return costDecription;
    }

    public ArrayList<Entry<String, String>> getManufacSpecs() {
        return manufacSpecs;
    }    
}
