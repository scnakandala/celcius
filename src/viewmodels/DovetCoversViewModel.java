package viewmodels;

public class DovetCoversViewModel {
    //inpputs

    private String productRange;
    private String materialType;
    private String size;
    private String duvetCoverType;
    private Double wastage;
    private Double flap;
    private boolean isCustom = false;
    private int customWidth;
    private int customHeight;
    private boolean includeLable;
    private boolean includeTag;
    private boolean includeSealBag;
    private boolean includeCardBoard;
    //outputs
    private Double fabricCost;
    private Double threadCost;
    private Double lableCost;
    private Double tagCost;
    private Double cardboardCost;
    private Double sealBagCost;
    private Double pohCost;
    private Double labourCost;
    private Double totalCost;
    private Double cuttingWidth;
    private Double cuttingHeight;
    private Double smvValue;
    private Double velcoCost;
    private Double buttonCost;
    private Double zipperCost;
    private Double totalMaterialCost;

    public Double getTotalMaterialCost() {
        return totalMaterialCost;
    }

    public void setTotalMaterialCost(Double totalMaterialCost) {
        this.totalMaterialCost = totalMaterialCost;
    }
    
    public Double getButtonCost() {
        return buttonCost;
    }

    public void setButtonCost(Double buttonCost) {
        this.buttonCost = buttonCost;
    }

    public Double getVelcoCost() {
        return velcoCost;
    }

    public void setVelcoCost(Double velcoCost) {
        this.velcoCost = velcoCost;
    }

    public Double getZipperCost() {
        return zipperCost;
    }

    public void setZipperCost(Double zipperCost) {
        this.zipperCost = zipperCost;
    }

    public boolean isIncludeCardBoard() {
        return includeCardBoard;
    }

    public void setIncludeCardBoard(boolean includeCardBoard) {
        this.includeCardBoard = includeCardBoard;
    }

    public Double getCuttingHeight() {
        return cuttingHeight;
    }

    public void setCuttingHeight(Double cuttingHeight) {
        this.cuttingHeight = cuttingHeight;
    }

    public String getDuvetCoverType() {
        return duvetCoverType;
    }

    public Double getFlap() {
        return flap;
    }

    public void setFlap(Double flap) {
        this.flap = flap;
    }

    public void setDuvetCoverType(String duvetCoverType) {
        this.duvetCoverType = duvetCoverType;
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
}
