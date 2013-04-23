package logic;

import algorithms.Approximate;
import dataaccess.BolsterDataAccess;
import dataaccess.CushionsDataAccess;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import viewmodels.BolstersViewModel;

public class BolsterLogic {

    public static String[] getProductRanges() {
        try {
            return BolsterDataAccess.getInstance().getProductRanges();
        } catch (SQLException ex) {
            Logger.getLogger(PillowLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getMaterialTypes(String range) {
        try {
            return BolsterDataAccess.getInstance().getMaterialTypes(range);
        } catch (SQLException ex) {
            Logger.getLogger(PillowLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getFiberTypes(String range) {
        try {
            return BolsterDataAccess.getInstance().getFiberTypes(range);
        } catch (SQLException ex) {
            Logger.getLogger(PillowLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getFiberTypes() {
        try {
            return BolsterDataAccess.getInstance().getFiberTypes();
        } catch (SQLException ex) {
            Logger.getLogger(PillowLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getBolsterSizes(String range) {
        try {
            return BolsterDataAccess.getInstance().getBolsterSizes(range);
        } catch (SQLException ex) {
            Logger.getLogger(PillowLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static BolstersViewModel getCostPerUnit(BolstersViewModel bCost) {
        try {
            Double materialPrice = BolsterDataAccess.getInstance().getMaterialPrice(bCost.getMaterialType());
            Double fiberPrice = BolsterDataAccess.getInstance().getFiberPrice(bCost.getFiberType());
            Double threadPrice = BolsterDataAccess.getInstance().getThreadCost();
            Double peBagPrice = BolsterDataAccess.getInstance().getPEBag();
            Double lablePrice = BolsterDataAccess.getInstance().getLableCost();
            Double tagPrice = BolsterDataAccess.getInstance().getTagCost();
            Integer fabricWidth = BolsterDataAccess.getInstance().getMaterialWidth(bCost.getMaterialType());

            Double length = 0.0, diameter = 0.0;
            Double smv = 0.0;
            if (bCost.isIsCustom()) {
                length = bCost.getLength() + 0.0;
                diameter = bCost.getDiameter() + 0.0;
                double[][] arr = BolsterDataAccess.getInstance().getSMVXYPairs(bCost.getProductRange());
                Approximate cFitting = new Approximate(arr[0], arr[1]);
                smv = cFitting.getApproximatedValue(2 * 3.141 * diameter + length);
                if (!bCost.isIncludeLable()) {
                    peBagPrice = 0.0;
                }
                if (!bCost.isIncludeTag()) {
                    tagPrice = 0.0;
                }
                if (!bCost.isIncludePEBag()) {
                    peBagPrice = 0.0;
                }
            } else {
                diameter = Double.parseDouble(bCost.getSize().split("X")[0]);
                length = Double.parseDouble(bCost.getSize().split("X")[1]);
                smv = BolsterDataAccess.getInstance().getSMVValue(bCost.getSize(), bCost.getProductRange());
            }

            Double fiberWeight = 0.0;
            double[][] arr = BolsterDataAccess.getInstance().getFiberWeights(bCost.getFiberType());
            Approximate cFitting = new Approximate(arr[0], arr[1]);
            fiberWeight = cFitting.getApproximatedValue((length * diameter * diameter));

            fiberWeight = fiberWeight * (1.0 + bCost.getFiberWastage() / 100.0);
            Double fiberCost = fiberPrice * fiberWeight;

            Double cutArea = ((diameter + 0.5) * (diameter + 0.5) * 2 + (length + 1) * 3.141 * diameter) * (1.0 + bCost.getFabricWastage() / 100.0);
            Double fabricCost = materialPrice / (36 * fabricWidth) * cutArea;

            Double materialCost = fabricCost + fiberCost + tagPrice + lablePrice + threadPrice + peBagPrice;
            Double cplm = CushionsDataAccess.getInstance().getCostPerLabourMinute();
            Double poh = CushionsDataAccess.getInstance().getPOHValue();

            Double pohCost = poh * smv;
            Double cplmCost = cplm * smv;

            bCost.setFabricCost(fabricCost);
            bCost.setFiberCost(fiberCost);
            bCost.setFiberWeight(fiberWeight);
            bCost.setTagCost(tagPrice);
            bCost.setLableCost(lablePrice);
            bCost.setThreadCost(threadPrice);
            bCost.setPEBagCost(peBagPrice);
            bCost.setTotalMaterialCost(materialCost);

            bCost.setLabourCost(cplmCost);
            bCost.setPohCost(pohCost);
            bCost.setSmvValue(smv);

            Double totalCost = materialCost + pohCost + cplmCost;
            bCost.setTotalCost(totalCost);

        } catch (Exception ex) {
            System.out.println("Error");
        }

        return bCost;
    }
}
