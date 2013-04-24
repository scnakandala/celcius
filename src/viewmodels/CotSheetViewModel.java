package viewmodels;

public class CotSheetViewModel extends AbstractViewModel{
    //inpputs

    private String materialType = "";
    private String size = "";
    private String paddingType = "";
    private String taffataType = "";
    private Double widthQuiltyShrinkage = 0.0;
    private Double heightQuiltyShrinkage = 0.0;
    private Double fabricWastage = 0.0;
    private Double paddingWastage = 0.0;
    private Double taffataWastage = 0.0;
    private boolean isCustom = false;
    private int customWidth = 0;
    private int customHeight = 0;
    private boolean includeLable = false;
    private boolean includeTag = false;
    private boolean includePEBag = false;
    //outputs
    private Double fabricCost = 0.0;
    private Double paddingCost = 0.0;
    private Double taffataCost = 0.0;
    private Double threadCost = 0.0;
    private Double lableCost = 0.0;
    private Double tagCost = 0.0;
    private Double elasticCost = 0.0;
    private Double PEBagCost = 0.0;
    private Double pohCost = 0.0;
    private Double labourCost = 0.0;
    private Double totalMaterialCost = 0.0;
    private Double totalCost = 0.0;
    private Double fabricPaddingCuttingWidth = 0.0;
    private Double fabricPaddingCuttingHeight = 0.0;
    private Double taffataCuttingWidth = 0.0;
    private Double taffataCuttingHeight = 0.0;
    private Double smvValue = 0.0;

    public String getTaffataType() {
        return taffataType;
    }

    public void setTaffataType(String taffataType) {
        this.taffataType = taffataType;
    }

    public Double getTotalMaterialCost() {
        return totalMaterialCost;
    }

    public void setTotalMaterialCost(Double totalMaterialCost) {
        this.totalMaterialCost = totalMaterialCost;
    }

    public Double getFabricPaddingCuttingHeight() {
        return fabricPaddingCuttingHeight;
    }

    public void setFabricPaddingCuttingHeight(Double fabricPaddingCuttingHeight) {
        this.fabricPaddingCuttingHeight = fabricPaddingCuttingHeight;
    }

    public Double getFabricPaddingCuttingWidth() {
        return fabricPaddingCuttingWidth;
    }

    public void setFabricPaddingCuttingWidth(Double fabricPaddingCuttingWidth) {
        this.fabricPaddingCuttingWidth = fabricPaddingCuttingWidth;
    }

    public Double getTaffataCuttingHeight() {
        return taffataCuttingHeight;
    }

    public void setTaffataCuttingHeight(Double taffataCuttingHeight) {
        this.taffataCuttingHeight = taffataCuttingHeight;
    }

    public Double getTaffataCuttingWidth() {
        return taffataCuttingWidth;
    }

    public void setTaffataCuttingWidth(Double taffataCuttingWidth) {
        this.taffataCuttingWidth = taffataCuttingWidth;
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

    public Double getElasticCost() {
        return elasticCost;
    }

    public void setElasticCost(Double elasticCost) {
        this.elasticCost = elasticCost;
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

    public boolean isIncludePEBag() {
        return includePEBag;
    }

    public void setIncludePEBag(boolean includePEBag) {
        this.includePEBag = includePEBag;
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

    public Double getTaffataCost() {
        return taffataCost;
    }

    public void setTaffataCost(Double taffataCost) {
        this.taffataCost = taffataCost;
    }

    public Double getTaffataWastage() {
        return taffataWastage;
    }

    public void setTaffataWastage(Double taffataWastage) {
        this.taffataWastage = taffataWastage;
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
}
