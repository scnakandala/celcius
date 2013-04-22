package viewmodels;

public class DovetsViewModel {
    //inpputs

    private String duvetType;
    private String productRange;
    private String materialType;
    private String size;
    private String paddingType;
    private Double widthQuiltyShrinkage;
    private Double heightQuiltyShrinkage;
    private Double fabricWastage;
    private Double paddingWastage;
    private String fiberType;
    private Double fillingGsm;
    private Double fiberWastage;
    private boolean isCustom = false;
    private int customWidth;
    private int customHeight;
    private boolean includeLable;
    private boolean includeTag;
    private boolean includePEBag;
    private boolean includeNonWovenBag;
    //outputs
    private Double fabricCost;
    private Double paddingCost;
    private Double fiberCost;
    private Double threadCost;
    private Double lableCost;
    private Double tagCost;
    private Double PEBagCost;
    private Double pipingCost;
    private Double nonWovenBagCost;
    private Double pohCost;
    private Double labourCost;
    private Double totalMaterialCost;
    private Double totalCost;
    private Double fabricCuttingWidth;
    private Double fabricCuttingHeight;
    private Double fiberWeight;
    private Double smvValue;

    public String getFiberType() {
        return fiberType;
    }

    public void setFiberType(String fiberType) {
        this.fiberType = fiberType;
    }

    public Double getFillingGsm() {
        return fillingGsm;
    }

    public void setFillingGsm(Double fillingGsm) {
        this.fillingGsm = fillingGsm;
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

    public Double getHeightQuiltyShrinkage() {
        return heightQuiltyShrinkage;
    }

    public void setHeightQuiltyShrinkage(Double heightQuiltyShrinkage) {
        this.heightQuiltyShrinkage = heightQuiltyShrinkage;
    }

    public boolean isIncludeNonWovenBag() {
        return includeNonWovenBag;
    }

    public void setIncludeNonWovenBag(boolean includeNonWovenBag) {
        this.includeNonWovenBag = includeNonWovenBag;
    }

    public boolean isIncludePEBag() {
        return includePEBag;
    }

    public void setIncludePEBag(boolean includePEBag) {
        this.includePEBag = includePEBag;
    }

    public Double getNonWovenBagCost() {
        return nonWovenBagCost;
    }

    public void setNonWovenBagCost(Double nonWovenBagCost) {
        this.nonWovenBagCost = nonWovenBagCost;
    }

    public Double getPaddingCost() {
        return paddingCost;
    }

    public void setPaddingCost(Double paddingCost) {
        this.paddingCost = paddingCost;
    }

    public String getPaddingType() {
        return paddingType;
    }

    public void setPaddingType(String paddingType) {
        this.paddingType = paddingType;
    }

    public Double getPaddingWastage() {
        return paddingWastage;
    }

    public void setPaddingWastage(Double paddingWastage) {
        this.paddingWastage = paddingWastage;
    }

    public Double getPipingCost() {
        return pipingCost;
    }

    public void setPipingCost(Double pipingCost) {
        this.pipingCost = pipingCost;
    }

    public Double getWidthQuiltyShrinkage() {
        return widthQuiltyShrinkage;
    }

    public void setWidthQuiltyShrinkage(Double widthQuiltyShrinkage) {
        this.widthQuiltyShrinkage = widthQuiltyShrinkage;
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

    public String getDuvetType() {
        return duvetType;
    }

    public void setDuvetType(String duvetType) {
        this.duvetType = duvetType;
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
