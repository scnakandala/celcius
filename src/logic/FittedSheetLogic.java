package logic;

import algorithms.Approximate;
import dataaccess.BolsterPillowCaseDataAccess;
import dataaccess.FittedSheetDataAccess;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import viewmodels.BolsterPillowcaseViewModel;
import viewmodels.FittedSheetViewModel;

public class FittedSheetLogic {

    public static String[] getProductRanges() {
        try {
            return FittedSheetDataAccess.getInstance().getProductRanges();
        } catch (SQLException ex) {
            Logger.getLogger(FittedSheetLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes() {
        try {
            return FittedSheetDataAccess.getInstance().getMaterialTypes();
        } catch (SQLException ex) {
            Logger.getLogger(FittedSheetLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes(String range) {
        try {
            return FittedSheetDataAccess.getInstance().getMaterialTypes(range);
        } catch (SQLException ex) {
            Logger.getLogger(FittedSheetLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getFittedSheetSizes() {
        try {
            return FittedSheetDataAccess.getInstance().getFittedSheetSizes();
        } catch (SQLException ex) {
            Logger.getLogger(FittedSheetLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static FittedSheetViewModel getCostPerUnit(FittedSheetViewModel fCost) {
        try {
            Double materialPrice = FittedSheetDataAccess.getInstance().getMaterialPrice(fCost.getMaterialType());
            Integer materialWidth = FittedSheetDataAccess.getInstance().getMaterialWidth(fCost.getMaterialType());
            Double wastage = fCost.getWastage();

            Double width, length, height, cutWidth, cutLength;
            Double labelCost, tagCost, threadCost, peBagCost, smv, cardboardCost, elasticCost;

            height = fCost.getHeight();

            if (fCost.isIsCustom()) {
                width = fCost.getCustomDiameter();
                length = fCost.getCustomLength();

                if (fCost.isIncludeTag()) {
                    tagCost = FittedSheetDataAccess.getInstance().getTagCost();
                } else {
                    tagCost = 0.0;
                }

                if (fCost.isIncludeLable()) {
                    labelCost = FittedSheetDataAccess.getInstance().getLableCost();
                } else {
                    labelCost = 0.0;
                }

                if (fCost.isIncludeSealBag()) {
                    peBagCost = FittedSheetDataAccess.getInstance().getPEBagCost();
                } else {
                    peBagCost = 0.0;
                }

                if (fCost.isIncludeCardboard()) {
                    cardboardCost = FittedSheetDataAccess.getInstance().getCardBoardCost();
                } else {
                    cardboardCost = 0.0;
                }

                threadCost = FittedSheetDataAccess.getInstance().getThreadCost();

                //smv = has to calculate
                double[][] arr = FittedSheetDataAccess.getInstance().getSMVXYPairs();
                Approximate approx = new Approximate(arr[0], arr[1]);
                smv = approx.getApproximatedValue((double) width + length);
            } else {
                width = Double.parseDouble(fCost.getSize().split("X")[0]);
                length = Double.parseDouble(fCost.getSize().split("X")[1]);

                tagCost = FittedSheetDataAccess.getInstance().getTagCost();
                labelCost = FittedSheetDataAccess.getInstance().getLableCost();
                peBagCost = FittedSheetDataAccess.getInstance().getPEBagCost();
                threadCost = FittedSheetDataAccess.getInstance().getThreadCost();
                cardboardCost = FittedSheetDataAccess.getInstance().getCardBoardCost();

                smv = BolsterPillowCaseDataAccess.getInstance().getSMVValue(fCost.getSize());
            }

            fCost.setSmvValue(smv);

            cutWidth = (width + height * 2 + 8);
            cutLength = (length + height * 2 + 8);

            elasticCost = FittedSheetDataAccess.getInstance().getElasticCost() / 36 * (length + width) * 2;

            Double cutArea = cutLength * cutWidth;

            Double pricePerUnitInch = materialPrice / (materialWidth * 36);
            Double fabricCost = (pricePerUnitInch * cutArea) * (1 + wastage / 100);

            Double cplm = FittedSheetDataAccess.getInstance().getCostPerLabourMinute();
            Double poh = FittedSheetDataAccess.getInstance().getPOHValue();

            Double pohCost = smv * poh;
            Double labourCost = smv * cplm;

            Double totalCost = fabricCost + pohCost + labourCost + tagCost + labelCost
                    + peBagCost + threadCost + cardboardCost + elasticCost + fCost.getOtherCost();
            Double totalMaterialCost = fabricCost + tagCost + labelCost + peBagCost
                    + threadCost + cardboardCost + elasticCost + fCost.getOtherCost();
            Double netSellingPrice = totalCost * (1.00 + fCost.getMargin() / 100.0);
            Double taxes = netSellingPrice * fCost.getTaxRate() / 100.0;
            Double grossSellingPrice = netSellingPrice + taxes;

            fCost.setTotalMaterialCost(totalMaterialCost);
            fCost.setFabricCost(fabricCost);
            fCost.setThreadCost(threadCost);
            fCost.setLableCost(labelCost);
            fCost.setTagCost(tagCost);
            fCost.setCardBoardCost(cardboardCost);
            fCost.setElasticCost(elasticCost);
            fCost.setPohCost(pohCost);
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
