package viewmodels;

public class PillowProtectorViewModel extends AbstractViewModel {

    //inpputs
    private String productRange = "";
    private String materialType = "";
    private String size = "";
    private Double height = 0.0;
    private Double wastage = 0.0;
    private boolean isCustom = false;
    private Double customWidth = 0.0;
    private Double customLength = 0.0;
    private boolean includeLable = false;
    private boolean includeTag = false;
    private boolean includePEBag = false;
    private boolean includeCardboard = false;
    private boolean useNonWoven = false;
    private String taffataType = "";
    private String paddingType = "";

    //outputs
    private Double fabricCost = 0.0;
    private Double threadCost = 0.0;
    private Double lableCost = 0.0;
    private Double tagCost = 0.0;
    private Double peBagCost = 0.0;
    private Double cardBoardCost = 0.0;
    private Double elasticCost = 0.0;
    private Double pohCost = 0.0;
    private Double labourCost = 0.0;
    private Double nonWovenTaffataCost = 0.0;
    private Double paddingCost = 0.0;
    private Double totalCost = 0.0;
    private Double cuttingWidth = 0.0;
    private Double zipperCost = 0.0;
    private Double cuttingHeight = 0.0;
    private Double smvValue = 0.0;
    private Double totalMaterialCost = 0.0;
    
    private boolean isPillowSlip = false;

    public Double getZipperCost() {
        return zipperCost;
    }

    public void setZipperCost(Double zipperCost) {
        this.zipperCost = zipperCost;
    }

    
    
    public Double getNonWovenTaffataCost() {
        return nonWovenTaffataCost;
    }

    public void setNonWovenTaffataCost(Double nonWovenTaffataCost) {
        this.nonWovenTaffataCost = nonWovenTaffataCost;
    }

    public Double getPaddingCost() {
        return paddingCost;
    }

    public void setPaddingCost(Double paddingCost) {
        this.paddingCost = paddingCost;
    }
    
    public boolean isUseNonWoven() {
        return useNonWoven;
    }

    public void setUseNonWoven(boolean useNonWoven) {
        this.useNonWoven = useNonWoven;
    }

    public String getTaffataType() {
        return taffataType;
    }

    public void setTaffataType(String taffataType) {
        this.taffataType = taffataType;
    }

    public String getPaddingType() {
        return paddingType;
    }

    public void setPaddingType(String paddingType) {
        this.paddingType = paddingType;
    }
    
    public Double getTotalMaterialCost() {
        return totalMaterialCost;
    }

    public boolean isIncludePEBag() {
        return includePEBag;
    }

    public void setIncludePEBag(boolean includePEBag) {
        this.includePEBag = includePEBag;
    }

    public Double getPeBagCost() {
        return peBagCost;
    }

    public void setPeBagCost(Double peBagCost) {
        this.peBagCost = peBagCost;
    }

    public void setTotalMaterialCost(Double totalMaterialCost) {
        this.totalMaterialCost = totalMaterialCost;
    }

    public Double getCuttingHeight() {
        return cuttingHeight;
    }

    public void setCuttingHeight(Double cuttingHeight) {
        this.cuttingHeight = cuttingHeight;
    }

    public Double getCuttingWidth() {
        return cuttingWidth;
    }

    public void setCuttingWidth(Double cuttingWidth) {
        this.cuttingWidth = cuttingWidth;
    }

    public Double getSmvValue() {
        return smvValue;
    }

    public void setSmvValue(Double smvValue) {
        this.smvValue = smvValue;
    }

    public Double getCustomLength() {
        return customLength;
    }

    public void setCustomLength(Double customLength) {
        this.customLength = customLength;
    }

    public Double getCustomDiameter() {
        return customWidth;
    }

    public void setCustomDiameter(Double customDiameter) {
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

    public boolean isIncludeSealBag() {
        return includePEBag;
    }

    public void setIncludeSealBag(boolean includeSealBag) {
        this.includePEBag = includeSealBag;
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

    public Double getPEBagCost() {
        return peBagCost;
    }

    public void setPEBagCost(Double peBagCost) {
        this.peBagCost = peBagCost;
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

    public Double getWastage() {
        return wastage;
    }

    public void setWastage(Double wastage) {
        this.wastage = wastage;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getCustomWidth() {
        return customWidth;
    }

    public void setCustomWidth(Double customWidth) {
        this.customWidth = customWidth;
    }

    public boolean isIncludeCardboard() {
        return includeCardboard;
    }

    public void setIncludeCardboard(boolean includeCardboard) {
        this.includeCardboard = includeCardboard;
    }

    public Double getCardBoardCost() {
        return cardBoardCost;
    }

    public void setCardBoardCost(Double cardBoardCost) {
        this.cardBoardCost = cardBoardCost;
    }

    public void setElasticCost(Double elasticCost) {
        this.elasticCost = elasticCost;
    }

    public Double getElasticCost() {
        return this.elasticCost;
    }

    public boolean isIsPillowSlip() {
        return isPillowSlip;
    }

    public void setIsPillowSlip(boolean isPillowSlip) {
        this.isPillowSlip = isPillowSlip;
    }    
}
