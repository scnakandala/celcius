package logic;

import algorithms.Approximate;
import dataaccess.CushionsDataAccess;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import viewmodels.CushionsViewModel;

public class CushionLogic {

    public static String[] getProductRanges() {
        try {
            return CushionsDataAccess.getInstance().getProductRanges();
        } catch (SQLException ex) {
            Logger.getLogger(PillowLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes(String range) {
        try {
            return CushionsDataAccess.getInstance().getMaterialTypes(range);
        } catch (SQLException ex) {
            Logger.getLogger(PillowLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getFiberTypes(String range) {
        try {
            return CushionsDataAccess.getInstance().getFiberTypes(range);
        } catch (SQLException ex) {
            Logger.getLogger(PillowLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getFiberTypes() {
        try {
            return CushionsDataAccess.getInstance().getFiberTypes();
        } catch (SQLException ex) {
            Logger.getLogger(PillowLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getCushionSizes(String range) {
        try {
            return CushionsDataAccess.getInstance().getCushionSizes(range);
        } catch (SQLException ex) {
            Logger.getLogger(PillowLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static CushionsViewModel getCostPerUnit(CushionsViewModel cCost) {
        try {
            Double materialPrice = CushionsDataAccess.getInstance().getMaterialPrice(cCost.getMaterialType());
            Double fiberPrice = CushionsDataAccess.getInstance().getFiberPrice(cCost.getFiberType());
            Double threadPrice = CushionsDataAccess.getInstance().getThreadCost();
            Double peBagPrice = CushionsDataAccess.getInstance().getPEBag();
            Double lablePrice = CushionsDataAccess.getInstance().getLableCost();
            Double tagPrice = CushionsDataAccess.getInstance().getTagCost();
            Integer fabricWidth = CushionsDataAccess.getInstance().getMaterialWidth(cCost.getMaterialType());

            Integer height = 0, width = 0;
            Double smv = 0.0;
            if (cCost.isIsCustom()) {
                height = cCost.getCustomWidthHeight();
                width = cCost.getCustomWidthHeight();
                double[][] arr = CushionsDataAccess.getInstance().getSMVXYPairs(cCost.getProductRange());
                Approximate cFitting = new Approximate(arr[0], arr[1]);
                smv = cFitting.getApproximatedValue(((double) height + width));

                if (!cCost.isIncludeLable()) {
                    peBagPrice = 0.0;
                }
                if (!cCost.isIncludeTag()) {
                    tagPrice = 0.0;
                }
                if (!cCost.isIncludePEBag()) {
                    peBagPrice = 0.0;
                }
            } else {
                width = Integer.parseInt(cCost.getSize().split("X")[0]);
                height = Integer.parseInt(cCost.getSize().split("X")[1]);
                smv = CushionsDataAccess.getInstance().getSMVValue(cCost.getSize(), cCost.getProductRange());
            }

            Double fiberWeight = 0.0;
            double[][] arr = CushionsDataAccess.getInstance().getFiberWeights(cCost.getFiberType());
            Approximate cFitting = new Approximate(arr[0], arr[1]);
            fiberWeight = cFitting.getApproximatedValue(((double) height + width));

            fiberWeight = fiberWeight * (1.0 + cCost.getFiberWastage() / 100.0);

            Double cutWidth = 0.0, cutHeight = 0.0;
            cutHeight = height * 2 + 1.0;
            cutWidth = width + 1.0;

            Double cutArea = cutWidth * cutHeight * (1.0 + cCost.getFabricWastage() / 100.0);
            Double fabricCost = materialPrice / (36 * fabricWidth) * cutArea;

            Double fiberCost = fiberPrice * fiberWeight;

            Double materialCost = fabricCost + fiberCost + tagPrice + lablePrice + threadPrice + peBagPrice;
            Double cplm = CushionsDataAccess.getInstance().getCostPerLabourMinute();
            Double poh = CushionsDataAccess.getInstance().getPOHValue();

            Double pohCost = poh * smv;
            Double cplmCost = cplm * smv;

            cCost.setFabricCost(fabricCost);
            cCost.setFiberCost(fiberCost);
            cCost.setFiberWeight(fiberWeight);
            cCost.setTagCost(tagPrice);
            cCost.setLableCost(lablePrice);
            cCost.setThreadCost(threadPrice);
            cCost.setPEBagCost(peBagPrice);
            cCost.setTotalMaterialCost(materialCost);

            cCost.setLabourCost(cplmCost);
            cCost.setPohCost(pohCost);
            cCost.setSmvValue(smv);
            cCost.setFabricCuttingWidthHeight(cutHeight);

            Double totalCost = materialCost + pohCost + cplmCost;
            cCost.setTotalCost(totalCost);

        } catch (Exception ex) {
            System.out.println("Error");
        }

        return cCost;
    }
}
