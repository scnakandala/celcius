package logic;

import algorithms.Approximate;
import dataaccess.PillowsDataAccess;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import viewmodels.PillowsViewModel;

public class PillowLogic {

    public static String[] getPillowTypes(String range) {
        try {
            return PillowsDataAccess.getInstance().getPillowTypes(range);
        } catch (SQLException ex) {
            Logger.getLogger(PillowLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getProductRanges() {
        try {
            return PillowsDataAccess.getInstance().getProductRanges();
        } catch (SQLException ex) {
            Logger.getLogger(PillowLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes(String range) {
        try {
            return PillowsDataAccess.getInstance().getMaterialTypes(range);
        } catch (SQLException ex) {
            Logger.getLogger(PillowLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getFiberTypes(String range) {
        try {
            return PillowsDataAccess.getInstance().getFiberTypes(range);
        } catch (SQLException ex) {
            Logger.getLogger(PillowLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getPillowSizes(String range, String type) {
        try {
            return PillowsDataAccess.getInstance().getPillowSizes(range, type);
        } catch (SQLException ex) {
            Logger.getLogger(PillowLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static PillowsViewModel getCostPerUnit(PillowsViewModel pCost) {
        try {
            Double materialPrice = PillowsDataAccess.getInstance().getMaterialPrice(pCost.getMaterialType());
            Double fiberPrice = PillowsDataAccess.getInstance().getFiberPrice(pCost.getFiberType());
            Double threadPrice = PillowsDataAccess.getInstance().getThreadCost();
            Double peBagPrice = PillowsDataAccess.getInstance().getPEBag();
            Double lablePrice = PillowsDataAccess.getInstance().getLableCost();
            Double pipingPrice = PillowsDataAccess.getInstance().getPipingCost();
            Double tagPrice = PillowsDataAccess.getInstance().getTagCost();
            Integer fabricWidth = PillowsDataAccess.getInstance().getMaterialWidth(pCost.getMaterialType());

            Double height = 0.0, width = 0.0;
            Double smv = 0.0;
            if (pCost.isIsCustom()) {
                height = pCost.getCustomHeight();
                width = pCost.getCustomWidth();
                double[][] arr = PillowsDataAccess.getInstance().getSMVXYPairs(pCost.getProductRange(), pCost.getPillowType());
                Approximate cFitting = new Approximate(arr[0], arr[1]);
                smv = cFitting.getApproximatedValue(((double) height + width));

                if (!pCost.isIncludeLable()) {
                    peBagPrice = 0.0;
                }
                if (!pCost.isIncludeTag()) {
                    tagPrice = 0.0;
                }
                if (!pCost.isIncludePEBag()) {
                    peBagPrice = 0.0;
                }
            } else {
                width = Double.parseDouble(pCost.getSize().split("X")[0]);
                height = Double.parseDouble(pCost.getSize().split("X")[1]);
                smv = PillowsDataAccess.getInstance().getSMVValue(pCost.getSize(), pCost.getProductRange(), pCost.getPillowType());
            }

            Double fiberWeight = 0.0;
            if (pCost.getCustomeFiberWeight() == 0.0) {
                double[][] arr = PillowsDataAccess.getInstance().getFiberWeights(pCost.getFiberType());
                Approximate cFitting = new Approximate(arr[0], arr[1]);
                fiberWeight = cFitting.getApproximatedValue(((double) height + width));

                if (pCost.getPillowType().equalsIgnoreCase("Vacume") && (pCost.getProductRange().equalsIgnoreCase("Classic") || pCost.getProductRange().equalsIgnoreCase("Super"))) {
                    fiberWeight = fiberWeight + 0.05;
                }
                fiberWeight = fiberWeight * (1.0 + pCost.getFiberWastage() / 100.0);
            } else {
                fiberWeight = pCost.getCustomeFiberWeight();
            }
            
            Double cutWidth = 0.0, cutHeight = 0.0;
            if (pCost.getProductRange().equalsIgnoreCase("Gel/Feather")) {
                cutHeight = (height + 1.0) * 2;
            } else {
                cutHeight = height * 2 + 1.0;
            }
            cutWidth = width + 1.0;

            Double cutArea = cutWidth * cutHeight * (1.0 + pCost.getFabricWastage() / 100.0);
            Double fabricCost = materialPrice / (36 * fabricWidth) * cutArea;

            Double fiberCost = fiberPrice * fiberWeight;

            Double pipingCost = 0.0;
            if (pCost.getProductRange().equalsIgnoreCase("Gel/Feather")) {
                pipingCost = pipingPrice * 2.0 * (cutHeight + cutWidth) / 36.0;
            }

            Double materialCost = fabricCost + fiberCost + pipingCost + tagPrice + lablePrice + threadPrice + peBagPrice + pCost.getOtherCost();
            Double cplm = PillowsDataAccess.getInstance().getCostPerLabourMinute();
            Double poh = PillowsDataAccess.getInstance().getPOHValue();

            Double pohCost = poh * smv;
            Double cplmCost = cplm * smv;

            pCost.setFabricCost(fabricCost);
            pCost.setFiberCost(fiberCost);
            pCost.setFiberWeight(fiberWeight);
            pCost.setPipingCost(pipingCost);
            pCost.setTagCost(tagPrice);
            pCost.setLableCost(lablePrice);
            pCost.setThreadCost(threadPrice);
            pCost.setPEBagCost(peBagPrice);
            pCost.setTotalMaterialCost(materialCost);

            pCost.setLabourCost(cplmCost);
            pCost.setPohCost(pohCost);
            pCost.setSmvValue(smv);
            pCost.setFabricCuttingHeight(cutHeight);
            pCost.setFabricCuttingWidth(cutWidth);

            Double totalCost = materialCost + pohCost + cplmCost;
            pCost.setTotalCost(totalCost);
            Double netSellingPrice = totalCost * (1.0 + pCost.getMargin() / 100.0);
            Double taxes = netSellingPrice * pCost.getTaxRate() / 100.0;
            Double grossSellingPrice = netSellingPrice + taxes;

            pCost.setNetSellingPrice(netSellingPrice);
            pCost.setTaxes(taxes);
            pCost.setGrossSellingPrice(grossSellingPrice);

        } catch (Exception ex) {
            System.out.println("Error");
        }

        return pCost;
    }
}
