package logic;

import algorithms.Approximate;
import dataaccess.FittedSheetDataAccess;
import dataaccess.PillowProtectorDataAccess;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import viewmodels.PillowProtectorViewModel;

public class PillowProtectorLogic {

    public static String[] getProductRanges() {
        try {
            return PillowProtectorDataAccess.getInstance().getProductRanges();
        } catch (SQLException ex) {
            Logger.getLogger(PillowProtectorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes() {
        try {
            return PillowProtectorDataAccess.getInstance().getMaterialTypes();
        } catch (SQLException ex) {
            Logger.getLogger(PillowProtectorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes(String range) {
        try {
            return PillowProtectorDataAccess.getInstance().getMaterialTypes(range);
        } catch (SQLException ex) {
            Logger.getLogger(PillowProtectorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getPillowProtectorSizes() {
        try {
            return PillowProtectorDataAccess.getInstance().getPillowProtectorSizes();
        } catch (SQLException ex) {
            Logger.getLogger(PillowProtectorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getTaffataTypes() {
        try {
            return PillowProtectorDataAccess.getInstance().getTaffataTypes();
        } catch (SQLException ex) {
            Logger.getLogger(PillowProtectorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getPaddingTypes() {
        try {
            return PillowProtectorDataAccess.getInstance().getPaddingTypes();
        } catch (SQLException ex) {
            Logger.getLogger(PillowProtectorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static PillowProtectorViewModel getCostPerUnit(PillowProtectorViewModel fCost) {
        try {
            Double materialPrice = PillowProtectorDataAccess.getInstance().getMaterialPrice(fCost.getMaterialType());
            Integer materialWidth = PillowProtectorDataAccess.getInstance().getMaterialWidth(fCost.getMaterialType());
            Double wastage = fCost.getWastage();

            Double width, length, cutWidth, cutLength;
            Double labelCost, tagCost, threadCost, peBagCost, smv, zipperCost, nonWOvenTaffataCost, paddingCost;

            if (fCost.isIsCustom()) {
                width = fCost.getCustomDiameter();
                length = fCost.getCustomLength();

                if (fCost.isIncludeTag()) {
                    tagCost = PillowProtectorDataAccess.getInstance().getTagCost();
                } else {
                    tagCost = 0.0;
                }

                if (fCost.isIncludeLable()) {
                    labelCost = PillowProtectorDataAccess.getInstance().getLableCost();
                } else {
                    labelCost = 0.0;
                }

                if (fCost.isIncludeSealBag()) {
                    peBagCost = PillowProtectorDataAccess.getInstance().getPEBagCost();
                } else {
                    peBagCost = 0.0;
                }

                threadCost = FittedSheetDataAccess.getInstance().getThreadCost();

                //smv = has to calculate
                double[][] arr = PillowProtectorDataAccess.getInstance().getSMVXYPairs();
                Approximate approx = new Approximate(arr[0], arr[1]);
                smv = approx.getApproximatedValue(2 * 3.141 * width + length);
            } else {
                width = Double.parseDouble(fCost.getSize().split("X")[0]);
                length = Double.parseDouble(fCost.getSize().split("X")[1]);

                tagCost = PillowProtectorDataAccess.getInstance().getTagCost();
                labelCost = PillowProtectorDataAccess.getInstance().getLableCost();
                peBagCost = PillowProtectorDataAccess.getInstance().getPEBagCost();
                threadCost = PillowProtectorDataAccess.getInstance().getThreadCost();

                smv = PillowProtectorDataAccess.getInstance().getSMVValue(fCost.getSize());
            }

            zipperCost = PillowProtectorDataAccess.getInstance().getZipperCost();

            cutWidth = (width + 1);
            cutLength = (length * 2 + 5);

            Double cutArea = cutLength * cutWidth;

            Double pricePerUnitInch = materialPrice / (materialWidth * 36);
            Double fabricCost = (pricePerUnitInch * cutArea) * (1 + wastage / 100);

            Double cplm = PillowProtectorDataAccess.getInstance().getCostPerLabourMinute();
            Double poh = PillowProtectorDataAccess.getInstance().getPOHValue();

            Double pohCost = smv * poh;
            Double labourCost = smv * cplm;

            zipperCost = (width + 1) / 36 * PillowProtectorDataAccess.getInstance().getZipperCost();

            nonWOvenTaffataCost = 0.0;
            paddingCost = 0.0;
            if (!fCost.isIsPillowSlip()) {
                //should get from db
                double paddingWidth = PillowProtectorDataAccess.getInstance().getPaddingWidth(fCost.getPaddingType());
                double paddingPrice = PillowProtectorDataAccess.getInstance().getPaddingPrice(fCost.getPaddingType());
                paddingCost = (width + 2) * (length + 3) * paddingPrice / (paddingWidth * 36);

                if (fCost.isUseNonWoven()) {
                    nonWOvenTaffataCost = (width + 2) * (length + 2) * PillowProtectorDataAccess.getInstance().getNonWovenCost();
                } else {
                    double taffataWidth = PillowProtectorDataAccess.getInstance().getTaffataWidth(fCost.getTaffataType());
                    double taffataPrice = PillowProtectorDataAccess.getInstance().getTaffataCost(fCost.getTaffataType());
                    nonWOvenTaffataCost = (width + 2) * (length + 3) * taffataPrice / (taffataWidth * 36);
                }
            }
            Double totalCost = fabricCost + pohCost + labourCost + tagCost + labelCost
                    + peBagCost + threadCost + nonWOvenTaffataCost + zipperCost + paddingCost + fCost.getOtherCost();
            Double totalMaterialCost = fabricCost + tagCost + labelCost + peBagCost
                    + threadCost + zipperCost + nonWOvenTaffataCost + paddingCost + fCost.getOtherCost();
            Double netSellingPrice = totalCost * (1.00 + fCost.getMargin() / 100.0);
            Double taxes = netSellingPrice * fCost.getTaxRate() / 100.0;
            Double grossSellingPrice = netSellingPrice + taxes;

            fCost.setTotalMaterialCost(totalMaterialCost);
            fCost.setFabricCost(fabricCost);
            fCost.setThreadCost(threadCost);
            fCost.setLableCost(labelCost);
            fCost.setTagCost(tagCost);
            fCost.setPEBagCost(peBagCost);
            fCost.setZipperCost(zipperCost);
            fCost.setNonWovenTaffataCost(nonWOvenTaffataCost);
            fCost.setPaddingCost(paddingCost);
            fCost.setPohCost(pohCost);
            fCost.setSmvValue(smv);
            fCost.setLabourCost(labourCost);
            fCost.setTotalCost(totalCost);
            fCost.setNetSellingPrice(netSellingPrice);
            fCost.setTaxes(taxes);
            fCost.setGrossSellingPrice(grossSellingPrice);

            fCost.setCuttingHeight(cutLength);
            fCost.setCuttingWidth(cutWidth);
            fCost.setSmvValue(smv);

        } catch (Exception e) {
            System.out.println("Error");
        }

        return fCost;
    }
}
