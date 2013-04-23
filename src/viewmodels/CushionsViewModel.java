package viewmodels;

public class CushionsViewModel {
    //inpputs

    private String productRange = "";
    private String materialType = "";
    private String size = "";
    private Double fabricWastage = 0.0;
    private String fiberType = "";
    private Double fiberWastage = 0.0;
    private boolean isCustom = false;
    private int customWidthHeight = 0;
    private boolean includeLable = false;
    private boolean includeTag = false;
    private boolean includePEBag = false;
    //outputs
    private Double fabricCost = 0.0;
    private Double fiberCost = 0.0;
    private Double fiberWeight = 0.0;
    private Double threadCost = 0.0;
    private Double lableCost = 0.0;
    private Double tagCost = 0.0;
    private Double PEBagCost = 0.0;
    private Double pohCost = 0.0;
    private Double labourCost = 0.0;
    private Double totalMaterialCost = 0.0;
    private Double totalCost = 0.0;
    private Double fabricCuttingWidthHeight = 0.0;
    private Double smvValue = 0.0;

    public String getFiberType() {
        return fiberType;
    }

    public void setFiberType(String fiberType) {
        this.fiberType = fiberType;
    }

    
    public Double getTotalMaterialCost() {
        return totalMaterialCost;
    }

    public void setTotalMaterialCost(Double totalMaterialCost) {
        this.totalMaterialCost = totalMaterialCost;
    }

    public Double getSmvValue() {
        return smvValue;
    }

    public void setSmvValue(Double smvValue) {
        this.smvValue = smvValue;
    }

    public int getCustomWidthHeight() {
        return customWidthHeight;
    }

    public void setCustomWidthHeight(int customWidthHeight) {
        this.customWidthHeight = customWidthHeight;
    }

    public Double getFabricCost() {
        return fabricCost;
    }

    public void setFabricCost(Double fabricCost) {
        this.fabricCost = fabricCost;
    }

    public boolean isIncludeLable() {
        return includeLable;
    }

    public void setIncludeLable(boolean includeLable) {
        this.includeLable = includeLable;
    }

    public boolean isIncludeTag() {
        return includeTag;
    }

    public void setIncludeTag(boolean includeTag) {
        this.includeTag = includeTag;
    }

    public boolean isIsCustom() {
        return isCustom;
    }

    public void setIsCustom(boolean isCustom) {
        this.isCustom = isCustom;
    }

    public Double getLableCost() {
        return lableCost;
    }

    public void setLableCost(Double lableCost) {
        this.lableCost = lableCost;
    }

    public Double getLabourCost() {
        return labourCost;
    }

    public void setLabourCost(Double labourCost) {
        this.labourCost = labourCost;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public Double getPohCost() {
        return pohCost;
    }

    public void setPohCost(Double pohCost) {
        this.pohCost = pohCost;
    }

    public String getProductRange() {
        return productRange;
    }

    public void setProductRange(String productRange) {
        this.productRange = productRange;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getTagCost() {
        return tagCost;
    }

    public Double getPEBagCost() {
        return PEBagCost;
    }

    public void setPEBagCost(Double PEBagCost) {
        this.PEBagCost = PEBagCost;
    }

    public Double getFabricWastage() {
        return fabricWastage;
    }

    public void setFabricWastage(Double fabricWastage) {
        this.fabricWastage = fabricWastage;
    }
    
    public boolean isIncludePEBag() {
        return includePEBag;
    }

    public void setIncludePEBag(boolean includePEBag) {
        this.includePEBag = includePEBag;
    }

    public void setTagCost(Double tagCost) {
        this.tagCost = tagCost;
    }

    public Double getThreadCost() {
        return threadCost;
    }

    public void setThreadCost(Double threadCost) {
        this.threadCost = threadCost;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Double getFabricCuttingWidthHeight() {
        return fabricCuttingWidthHeight;
    }

    public void setFabricCuttingWidthHeight(Double fabricCuttingWidthHeight) {
        this.fabricCuttingWidthHeight = fabricCuttingWidthHeight;
    }



    public Double getFiberCost() {
        return fiberCost;
    }

    public void setFiberCost(Double fiberCost) {
        this.fiberCost = fiberCost;
    }

    public Double getFiberWastage() {
        return fiberWastage;
    }

    public void setFiberWastage(Double fiberWastage) {
        this.fiberWastage = fiberWastage;
    }

    public Double getFiberWeight() {
        return fiberWeight;
    }

    public void setFiberWeight(Double fiberWight) {
        this.fiberWeight = fiberWight;
    }

}
