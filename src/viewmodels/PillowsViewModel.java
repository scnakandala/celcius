package viewmodels;

public class PillowsViewModel {
    //inpputs

    private String pillowType;
    private String productRange;
    private String materialType;
    private String size;
    private Double fabricWastage;
    private String fiberType;
    private Double fiberWastage;
    private boolean isCustom = false;
    private int customWidth;
    private int customHeight;
    private boolean includeLable;
    private boolean includeTag;
    private boolean includePEBag;
    //outputs
    private Double fabricCost;
    private Double fiberCost;
    private Double fiberWeight;
    private Double threadCost;
    private Double lableCost;
    private Double tagCost;
    private Double PEBagCost;
    private Double pipingCost;
    private Double pohCost;
    private Double labourCost;
    private Double totalMaterialCost;
    private Double totalCost;
    private Double fabricCuttingWidth;
    private Double fabricCuttingHeight;
    private Double smvValue;

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

    public int getCustomHeight() {
        return customHeight;
    }

    public void setCustomHeight(int customHeight) {
        this.customHeight = customHeight;
    }

    public int getCustomWidth() {
        return customWidth;
    }

    public void setCustomWidth(int customWidth) {
        this.customWidth = customWidth;
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

    public Double getPipingCost() {
        return pipingCost;
    }

    public void setPipingCost(Double pipingCost) {
        this.pipingCost = pipingCost;
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

    public String getPillowType() {
        return pillowType;
    }

    public void setPillowType(String pillowType) {
        this.pillowType = pillowType;
    }

    public Double getFabricCuttingHeight() {
        return fabricCuttingHeight;
    }

    public void setFabricCuttingHeight(Double fabricCuttingHeight) {
        this.fabricCuttingHeight = fabricCuttingHeight;
    }

    public Double getFabricCuttingWidth() {
        return fabricCuttingWidth;
    }

    public void setFabricCuttingWidth(Double fabricCuttingWidth) {
        this.fabricCuttingWidth = fabricCuttingWidth;
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
