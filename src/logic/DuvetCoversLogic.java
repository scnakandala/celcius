package logic;

import algorithms.Approximate;
import dataaccess.DuvetCoversDataAccess;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import viewmodels.DovetCoversViewModel;


public class DuvetCoversLogic {

    public static String[] getProductRanges() {
        try {
            return DuvetCoversDataAccess.getInstance().getProductRanges();
        } catch (SQLException ex) {
            Logger.getLogger(DuvetCoversLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes() {
        try {
            return DuvetCoversDataAccess.getInstance().getMaterialTypes();
        } catch (SQLException ex) {
            Logger.getLogger(DuvetCoversLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes(String range) {
        try {
            return DuvetCoversDataAccess.getInstance().getMaterialTypes(range);
        } catch (SQLException ex) {
            Logger.getLogger(DuvetCoversLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getDuvetCoverSizes() {
        try {
            return DuvetCoversDataAccess.getInstance().getDuvetCoverSizes();
        } catch (SQLException ex) {
            Logger.getLogger(DuvetCoversLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static DovetCoversViewModel getCostPerUnit(DovetCoversViewModel dCost) {
        try {
            Double materialPrice = DuvetCoversDataAccess.getInstance().getMaterialPrice(dCost.getMaterialType());
            Double widthShrinkage = DuvetCoversDataAccess.getInstance().getWidthShrinkage(dCost.getMaterialType());
            Double heightShrinkage = DuvetCoversDataAccess.getInstance().getHeightShrinkage(dCost.getMaterialType());
            Integer materialWidth = DuvetCoversDataAccess.getInstance().getMaterialWidth(dCost.getMaterialType());
            Double wastage = dCost.getWastage();

            Integer width, height;
            Double labelCost, tagCost, threadCost, sealBagCost, cardBoardCost, velcoCost, zipperCost, buttonCost, smv;
            if (dCost.isIsCustom()) {
                width = dCost.getCustomWidth();
                height = dCost.getCustomHeight();

                if (dCost.isIncludeTag()) {
                    tagCost = DuvetCoversDataAccess.getInstance().getTagCost();
                } else {
                    tagCost = 0.0;
                }

                if (dCost.isIncludeLable()) {
                    labelCost = DuvetCoversDataAccess.getInstance().getLableCost();
                } else {
                    labelCost = 0.0;
                }

                if (dCost.isIncludeSealBag()) {
                    sealBagCost = DuvetCoversDataAccess.getInstance().getSealBagCost();
                } else {
                    sealBagCost = 0.0;
                }

                if (dCost.isIncludeCardBoard()) {
                    cardBoardCost = DuvetCoversDataAccess.getInstance().getCardBoardCost();
                } else {
                    cardBoardCost = 0.0;
                }

                threadCost = DuvetCoversDataAccess.getInstance().getThreadCost();

                //smv = has to calculate
                double[][] arr = DuvetCoversDataAccess.getInstance().getSMVXYPairs(dCost.getDuvetCoverType());
                Approximate cFitting = new Approximate(arr[0], arr[1]);
                smv = cFitting.getApproximatedValue(((double)height+width));
            } else {
                width = Integer.parseInt(dCost.getSize().split("X")[0]);
                height = Integer.parseInt(dCost.getSize().split("X")[1]);

                tagCost = DuvetCoversDataAccess.getInstance().getTagCost();
                labelCost = DuvetCoversDataAccess.getInstance().getLableCost();
                sealBagCost = DuvetCoversDataAccess.getInstance().getSealBagCost();
                threadCost = DuvetCoversDataAccess.getInstance().getThreadCost();
                cardBoardCost = DuvetCoversDataAccess.getInstance().getCardBoardCost();

                smv = DuvetCoversDataAccess.getInstance().getSMVValue(dCost.getSize());

                //setting the standard custom size
                dCost.setFlap(10.0);

            }

            Double cutHeight, cutWidth;
            if (dCost.getDuvetCoverType().equalsIgnoreCase("envelope")) {
                cutWidth = (width + 1) * (1 + widthShrinkage / 100);
                cutHeight = (height * 2 + 4 + dCost.getFlap()) * (1 + heightShrinkage / 100);
            } else {
                cutWidth = (width + 1) * (1 + widthShrinkage / 100);
                cutHeight = (height * 2 + 6) * (1 + heightShrinkage / 100);
            }

            dCost.setCuttingHeight(cutHeight);
            dCost.setCuttingWidth(cutWidth);
            dCost.setSmvValue(smv);



            if (dCost.getDuvetCoverType().equalsIgnoreCase("envelope")) {
                velcoCost = 10.0 / 36 * DuvetCoversDataAccess.getInstance().getVelcoCost();
            } else {
                velcoCost = 0.0;
            }

            if (dCost.getDuvetCoverType().equalsIgnoreCase("button")) {
                buttonCost = Math.ceil(width / 10) * DuvetCoversDataAccess.getInstance().getButtonCost();
            } else {
                buttonCost = 0.0;
            }

            if (dCost.getDuvetCoverType().equalsIgnoreCase("zipper")) {
                zipperCost = (width - 10.0) / 36 * DuvetCoversDataAccess.getInstance().getZipperCost();
            } else {
                zipperCost = 0.0;
            }

            Double cutArea = cutWidth * cutHeight;

            Double pricePerUnitInch = (double)materialPrice / (materialWidth * 36);
            Double fabricCost = (pricePerUnitInch * cutArea) * (1 + wastage / 100);

            //there are non usable material wastages
            if (dCost.getProductRange().equalsIgnoreCase("Classic")) {
                if ((materialWidth - cutWidth) < 9) {
                    fabricCost = fabricCost + (materialWidth - cutWidth) * cutHeight * pricePerUnitInch;
                }
            } else {
                if ((materialWidth - Math.max(cutWidth, cutHeight)) < 9) {
                    fabricCost = fabricCost + (materialWidth - cutWidth) * cutHeight * pricePerUnitInch;
                }
            }

            Double cplm = DuvetCoversDataAccess.getInstance().getCostPerLabourMinute();
            Double poh = DuvetCoversDataAccess.getInstance().getPOHValue();

            Double pohCost = smv * poh;
            Double labourCost = smv * cplm;

            Double totalCost = fabricCost + pohCost + labourCost + tagCost + labelCost + sealBagCost + threadCost + zipperCost + velcoCost + buttonCost;
            Double totalMaterialCost = fabricCost + tagCost + labelCost + sealBagCost + threadCost + zipperCost + velcoCost + buttonCost;
            Double netSellingPrice = totalCost * (1.00 + dCost.getMargin()/100.0);
            Double taxes = totalCost * (dCost.getTaxRate()/100.0);
            Double grossSellingPrice = netSellingPrice + taxes;

            dCost.setTotalMaterialCost(totalMaterialCost);
            dCost.setFabricCost(fabricCost);
            dCost.setThreadCost(threadCost);
            dCost.setLableCost(labelCost);
            dCost.setTagCost(tagCost);
            dCost.setSealBagCost(sealBagCost);
            dCost.setCardboardCost(cardBoardCost);
            dCost.setPohCost(pohCost);
            dCost.setLabourCost(labourCost);
            dCost.setTotalCost(totalCost);
            dCost.setVelcoCost(velcoCost);
            dCost.setZipperCost(zipperCost);
            dCost.setButtonCost(buttonCost);
            dCost.setNetSellingPrice(netSellingPrice);
            dCost.setTaxes(taxes);
            dCost.setGrossSellingPrice(grossSellingPrice);

        } catch (Exception e) {
            System.out.println("Error");
        }

        return dCost;
    }

    public static String[] getDuvetCoverTypes() {
        try {
            return DuvetCoversDataAccess.getInstance().getDuvetCoverTypes();
        } catch (SQLException ex) {
            Logger.getLogger(DuvetCoversLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
