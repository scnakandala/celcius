package logic;

import algorithms.Approximate;
import dataaccess.PillowcaseDataAccess;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import viewmodels.PillowcaseViewModel;

public class PillowcaseLogic {

    public static String[] getProductRanges() {
        try {
            return PillowcaseDataAccess.getInstance().getProductRanges();
        } catch (SQLException ex) {
            Logger.getLogger(PillowcaseLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes() {
        try {
            return PillowcaseDataAccess.getInstance().getMaterialTypes();
        } catch (SQLException ex) {
            Logger.getLogger(PillowcaseLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes(String range) {
        try {
            return PillowcaseDataAccess.getInstance().getMaterialTypes(range);
        } catch (SQLException ex) {
            Logger.getLogger(PillowcaseLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getPillowcaseSizes() {
        try {
            return PillowcaseDataAccess.getInstance().getPillowcaseSizes();
        } catch (SQLException ex) {
            Logger.getLogger(PillowcaseLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getPillowcaseTypes() {
        try {
            return PillowcaseDataAccess.getInstance().getPillowcaseTypes();
        } catch (SQLException ex) {
            Logger.getLogger(PillowcaseLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static PillowcaseViewModel getCostPerUnit(PillowcaseViewModel pCost) {
        try {
            Double materialPrice = PillowcaseDataAccess.getInstance().getMaterialPrice(pCost.getMaterialType());
            Double widthShrinkage = PillowcaseDataAccess.getInstance().getWidthShrinkage(pCost.getMaterialType());
            Double heightShrinkage = PillowcaseDataAccess.getInstance().getHeightShrinkage(pCost.getMaterialType());
            Integer materialWidth = PillowcaseDataAccess.getInstance().getMaterialWidth(pCost.getMaterialType());
            Double wastage = pCost.getWastage();

            Double width, height;
            Double labelCost, tagCost, threadCost, sealBagCost, cardBoardCost, smv;
            if (pCost.isIsCustom()) {
                width = pCost.getCustomWidth();
                height = pCost.getCustomHeight();

                if (pCost.isIncludeTag()) {
                    tagCost = PillowcaseDataAccess.getInstance().getTagCost();
                } else {
                    tagCost = 0.0;
                }

                if (pCost.isIncludeLable()) {
                    labelCost = PillowcaseDataAccess.getInstance().getLableCost();
                } else {
                    labelCost = 0.0;
                }

                if (pCost.isIncludeSealBag()) {
                    sealBagCost = PillowcaseDataAccess.getInstance().getSealBagCost();
                } else {
                    sealBagCost = 0.0;
                }

                if (pCost.isIncludeCardBoard()) {
                    cardBoardCost = PillowcaseDataAccess.getInstance().getCardBoardCost();
                } else {
                    cardBoardCost = 0.0;
                }

                threadCost = PillowcaseDataAccess.getInstance().getThreadCost();

                //smv = has to calculate
                double[][] arr = PillowcaseDataAccess.getInstance().getSMVXYPairs(pCost.getPillowcaseType());
                Approximate cFitting = new Approximate(arr[0], arr[1]);
                smv = cFitting.getApproximatedValue(((double) height + width));
            } else {
                width = Double.parseDouble(pCost.getSize().split("X")[0]);
                height = Double.parseDouble(pCost.getSize().split("X")[1]);
                tagCost = PillowcaseDataAccess.getInstance().getTagCost();
                labelCost = PillowcaseDataAccess.getInstance().getLableCost();
                sealBagCost = PillowcaseDataAccess.getInstance().getSealBagCost();
                threadCost = PillowcaseDataAccess.getInstance().getThreadCost();
                cardBoardCost = PillowcaseDataAccess.getInstance().getCardBoardCost();

                smv = PillowcaseDataAccess.getInstance().getSMVValue(pCost.getSize());

                //find the flap size
                if ((width + height) <= 24) {
                    pCost.setFlap(4.0);
                } else if (((width + height) > 24) && (width + height) <= 45) {
                    pCost.setFlap(6.0);
                } else if (((width + height) > 45) && (width + height) <= 50) {
                    pCost.setFlap(7.0);
                } else if (((width + height) > 50) && (width + height) <= 60) {
                    pCost.setFlap(8.0);
                } else {
                    pCost.setFlap(8.0);
                }

                //setting the fril size
                pCost.setFrill(2.0);
            }
            Double cutWidth, cutHeight;

            if (pCost.getPillowcaseType().equals("frill")) {
                cutWidth = (width + 1 + pCost.getFrill() * 2) * (1 + widthShrinkage / 100);
                cutHeight = (height * 2 + 1 + pCost.getFlap() + pCost.getFrill() * 4) * (1 + heightShrinkage / 100);
            } else {
                cutWidth = (width + 1) * (1 + widthShrinkage / 100);
                cutHeight = (height * 2 + 1 + pCost.getFlap()) * (1 + heightShrinkage / 100);
            }

            pCost.setCuttingHeight(cutHeight);
            pCost.setCuttingWidth(cutWidth);
            pCost.setSmvValue(smv);

            Double cutArea = cutWidth * cutHeight;

            Double pricePerUnitInch = materialPrice / (materialWidth * 36);
            Double fabricCost = (pricePerUnitInch * cutArea) * (1 + wastage / 100);

            Double cplm = PillowcaseDataAccess.getInstance().getCostPerLabourMinute();
            Double poh = PillowcaseDataAccess.getInstance().getPOHValue();

            Double pohCost = smv * poh;
            Double labourCost = smv * cplm;

            Double totalCost = fabricCost + pohCost + labourCost + tagCost + labelCost + sealBagCost + threadCost;
            Double totalMaterialCost = fabricCost + tagCost + labelCost + sealBagCost + threadCost;
            Double netSellingPrice = totalCost * (1.00 + pCost.getMargin()/100.0);
            Double taxes = netSellingPrice * (pCost.getTaxRate()/100.0);
            Double grossSellingPrice = netSellingPrice + taxes;

            pCost.setTotalMaterialCost(totalMaterialCost);
            pCost.setFabricCost(fabricCost);
            pCost.setThreadCost(threadCost);
            pCost.setLableCost(labelCost);
            pCost.setTagCost(tagCost);
            pCost.setSealBagCost(sealBagCost);
            pCost.setCardboardCost(cardBoardCost);
            pCost.setPohCost(pohCost);
            pCost.setLabourCost(labourCost);
            pCost.setTotalCost(totalCost);
            pCost.setNetSellingPrice(netSellingPrice);
            pCost.setTaxes(taxes);
            pCost.setGrossSellingPrice(grossSellingPrice);

        } catch (Exception e) {
            System.out.println("Error");
        }

        return pCost;
    }
}
