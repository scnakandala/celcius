package logic;

import algorithms.Approximate;
import dataaccess.DuvetsDataAccess;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import viewmodels.DovetsViewModel;

public class DuvetsLogic {

    public static String[] getDuvetTypes() {
        try {
            return DuvetsDataAccess.getInstance().getDuvetTypes();
        } catch (SQLException ex) {
            Logger.getLogger(DuvetsLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getProductRanges(String duvetType) {
        try {
            return DuvetsDataAccess.getInstance().getProductRanges(duvetType);
        } catch (SQLException ex) {
            Logger.getLogger(DuvetsLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes(String range) {
        try {
            return DuvetsDataAccess.getInstance().getMaterialTypes(range);
        } catch (SQLException ex) {
            Logger.getLogger(DuvetsLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getPaddingTypes() {
        try {
            return DuvetsDataAccess.getInstance().getPaddingTypes();
        } catch (SQLException ex) {
            Logger.getLogger(DuvetsLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getFiberTypes() {
        try {
            return DuvetsDataAccess.getInstance().getFiberTypes();
        } catch (SQLException ex) {
            Logger.getLogger(DuvetsLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getDuvetsizes(String type) {
        try {
            return DuvetsDataAccess.getInstance().getDuvetSizes(type);
        } catch (SQLException ex) {
            Logger.getLogger(DuvetsLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static DovetsViewModel getCostPerUnit(DovetsViewModel dCost) {
        try {
            Double fabricPrice = DuvetsDataAccess.getInstance().getMaterialPrice(dCost.getMaterialType());
            Integer materialWidth = DuvetsDataAccess.getInstance().getMaterialWidth(dCost.getMaterialType());
            Double fabricWastage = dCost.getFabricWastage();

            Double paddingPrice = 0.0, paddingWidth = 0.0, paddingWastage = 0.0, widthQuitingShrinkage = 0.0,
                    hightQuitingShrinkage = 0.0, fiberPrice = 0.0, fiberWastage = 0.0, fillingGsm = 0.0;
            if (!dCost.getDuvetType().equalsIgnoreCase("Gel/Feather")) {
                paddingPrice = DuvetsDataAccess.getInstance().getPaddingPrice(dCost.getPaddingType());
                paddingWidth = DuvetsDataAccess.getInstance().getPaddingWidth(dCost.getPaddingType());
                paddingWastage = dCost.getPaddingWastage();
                widthQuitingShrinkage = dCost.getWidthQuiltyShrinkage();
                hightQuitingShrinkage = dCost.getHeightQuiltyShrinkage();
                paddingWastage = dCost.getPaddingWastage();
            } else {
                fiberPrice = DuvetsDataAccess.getInstance().getFiberPrice(dCost.getFiberType());
                fiberWastage = dCost.getFiberWastage();
                fillingGsm = dCost.getFillingGsm();
            }

            Double width, height;
            if (dCost.isIsCustom()) {
                width = dCost.getCustomWidth();
                height = dCost.getCustomHeight();
            } else {
                width = Double.parseDouble(dCost.getSize().split("X")[0]);
                height = Double.parseDouble(dCost.getSize().split("X")[1]);
            }

            //Fabric Padding cutting sizes
            Double fabricCutWidth, fabricCutHeight, paddingCutWidth = 0.0, paddingCutHeight = 0.0,
                    pipingCost = 0.0, fiberCost = 0.0, fiberWeight = 0.0, paddingCost = 0.0;
            if (!dCost.getDuvetType().equalsIgnoreCase("Gel/Feather")) {
                fabricCutWidth = (width + 1.5) * (1 + widthQuitingShrinkage / 100.0);
                fabricCutHeight = (height + 1.5) * (1 + hightQuitingShrinkage / 100.0);

                paddingCutWidth = fabricCutWidth;
                paddingCutHeight = (height + 1.5) * (1 + hightQuitingShrinkage / 100);
                //piping cost
                pipingCost = 2 * (height + width + 3) * DuvetsDataAccess.getInstance().getPipingCost() / 36;
                //padding cost
                Double paddingPricePerUnitInch = paddingPrice / (paddingWidth * 36);
                paddingCost = (paddingPricePerUnitInch * paddingCutHeight * paddingCutWidth) * (1 + paddingWastage / 100.0);
                //there are non usable padding wastages
                if ((paddingWidth - paddingCutWidth) < 19) {
                    paddingCost = paddingCost + (paddingWidth - paddingCutWidth) * paddingCutHeight * paddingPricePerUnitInch;
                }
            } else {
                fabricCutWidth = width + 5.0;
                fabricCutHeight = height + 5.0;
                //fiber cost
                fiberWeight = (height * width) * 2.54 * 2.54 / 10000 * dCost.getFillingGsm() * (1 + fiberWastage / 100.0);
                fiberCost = fiberWeight * fiberPrice / 1000;
            }
            dCost.setFabricCuttingWidth(fabricCutWidth);
            dCost.setFabricCuttingHeight(fabricCutHeight);
            dCost.setPipingCost(pipingCost);
            dCost.setPaddingCost(paddingCost);
            dCost.setFabricCuttingWidth(fabricCutWidth);
            dCost.setFabricCuttingHeight(fabricCutHeight);
            dCost.setFiberWeight(fiberWeight);
            dCost.setFiberCost(fiberCost);


            //pe bag cost
            Double peBagCost;
            if ((dCost.isIsCustom() && dCost.isIncludePEBag()) || !dCost.isIsCustom()) {
                peBagCost = DuvetsDataAccess.getInstance().getPEBagCost();
            } else {
                peBagCost = 0.0;
            }
            dCost.setPEBagCost(peBagCost);

            //lable cost
            Double lableCost;
            if ((dCost.isIsCustom() && dCost.isIncludeLable()) || !dCost.isIsCustom()) {
                lableCost = DuvetsDataAccess.getInstance().getLableCost();
            } else {
                lableCost = 0.0;
            }
            dCost.setLableCost(lableCost);

            //tag bag cost
            Double tagCost;
            if ((dCost.isIsCustom() && dCost.isIncludeTag()) || !dCost.isIsCustom()) {
                tagCost = DuvetsDataAccess.getInstance().getTagCost();
            } else {
                tagCost = 0.0;
            }
            dCost.setTagCost(tagCost);

            //thread cost
            Double threadCost = DuvetsDataAccess.getInstance().getThreadCost();
            dCost.setThreadCost(threadCost);

            //fabric cost
            Double fabricCutArea = fabricCutWidth * fabricCutHeight * 2;
            Double fabricPricePerUnitInch = fabricPrice / (materialWidth * 36);
            Double fabricCost = (fabricPricePerUnitInch * fabricCutArea) * (1 + fabricWastage / 100);

            //there are non usable fabric wastages
            if ((materialWidth - fabricCutWidth) < 9) {
                fabricCost = fabricCost + (materialWidth - fabricCutWidth) * fabricCutHeight * fabricPricePerUnitInch;
            }
            dCost.setFabricCost(fabricCost);

            Double cplm = DuvetsDataAccess.getInstance().getCostPerLabourMinute();
            Double poh = DuvetsDataAccess.getInstance().getPOHValue();
            Double smv;
            if (dCost.isIsCustom()) {
                //smv = has to calculate
                double[][] arr = DuvetsDataAccess.getInstance().getSMVXYPairs(dCost.getDuvetType());
                Approximate cFitting = new Approximate(arr[0], arr[1]);
                smv = cFitting.getApproximatedValue(((double) height + width));
            } else {
                smv = DuvetsDataAccess.getInstance().getSMVValue(dCost.getSize(), dCost.getDuvetType());
            }
            dCost.setSmvValue(smv);
            Double pohCost = smv * poh;
            dCost.setPohCost(pohCost);
            Double labourCost = smv * cplm;
            dCost.setLabourCost(labourCost);

            //Non woven bag cost
            Double nonWovenBagCost;
            if (!dCost.getDuvetType().equalsIgnoreCase("Baby") && ((dCost.isIsCustom() && dCost.isIncludeNonWovenBag()) || !dCost.isIsCustom())) {
                Double zipperCost;
                zipperCost = DuvetsDataAccess.getInstance().getZipperCost();
                Double nonWovenPricePerUnitInch = DuvetsDataAccess.getInstance().getNonWovenCost() / (36.0 * 63.0);
                Double transparentSheetCostPerUnitInch = DuvetsDataAccess.getInstance().getTransparentSheetCost() / (36.0 * 54.0);

                if ((width + height) <= 123) {//small bag
                    nonWovenBagCost = 756.0 * nonWovenPricePerUnitInch + 250.8 * transparentSheetCostPerUnitInch + 25.0 / 36 * zipperCost + 45 * (poh + cplm)
                            + DuvetsDataAccess.getInstance().getTagCost() + DuvetsDataAccess.getInstance().getZipperHeadCost();
                } else if ((width + height) <= 160) {//medium bag
                    nonWovenBagCost = 925.2 * nonWovenPricePerUnitInch + 318.9 * transparentSheetCostPerUnitInch + 33.0 / 36 * zipperCost + 45 * (poh + cplm)
                            + DuvetsDataAccess.getInstance().getTagCost() + DuvetsDataAccess.getInstance().getZipperHeadCost();
                } else { //large bag
                    nonWovenBagCost = 1215.0 * nonWovenPricePerUnitInch + 897.1 * transparentSheetCostPerUnitInch + 41.0 / 36 * zipperCost + 45 * (poh + cplm);
                }
            } else {
                nonWovenBagCost = 0.0;
            }
            dCost.setNonWovenBagCost(nonWovenBagCost);

            Double totalCost = fabricCost + fiberCost + paddingCost + peBagCost + tagCost + lableCost + threadCost + nonWovenBagCost + pipingCost + pohCost + labourCost + dCost.getOtherCost();
            Double totalMaterialCost = fabricCost + fiberCost + paddingCost + peBagCost + tagCost + lableCost + threadCost + nonWovenBagCost + pipingCost + dCost.getOtherCost();

            dCost.setTotalCost(totalCost);
            dCost.setTotalMaterialCost(totalMaterialCost);

            Double netSellingPrice = totalCost * ( 1.0 + dCost.getMargin()/100.0);
            Double taxes = netSellingPrice * ( dCost.getTaxRate()/100.0);
            Double grossSellingPrice = netSellingPrice + taxes;

            dCost.setNetSellingPrice(netSellingPrice);
            dCost.setTaxes(taxes);
            dCost.setGrossSellingPrice(grossSellingPrice);

        } catch (Exception e) {
            System.out.println("Error");
        }

        return dCost;
    }
}
