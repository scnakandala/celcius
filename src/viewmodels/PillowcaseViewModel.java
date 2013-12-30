package viewmodels;

public class PillowcaseViewModel extends AbstractViewModel{
    //inpputs
    private String productRange = "";
    private String materialType = "";
    private String size = "";
    private Double wastage = 0.0;
    private String pillowcaseType = "";
    private boolean isCustom = false;
    private Double flap = 0.0;
    private Double frill = 0.0;
    private Double customWidth = 0.0;
    private Double customHeight = 0.0;
    private boolean includeLable = false;
    private boolean includeTag = false;
    private boolean includeSealBag =  false;
    private boolean includeCardBoard = false;
    
    //outputs
    private Double fabricCost = 0.0;
    private Double threadCost = 0.0;
    private Double lableCost = 0.0;
    private Double tagCost = 0.0;
    private Double cardboardCost = 0.0;
    private Double sealBagCost = 0.0;
    private Double pohCost = 0.0;
    private Double labourCost = 0.0;
    private Double totalCost = 0.0;
    private Double cuttingWidth = 0.0;
    private Double cuttingHeight = 0.0;
    private Double smvValue = 0.0;
    private Double totalMaterialCost = 0.0;

    public Double getTotalMaterialCost() {
        return totalMaterialCost;
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

    public Double getCardboardCost() {
        return cardboardCost;
    }

    public void setCardboardCost(Double cardboardCost) {
        this.cardboardCost = cardboardCost;
    }

    public Double getCustomHeight() {
        return customHeight;
    }

    public void setCustomHeight(Double customHeight) {
        this.customHeight = customHeight;
    }

    public Double getCustomWidth() {
        return customWidth;
    }

    public void setCustomWidth(Double customWidth) {
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
        return includeSealBag;
    }

    public void setIncludeSealBag(boolean includeSealBag) {
        this.includeSealBag = includeSealBag;
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

    public Double getSealBagCost() {
        return sealBagCost;
    }

    public void setSealBagCost(Double sealBagCost) {
        this.sealBagCost = sealBagCost;
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

    public String getPillowcaseType() {
        return pillowcaseType;
    }

    public void setPillowcaseType(String pillowcaseType) {
        this.pillowcaseType = pillowcaseType;
    }

    public boolean isIncludeCardBoard() {
        return includeCardBoard;
    }

    public void setIncludeCardBoard(boolean includeCardBoard) {
        this.includeCardBoard = includeCardBoard;
    }

    public Double getFlap() {
        return flap;
    }

    public void setFlap(Double flap) {
        this.flap = flap;
    }

    public Double getFrill() {
        return frill;
    }

    public void setFrill(Double frill) {
        this.frill = frill;
    }
}
