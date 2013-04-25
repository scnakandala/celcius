package logic;

import algorithms.Approximate;
import dataaccess.BedSheetDataAccess;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import viewmodels.BedSheetViewModel;

public class BedSheetLogic {

    public static String[] getProductRanges() {
        try {
            return BedSheetDataAccess.getInstance().getProductRanges();
        } catch (SQLException ex) {
            Logger.getLogger(BedSheetLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes() {
        try {
            return BedSheetDataAccess.getInstance().getMaterialTypes();
        } catch (SQLException ex) {
            Logger.getLogger(BedSheetLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes(String range) {
        try {
            return BedSheetDataAccess.getInstance().getMaterialTypes(range);
        } catch (SQLException ex) {
            Logger.getLogger(BedSheetLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getBedSheetSizes() {
        try {
            return BedSheetDataAccess.getInstance().getBedSheetSizes();
        } catch (SQLException ex) {
            Logger.getLogger(BedSheetLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static BedSheetViewModel getCostPerUnit(BedSheetViewModel bCost) {
        try {
            Double materialPrice = BedSheetDataAccess.getInstance().getMaterialPrice(bCost.getMaterialType());
            Double widthShrinkage = BedSheetDataAccess.getInstance().getWidthShrinkage(bCost.getMaterialType());
            Double heightShrinkage = BedSheetDataAccess.getInstance().getHeightShrinkage(bCost.getMaterialType());
            Integer materialWidth = BedSheetDataAccess.getInstance().getMaterialWidth(bCost.getMaterialType());
            Double wastage = bCost.getWastage();

            Integer width, height;
            Double labelCost, tagCost, threadCost, sealBagCost, cardBoardCost, smv;
            if (bCost.isIsCustom()) {
                width = bCost.getCustomWidth();
                height = bCost.getCustomHeight();

                if (bCost.isIncludeTag()) {
                    tagCost = BedSheetDataAccess.getInstance().getTagCost();
                } else {
                    tagCost = 0.0;
                }

                if (bCost.isIncludeLable()) {
                    labelCost = BedSheetDataAccess.getInstance().getLableCost();
                } else {
                    labelCost = 0.0;
                }

                if (bCost.isIncludeSealBag()) {
                    sealBagCost = BedSheetDataAccess.getInstance().getSealBagCost();
                } else {
                    sealBagCost = 0.0;
                }

                if (bCost.isIncludeCardBoard()) {
                    cardBoardCost = BedSheetDataAccess.getInstance().getCardBoardCost();
                } else {
                    cardBoardCost = 0.0;
                }

                threadCost = BedSheetDataAccess.getInstance().getThreadCost();

                //smv = has to calculate
                double[][] arr = BedSheetDataAccess.getInstance().getSMVXYPairs();
                Approximate approx = new Approximate(arr[0], arr[1]);
                smv = approx.getApproximatedValue((double)width+height);
            } else {
                width = Integer.parseInt(bCost.getSize().split("X")[0]);
                height = Integer.parseInt(bCost.getSize().split("X")[1]);

                tagCost = BedSheetDataAccess.getInstance().getTagCost();
                labelCost = BedSheetDataAccess.getInstance().getLableCost();
                sealBagCost = BedSheetDataAccess.getInstance().getSealBagCost();
                threadCost = BedSheetDataAccess.getInstance().getThreadCost();
                cardBoardCost = BedSheetDataAccess.getInstance().getCardBoardCost();

                smv = BedSheetDataAccess.getInstance().getSMVValue(bCost.getSize());
            }

            Double cutWidth = (width + 2) * (1 + widthShrinkage / 100);
            Double cutHeight = (height + 2) * (1 + heightShrinkage / 100);

            bCost.setCuttingHeight(cutHeight);
            bCost.setCuttingWidth(cutWidth);
            bCost.setSmvValue(smv);

            Double cutArea = cutWidth * cutHeight;

            Double pricePerUnitInch = materialPrice / (materialWidth * 36);
            Double fabricCost = (pricePerUnitInch * cutArea) * (1 + wastage / 100);

            //there are non usable material wastages
            if (bCost.getProductRange().equalsIgnoreCase("Classic")) {
                if ((materialWidth - cutWidth) < 9) {
                    fabricCost = fabricCost + (materialWidth - cutWidth) * cutHeight * pricePerUnitInch;
                }
            } else {
                if ((materialWidth - Math.max(cutWidth, cutHeight)) < 9) {
                    fabricCost = fabricCost + (materialWidth - cutWidth) * cutHeight * pricePerUnitInch;
                }
            }

            Double cplm = BedSheetDataAccess.getInstance().getCostPerLabourMinute();
            Double poh = BedSheetDataAccess.getInstance().getPOHValue();

            Double pohCost = smv * poh;
            Double labourCost = smv * cplm;

            Double totalCost = fabricCost + pohCost + labourCost + tagCost + labelCost + sealBagCost + threadCost;
            Double totalMaterialCost = fabricCost + tagCost + labelCost + sealBagCost + threadCost;
            Double netSellingPrice = totalCost * (1.00 + bCost.getMargin()/100.0);
            Double taxes = netSellingPrice * bCost.getTaxRate()/100.0;
            Double grossSellingPrice = netSellingPrice + taxes;

            bCost.setTotalMaterialCost(totalMaterialCost);
            bCost.setFabricCost(fabricCost);
            bCost.setThreadCost(threadCost);
            bCost.setLableCost(labelCost);
            bCost.setTagCost(tagCost);
            bCost.setSealBagCost(sealBagCost);
            bCost.setCardboardCost(cardBoardCost);
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
