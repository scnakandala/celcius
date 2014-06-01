package logic;

import algorithms.Approximate;
import dataaccess.BolsterPillowCaseDataAccess;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import viewmodels.BolsterPillowcaseViewModel;

public class BolsterPillowcaseLogic {

    public static String[] getProductRanges() {
        try {
            return BolsterPillowCaseDataAccess.getInstance().getProductRanges();
        } catch (SQLException ex) {
            Logger.getLogger(BolsterPillowcaseLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes() {
        try {
            return BolsterPillowCaseDataAccess.getInstance().getMaterialTypes();
        } catch (SQLException ex) {
            Logger.getLogger(BolsterPillowcaseLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes(String range) {
        try {
            return BolsterPillowCaseDataAccess.getInstance().getMaterialTypes(range);
        } catch (SQLException ex) {
            Logger.getLogger(BolsterPillowcaseLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getBolsterPillowCaseSizes() {
        try {
            return BolsterPillowCaseDataAccess.getInstance().getBolsterPillowCaseSizes();
        } catch (SQLException ex) {
            Logger.getLogger(BolsterPillowcaseLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static BolsterPillowcaseViewModel getCostPerUnit(BolsterPillowcaseViewModel bCost) {
        try {
            Double materialPrice = BolsterPillowCaseDataAccess.getInstance().getMaterialPrice(bCost.getMaterialType());
            Integer materialWidth = BolsterPillowCaseDataAccess.getInstance().getMaterialWidth(bCost.getMaterialType());
            Double wastage = bCost.getWastage();

            Double diameter, length;
            Double labelCost, tagCost, threadCost, peBagCost, smv, zipperVelcoCost;
            if (bCost.isUseZipper()) {
                zipperVelcoCost = BolsterPillowCaseDataAccess.getInstance().getZipperCost();
            } else {
                zipperVelcoCost = BolsterPillowCaseDataAccess.getInstance().getVelcoCost();
            }

            if (bCost.isIsCustom()) {
                diameter = bCost.getCustomDiameter();
                length = bCost.getCustomLength();

                if (bCost.isIncludeTag()) {
                    tagCost = BolsterPillowCaseDataAccess.getInstance().getTagCost();
                } else {
                    tagCost = 0.0;
                }

                if (bCost.isIncludeLable()) {
                    labelCost = BolsterPillowCaseDataAccess.getInstance().getLableCost();
                } else {
                    labelCost = 0.0;
                }

                if (bCost.isIncludeSealBag()) {
                    peBagCost = BolsterPillowCaseDataAccess.getInstance().getPEBagCost();
                } else {
                    peBagCost = 0.0;
                }

                threadCost = BolsterPillowCaseDataAccess.getInstance().getThreadCost();

                //smv = has to calculate
                double[][] arr = BolsterPillowCaseDataAccess.getInstance().getSMVXYPairs();
                Approximate approx = new Approximate(arr[0], arr[1]);
                smv = approx.getApproximatedValue((double) diameter + length);
            } else {
                diameter = Double.parseDouble(bCost.getSize().split("X")[0]);
                length = Double.parseDouble(bCost.getSize().split("X")[1]);

                tagCost = BolsterPillowCaseDataAccess.getInstance().getTagCost();
                labelCost = BolsterPillowCaseDataAccess.getInstance().getLableCost();
                peBagCost = BolsterPillowCaseDataAccess.getInstance().getPEBagCost();
                threadCost = BolsterPillowCaseDataAccess.getInstance().getThreadCost();

                smv = BolsterPillowCaseDataAccess.getInstance().getSMVValue(bCost.getSize());
            }

            bCost.setSmvValue(smv);

            Double cutArea = (length + 1) * (3.141 * diameter + 1) + (diameter + 1) * (diameter + 1) * 2;

            Double pricePerUnitInch = materialPrice / (materialWidth * 36);
            Double fabricCost = (pricePerUnitInch * cutArea) * (1 + wastage / 100);

            /**Material Consumption***/
            double materialConsumption = cutArea/(materialWidth*39.4) * (1 + wastage/100);
            HashMap fabric = new HashMap();
            fabric.put(bCost.getMaterialType(), materialConsumption+"");
            bCost.setFabric(fabric);

            Double cplm = BolsterPillowCaseDataAccess.getInstance().getCostPerLabourMinute();
            Double poh = BolsterPillowCaseDataAccess.getInstance().getPOHValue();

            Double pohCost = smv * poh;
            Double labourCost = smv * cplm;

            Double totalCost = fabricCost + pohCost + labourCost + tagCost + labelCost + peBagCost + threadCost + zipperVelcoCost + +bCost.getOtherCost();
            Double totalMaterialCost = fabricCost + tagCost + labelCost + peBagCost + threadCost + zipperVelcoCost + bCost.getOtherCost();
            Double netSellingPrice = totalCost * (1.00 + bCost.getMargin() / 100.0);
            Double taxes = netSellingPrice * bCost.getTaxRate() / 100.0;
            Double grossSellingPrice = netSellingPrice + taxes;

            bCost.setTotalMaterialCost(totalMaterialCost);
            bCost.setFabricCost(fabricCost);
            bCost.setThreadCost(threadCost);
            bCost.setLableCost(labelCost);
            bCost.setZipperVelcoCost(zipperVelcoCost);
            bCost.setPEBagCost(peBagCost);
            bCost.setTagCost(tagCost);
            bCost.setPohCost(pohCost);
            bCost.setLabourCost(labourCost);
            bCost.setTotalCost(totalCost);
            bCost.setNetSellingPrice(netSellingPrice);
            bCost.setTaxes(taxes);
            bCost.setGrossSellingPrice(grossSellingPrice);

        } catch (Exception e) {
            System.out.println("Error");
        }

        return bCost;
    }
}
