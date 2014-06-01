package logic;

import algorithms.Approximate;
import dataaccess.MattresProtectorsDataAccess;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import viewmodels.MettresProtectorViewModel;

public class MattresProtectorLogic {

    public static String[] getProductRanges() {
        try {
            return MattresProtectorsDataAccess.getInstance().getProductRanges();
        } catch (SQLException ex) {
            Logger.getLogger(MattresProtectorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes() {
        try {
            return MattresProtectorsDataAccess.getInstance().getMaterialTypes();
        } catch (SQLException ex) {
            Logger.getLogger(MattresProtectorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes(String range) {
        try {
            return MattresProtectorsDataAccess.getInstance().getMaterialTypes(range);
        } catch (SQLException ex) {
            Logger.getLogger(MattresProtectorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getTaffataTypes() {
        try {
            return MattresProtectorsDataAccess.getInstance().getTaffataTypes();
        } catch (SQLException ex) {
            Logger.getLogger(MattresProtectorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getPaddingTypes() {
        try {
            return MattresProtectorsDataAccess.getInstance().getPaddingTypes();
        } catch (SQLException ex) {
            Logger.getLogger(MattresProtectorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMettresProtectorSizes() {
        try {
            return MattresProtectorsDataAccess.getInstance().getMettressProtectorSizes();
        } catch (SQLException ex) {
            Logger.getLogger(MattresProtectorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static MettresProtectorViewModel getCostPerUnit(MettresProtectorViewModel mCost) {
        try {
            Double fabricPrice = MattresProtectorsDataAccess.getInstance().getMaterialPrice(mCost.getMaterialType());
            Integer materialWidth = MattresProtectorsDataAccess.getInstance().getMaterialWidth(mCost.getMaterialType());
            Double fabricWastage = mCost.getFabricWastage();

            Double taffataPrice = MattresProtectorsDataAccess.getInstance().getTaffataPrice(mCost.getTaffataType());
            Double taffataWidth = MattresProtectorsDataAccess.getInstance().getTaffataWidth(mCost.getTaffataType());
            Double taffataWastage = mCost.getTaffataWastage();

            Double paddingPrice = MattresProtectorsDataAccess.getInstance().getPaddingPrice(mCost.getPaddingType());
            Double paddingWidth = MattresProtectorsDataAccess.getInstance().getPaddingWidth(mCost.getPaddingType());
            Double paddingWastage = mCost.getPaddingWastage();

            Double widthQuitingShrinkage = mCost.getWidthQuiltyShrinkage();
            Double hightQuitingShrinkage = mCost.getHeightQuiltyShrinkage();

            Double width, height;
            Double labelCost, tagCost, threadCost, nonWovenBagCost, pipingCost, peBagCost, smv, elasticCost;
            if (mCost.isIsCustom()) {
                width = mCost.getCustomWidth();
                height = mCost.getCustomHeight();

                if (mCost.isIncludeTag()) {
                    tagCost = MattresProtectorsDataAccess.getInstance().getTagCost();
                } else {
                    tagCost = 0.0;
                }

                if (mCost.isIncludeLable()) {
                    labelCost = MattresProtectorsDataAccess.getInstance().getLableCost();
                } else {
                    labelCost = 0.0;
                }

                threadCost = MattresProtectorsDataAccess.getInstance().getThreadCost();

                //smv = has to calculate
                double[][] arr = MattresProtectorsDataAccess.getInstance().getSMVXYPairs();
                Approximate cFitting = new Approximate(arr[0], arr[1]);
                smv = cFitting.getApproximatedValue(((double) height + width));
            } else {
                width = Double.parseDouble(mCost.getSize().split("X")[0]);
                height = Double.parseDouble(mCost.getSize().split("X")[1]);

                tagCost = MattresProtectorsDataAccess.getInstance().getTagCost();
                labelCost = MattresProtectorsDataAccess.getInstance().getLableCost();
                threadCost = MattresProtectorsDataAccess.getInstance().getThreadCost();
                smv = MattresProtectorsDataAccess.getInstance().getSMVValue(mCost.getSize());
            }

            mCost.setSmvValue(smv);

            //Fabric Padding cutting sizes
            Double fabricPaddingCutWidth = (width + 1.5) * (1 + widthQuitingShrinkage / 100);
            Double fabricPaddingCutHeight = (height + 1.5) * (1 + hightQuitingShrinkage / 100);

            mCost.setFabricPaddingCuttingWidth(fabricPaddingCutWidth);
            mCost.setFabricPaddingCuttingHeight(fabricPaddingCutHeight);

            //Taffata Cut Sizes
            Double taffataCutWidth = (width + 2.5);
            Double taffataCutHeight = (height + 2.5);

            mCost.setTaffataCuttingWidth(taffataCutWidth);
            mCost.setTaffataCuttingHeight(taffataCutHeight);

            //Piping cost
            if ((mCost.isIsCustom() && mCost.isIncludePiping()) || !mCost.isIsCustom()) {
                pipingCost = 2 * (width + height + 3)/ 36.0 * MattresProtectorsDataAccess.getInstance().getPipingCost();
            } else {
                pipingCost = 0.0;
            }

            //pe bag cost
            if ((mCost.isIsCustom() && mCost.isIncludePEBag()) || !mCost.isIsCustom()) {
                peBagCost = MattresProtectorsDataAccess.getInstance().getPEBagCost();
            } else {
                peBagCost = 0.0;
            }

            //elastic cost
            elasticCost = 68.0 / 36 * MattresProtectorsDataAccess.getInstance().getElasticCost();

            //fabric cost
            Double fabricPaddingCutArea = fabricPaddingCutWidth * fabricPaddingCutHeight;

            Double fabricPricePerUnitInch = fabricPrice / (materialWidth * 36);
            Double fabricCost = (fabricPricePerUnitInch * fabricPaddingCutArea) * (1 + fabricWastage / 100);

            /**Material Consumption***/
            double materialConsumption = fabricPaddingCutArea/(materialWidth*39.4) * (1 + fabricWastage/100);
            HashMap fabric = new HashMap();
            fabric.put(mCost.getMaterialType(), materialConsumption+"");
            mCost.setFabric(fabric);
            
            //there are non usable fabric wastages
            if (mCost.getProductRange().equalsIgnoreCase("Classic")) {
                if ((materialWidth - fabricPaddingCutWidth) < 9) {
                    fabricCost = fabricCost + (materialWidth - fabricPaddingCutWidth) * fabricPaddingCutHeight * fabricPricePerUnitInch;
                }
            } else {
                if ((materialWidth - Math.min(fabricPaddingCutWidth, fabricPaddingCutHeight)) < 9) {
                    fabricCost = fabricCost + (materialWidth - fabricPaddingCutWidth) * fabricPaddingCutHeight * fabricPricePerUnitInch;
                }
            }

            //padding cost
            Double paddingPricePerUnitInch = paddingPrice / (paddingWidth * 36);
            Double paddingCost = (paddingPricePerUnitInch * fabricPaddingCutArea) * (1 + paddingWastage / 100);

            //there are non usable padding wastages
            if ((paddingWidth - fabricPaddingCutWidth) < 19) {
                paddingCost = paddingCost + (paddingWidth - fabricPaddingCutWidth) * fabricPaddingCutHeight * paddingPricePerUnitInch;
            }
            
            /**Padding Consumption***/
            double paddingConsumption = fabricPaddingCutArea/(paddingWidth*39.4) * (1 + paddingWastage/100);
            HashMap padding = new HashMap();
            padding.put(mCost.getPaddingType(), paddingConsumption+"");
            mCost.setPadding(padding);

            //taffata cost
            Double taffataCutArea = taffataCutHeight * taffataCutWidth;

            Double taffataPricePerUnitInch = taffataPrice / (taffataWidth * 36);
            Double taffataCost = (taffataPricePerUnitInch * taffataCutArea) * (1 + taffataWastage / 100);
            
            /**Taffata Consumption***/
            double taffataConsumption = taffataCutArea/(taffataWidth*39.4) * (1 + taffataWastage/100);
            HashMap taffata = new HashMap();
            taffata.put(mCost.getTaffataType(), taffataConsumption+"");
            mCost.setTaffata(taffata);


            Double cplm = MattresProtectorsDataAccess.getInstance().getCostPerLabourMinute();
            Double poh = MattresProtectorsDataAccess.getInstance().getPOHValue();

            Double pohCost = smv * poh;
            Double labourCost = smv * cplm;

            //Non woven bag cost
            if ((mCost.isIsCustom() && mCost.isIncludeNonWovenBag()) || !mCost.isIsCustom()) {
                Double zipperCost;
                zipperCost = MattresProtectorsDataAccess.getInstance().getZipperCost();

                Double nonWovenPricePerUnitInch = MattresProtectorsDataAccess.getInstance().getNonWovenCost() / (36.0 * 63.0);
                Double transparentSheetCostPerUnitInch = MattresProtectorsDataAccess.getInstance().getTransparentSheetCost() / (36.0 * 54.0);

                if ((width + height) >= 138) {//large bag
                    nonWovenBagCost = 601.0 * nonWovenPricePerUnitInch + 196.0 * transparentSheetCostPerUnitInch + 28.0 / 36 * zipperCost + 45 * (poh + cplm) + MattresProtectorsDataAccess.getInstance().getTagCost();
                } else {//small bag
                    nonWovenBagCost = 336.0 * nonWovenPricePerUnitInch + 196.0 * transparentSheetCostPerUnitInch + 23.5 / 36 * zipperCost + 45 * (poh + cplm) + MattresProtectorsDataAccess.getInstance().getTagCost();
                }

            } else {
                nonWovenBagCost = 0.0;
            }


            Double totalCost = fabricCost + paddingCost + taffataCost + elasticCost + peBagCost + tagCost + labelCost + threadCost + nonWovenBagCost + pipingCost + pohCost + labourCost + mCost.getOtherCost();
            Double totalMaterialCost = fabricCost + paddingCost + taffataCost + elasticCost + peBagCost + tagCost + labelCost + threadCost + nonWovenBagCost + pipingCost + mCost.getOtherCost();
            Double netSellingPrice = totalCost * (1.00 + mCost.getMargin()/100.0);
            Double taxes = netSellingPrice * (mCost.getTaxRate()/100.0);
            Double grossSellingPrice = netSellingPrice + taxes;
            mCost.setTotalMaterialCost(totalMaterialCost);
            mCost.setFabricCost(fabricCost);
            mCost.setPaddingCost(paddingCost);
            mCost.setTaffataCost(taffataCost);
            mCost.setElasticCost(elasticCost);
            mCost.setPEBagCost(peBagCost);
            mCost.setTagCost(tagCost);
            mCost.setLableCost(labelCost);
            mCost.setThreadCost(threadCost);
            mCost.setNonWovenBagCost(nonWovenBagCost);
            mCost.setPipingCost(pipingCost);
            mCost.setPohCost(pohCost);
            mCost.setLabourCost(labourCost);
            mCost.setTotalCost(totalCost);
            mCost.setNetSellingPrice(netSellingPrice);
            mCost.setTaxes(taxes);
            mCost.setGrossSellingPrice(grossSellingPrice);

            mCost.setFabricPaddingCuttingHeight(fabricPaddingCutHeight);
            mCost.setFabricPaddingCuttingWidth(fabricPaddingCutWidth);
            mCost.setTaffataCuttingWidth(taffataCutWidth);
            mCost.setTaffataCuttingHeight(taffataCutHeight);

        } catch (Exception e) {
            System.out.println("Error");
        }

        return mCost;
    }
}
