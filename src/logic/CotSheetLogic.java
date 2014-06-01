package logic;

import algorithms.Approximate;
import dataaccess.CotSheetDataAccess;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import viewmodels.CotSheetViewModel;

public class CotSheetLogic {

    public static String[] getMaterialTypes() {
        try {
            return CotSheetDataAccess.getInstance().getMaterialTypes();
        } catch (SQLException ex) {
            Logger.getLogger(CotSheetLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getTaffataTypes() {
        try {
            return CotSheetDataAccess.getInstance().getTaffataTypes();
        } catch (SQLException ex) {
            Logger.getLogger(CotSheetLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getPaddingTypes() {
        try {
            return CotSheetDataAccess.getInstance().getPaddingTypes();
        } catch (SQLException ex) {
            Logger.getLogger(CotSheetLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getCotSheetizes() {
        try {
            return CotSheetDataAccess.getInstance().getCotSheetSizes();
        } catch (SQLException ex) {
            Logger.getLogger(CotSheetLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static CotSheetViewModel getCostPerUnit(CotSheetViewModel cCost) {
        try {
            Double fabricPrice = CotSheetDataAccess.getInstance().getMaterialPrice(cCost.getMaterialType());
            Integer materialWidth = CotSheetDataAccess.getInstance().getMaterialWidth(cCost.getMaterialType());
            Double fabricWastage = cCost.getFabricWastage();

            Double taffataPrice = CotSheetDataAccess.getInstance().getTaffataPrice(cCost.getTaffataType());
            Double taffataWidth = CotSheetDataAccess.getInstance().getTaffataWidth(cCost.getTaffataType());
            Double taffataWastage = cCost.getTaffataWastage();

            Double paddingPrice = CotSheetDataAccess.getInstance().getPaddingPrice(cCost.getPaddingType());
            Double paddingWidth = CotSheetDataAccess.getInstance().getPaddingWidth(cCost.getPaddingType());
            Double paddingWastage = cCost.getPaddingWastage();

            Double widthQuitingShrinkage = cCost.getWidthQuiltyShrinkage();
            Double hightQuitingShrinkage = cCost.getHeightQuiltyShrinkage();

            Double width, height;
            Double labelCost, tagCost, threadCost, peBagCost, smv, elasticCost;
            if (cCost.isIsCustom()) {
                width = cCost.getCustomWidth();
                height = cCost.getCustomHeight();

                if (cCost.isIncludeTag()) {
                    tagCost = CotSheetDataAccess.getInstance().getTagCost();
                } else {
                    tagCost = 0.0;
                }

                if (cCost.isIncludeLable()) {
                    labelCost = CotSheetDataAccess.getInstance().getLableCost();
                } else {
                    labelCost = 0.0;
                }

                threadCost = CotSheetDataAccess.getInstance().getThreadCost();

                //smv = has to calculate
                double[][] arr = CotSheetDataAccess.getInstance().getSMVXYPairs();
                Approximate approx = new Approximate(arr[0], arr[1]);
                smv = approx.getApproximatedValue(((double)height+width));
            } else {
                width = Double.parseDouble(cCost.getSize().split("X")[0]);
                height = Double.parseDouble(cCost.getSize().split("X")[1]);

                tagCost = CotSheetDataAccess.getInstance().getTagCost();
                labelCost = CotSheetDataAccess.getInstance().getLableCost();
                threadCost = CotSheetDataAccess.getInstance().getThreadCost();
                smv = CotSheetDataAccess.getInstance().getSMVValue(cCost.getSize());
            }

            cCost.setSmvValue(smv);

            //Fabric Padding cutting sizes
            Double fabricPaddingCutWidth = (width + 1.5) * (1 + widthQuitingShrinkage / 100);
            Double fabricPaddingCutHeight = (height + 1.5) * (1 + hightQuitingShrinkage / 100);

            cCost.setFabricPaddingCuttingWidth(fabricPaddingCutWidth);
            cCost.setFabricPaddingCuttingHeight(fabricPaddingCutHeight);

            //Taffata Cut Sizes
            Double taffataCutWidth = (width + 1.5);
            Double taffataCutHeight = (height + 1.5);

            cCost.setTaffataCuttingWidth(taffataCutWidth);
            cCost.setTaffataCuttingHeight(taffataCutHeight);

            //pe bag cost
            if ((cCost.isIsCustom() && cCost.isIncludePEBag()) || !cCost.isIsCustom()) {
                peBagCost = CotSheetDataAccess.getInstance().getPEBagCost();
            } else {
                peBagCost = 0.0;
            }

            //elastic cost
            if (width + height >= 74) {
                elasticCost = 56.0 / 36 * CotSheetDataAccess.getInstance().getElasticCost();
            } else {
                elasticCost = 0.0;
            }

            //fabric cost
            Double fabricPaddingCutArea = fabricPaddingCutWidth * fabricPaddingCutHeight;

            Double fabricPricePerUnitInch = fabricPrice / (materialWidth * 36);
            Double fabricCost = (fabricPricePerUnitInch * fabricPaddingCutArea) * (1 + fabricWastage / 100);

            /**Material Consumption***/
            double materialConsumption = fabricPaddingCutArea/(materialWidth*39.4) * (1 + fabricWastage/100);
            HashMap fabric = new HashMap();
            fabric.put(cCost.getMaterialType(), materialConsumption+"");
            cCost.setFabric(fabric);
            
            //there are non usable fabric wastages
            if ((materialWidth - fabricPaddingCutWidth) < 9) {
                fabricCost = fabricCost + (materialWidth - fabricPaddingCutWidth) * fabricPaddingCutHeight * fabricPricePerUnitInch;
            }

            //padding cost
            Double paddingPricePerUnitInch = paddingPrice / (paddingWidth * 36);
            Double paddingCost = (paddingPricePerUnitInch * fabricPaddingCutArea) * (1 + paddingWastage / 100);

            /**Padding Consumption***/
            double paddingConsumption = fabricPaddingCutArea/(paddingWidth*39.4) * (1 + paddingWastage/100);
            HashMap padding = new HashMap();
            padding.put(cCost.getPaddingType(), paddingConsumption+"");
            cCost.setPadding(padding);
            
            //there are non usable padding wastages
            if ((paddingWidth - fabricPaddingCutWidth) < 19) {
                paddingCost = paddingCost + (paddingWidth - fabricPaddingCutWidth) * fabricPaddingCutHeight * paddingPricePerUnitInch;
            }

            //taffata cost
            Double taffataCutArea = taffataCutHeight * taffataCutWidth;

            Double taffataPricePerUnitInch = taffataPrice / (taffataWidth * 36);
            Double taffataCost = (taffataPricePerUnitInch * taffataCutArea) * (1 + taffataWastage / 100);

            /**Taffata Consumption***/
            double taffataConsumption = taffataCutArea/(taffataWidth*39.4) * (1 + taffataWastage/100);
            HashMap taffata = new HashMap();
            taffata.put(cCost.getTaffataType(), taffataConsumption+"");
            cCost.setTaffata(taffata);


            Double cplm = CotSheetDataAccess.getInstance().getCostPerLabourMinute();
            Double poh = CotSheetDataAccess.getInstance().getPOHValue();

            Double pohCost = smv * poh;
            Double labourCost = smv * cplm;


            Double totalCost = fabricCost + paddingCost + taffataCost + elasticCost + peBagCost + tagCost + labelCost + threadCost + pohCost + labourCost + cCost.getOtherCost();
            Double totalMaterialCost = fabricCost + paddingCost + taffataCost + elasticCost + peBagCost + tagCost + labelCost + threadCost + cCost.getOtherCost();
            Double netSellingPrice = totalCost * ( 1.00 + cCost.getMargin()/100.0);
            Double taxes = netSellingPrice * (cCost.getTaxRate()/100.0);
            Double grossSellingPrice = netSellingPrice + taxes;

            cCost.setTotalMaterialCost(totalMaterialCost);
            cCost.setFabricCost(fabricCost);
            cCost.setPaddingCost(paddingCost);
            cCost.setTaffataCost(taffataCost);
            cCost.setElasticCost(elasticCost);
            cCost.setPEBagCost(peBagCost);
            cCost.setTagCost(tagCost);
            cCost.setLableCost(labelCost);
            cCost.setThreadCost(threadCost);
            cCost.setPohCost(pohCost);
            cCost.setLabourCost(labourCost);
            cCost.setTotalCost(totalCost);
            cCost.setNetSellingPrice(netSellingPrice);
            cCost.setTaxes(taxes);
            cCost.setGrossSellingPrice(grossSellingPrice);

            cCost.setFabricPaddingCuttingHeight(fabricPaddingCutHeight);
            cCost.setFabricPaddingCuttingWidth(fabricPaddingCutWidth);
            cCost.setTaffataCuttingWidth(taffataCutWidth);
            cCost.setTaffataCuttingHeight(taffataCutHeight);

        } catch (Exception e) {
            System.out.println("Error");
        }

        return cCost;
    }
}
