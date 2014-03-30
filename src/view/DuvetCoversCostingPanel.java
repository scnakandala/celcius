package view;

import celcius.Config;
import excel.ItemSummaryObject;
import excel.QuationObject;
import excel.SummaryObject;
import java.awt.EventQueue;
import java.text.DecimalFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logic.DuvetCoversLogic;
import ui.helpers.ComboBoxRenderer;
import viewmodels.DovetCoversViewModel;

public class DuvetCoversCostingPanel extends javax.swing.JPanel {

    public DuvetCoversCostingPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        duvetCoversCostingPanel = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        dovetCoversProductRangeCombo = new javax.swing.JComboBox();
        jLabel53 = new javax.swing.JLabel();
        dovetCoversMaterialTypeCombo = new javax.swing.JComboBox();
        dovetCoversSizeCombo = new javax.swing.JComboBox();
        dovetCoversWastage = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        duvetCoverSizeLable = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        dovetCoversUseCustom = new javax.swing.JRadioButton();
        dovetCoversCustomPanel = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        dovetCoversCustomWidth = new javax.swing.JTextField();
        dovetCoversCustomHeight = new javax.swing.JTextField();
        dovetCoversIncludeLable = new javax.swing.JRadioButton();
        dovetCoversIncludeTag = new javax.swing.JRadioButton();
        dovetCoversIncludeSealBag = new javax.swing.JRadioButton();
        dovetCoversIncludeCardBoard = new javax.swing.JRadioButton();
        dovetCoversCustomFlapLable = new javax.swing.JLabel();
        dovetCoverCustomFlap = new javax.swing.JTextField();
        dovetCoversSubmitButton = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        dovetCoversTypeCombo = new javax.swing.JComboBox();
        jLabel297 = new javax.swing.JLabel();
        jLabel298 = new javax.swing.JLabel();
        duvetCoversTaxField = new javax.swing.JTextField();
        jLabel299 = new javax.swing.JLabel();
        jLabel300 = new javax.swing.JLabel();
        duvetCoversMarginField = new javax.swing.JTextField();
        jLabel301 = new javax.swing.JLabel();
        duvetCoversOtherCostVal = new javax.swing.JTextField();
        jLabel302 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        duvetCversCPUPanel2 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        dovetCoversSMVValue = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        dovetCoversCutWidth = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        dovetCoversCutHeight = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        dovetCoversCardBoardCost = new javax.swing.JLabel();
        dovetCoversPOH = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        dovetCoversSealBagCost = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        dovetCoversVelcoCost = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        dovetCoversLableCost = new javax.swing.JLabel();
        dovetCoversZipperCost = new javax.swing.JLabel();
        dovetCoversTagCost = new javax.swing.JLabel();
        dovetCoversTotalMaterialCost = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        dovetCoversThreadCost = new javax.swing.JLabel();
        dovetCoversToatalCost = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        dovetCoversFabricCost = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        dovetCoversLabourCost = new javax.swing.JLabel();
        dovetCoversButtonCost = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel331 = new javax.swing.JLabel();
        jLabel332 = new javax.swing.JLabel();
        jLabel333 = new javax.swing.JLabel();
        dovetCoversNetSellingPrice = new javax.swing.JLabel();
        dovetCoversTaxes = new javax.swing.JLabel();
        dovetCoversGrossSellingPrice = new javax.swing.JLabel();
        duvetExportButton = new javax.swing.JButton();

        duvetCoversCostingPanel.setMinimumSize(new java.awt.Dimension(500, 573));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel37.setText("Duvet Covers Costing");

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel52.setText("Select Product Range:");

        dovetCoversProductRangeCombo.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversProductRangeCombo.setModel(new javax.swing.DefaultComboBoxModel(DuvetCoversLogic.getProductRanges()));
        dovetCoversProductRangeCombo.setRenderer(new ComboBoxRenderer(DuvetCoversLogic.getProductRanges()));
        dovetCoversProductRangeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dovetCoversProductRangeComboActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel53.setText("Select Material Type:");

        dovetCoversMaterialTypeCombo.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversMaterialTypeCombo.setModel(new javax.swing.DefaultComboBoxModel(logic.DuvetCoversLogic.getMaterialTypes((String)dovetCoversProductRangeCombo.getSelectedItem())));
        dovetCoversMaterialTypeCombo.setRenderer(new ComboBoxRenderer(logic.DuvetCoversLogic.getMaterialTypes((String)dovetCoversProductRangeCombo.getSelectedItem())));

        dovetCoversSizeCombo.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversSizeCombo.setModel(new javax.swing.DefaultComboBoxModel(logic.DuvetCoversLogic.getDuvetCoverSizes()));
        dovetCoversSizeCombo.setRenderer(new ComboBoxRenderer(logic.DuvetCoversLogic.getDuvetCoverSizes()));
        dovetCoversSizeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dovetCoversSizeComboActionPerformed(evt);
            }
        });

        dovetCoversWastage.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversWastage.setText("3");
        dovetCoversWastage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dovetCoversWastageActionPerformed(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel54.setText("%");

        duvetCoverSizeLable.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        duvetCoverSizeLable.setText("Select Size:");

        jLabel56.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel56.setText("Wastage:");

        dovetCoversUseCustom.setBackground(new java.awt.Color(204, 204, 204));
        dovetCoversUseCustom.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversUseCustom.setText("Use Custom Sizes");
        dovetCoversUseCustom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dovetCoversUseCustomActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel57.setText("Width (inches) :");

        jLabel58.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel58.setText("Height (inches):");

        dovetCoversCustomWidth.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        dovetCoversCustomHeight.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        dovetCoversIncludeLable.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversIncludeLable.setText("Include Lable");

        dovetCoversIncludeTag.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversIncludeTag.setText("Include Tag");

        dovetCoversIncludeSealBag.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversIncludeSealBag.setText("Include Seal Bag");

        dovetCoversIncludeCardBoard.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversIncludeCardBoard.setText("Include Cardboard");

        dovetCoversCustomFlapLable.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversCustomFlapLable.setText("Flap  (inches):");

        dovetCoverCustomFlap.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoverCustomFlap.setText("10");

        dovetCoversCustomPanel.setVisible(false);

        javax.swing.GroupLayout dovetCoversCustomPanelLayout = new javax.swing.GroupLayout(dovetCoversCustomPanel);
        dovetCoversCustomPanel.setLayout(dovetCoversCustomPanelLayout);
        dovetCoversCustomPanelLayout.setHorizontalGroup(
            dovetCoversCustomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dovetCoversCustomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dovetCoversCustomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dovetCoversIncludeCardBoard)
                    .addComponent(dovetCoversIncludeTag)
                    .addComponent(dovetCoversIncludeSealBag)
                    .addComponent(dovetCoversIncludeLable)
                    .addGroup(dovetCoversCustomPanelLayout.createSequentialGroup()
                        .addGroup(dovetCoversCustomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58)
                            .addComponent(jLabel57)
                            .addComponent(dovetCoversCustomFlapLable))
                        .addGap(129, 129, 129)
                        .addGroup(dovetCoversCustomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dovetCoverCustomFlap)
                            .addComponent(dovetCoversCustomHeight)
                            .addComponent(dovetCoversCustomWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dovetCoversCustomPanelLayout.setVerticalGroup(
            dovetCoversCustomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dovetCoversCustomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dovetCoversCustomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dovetCoversCustomWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dovetCoversCustomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dovetCoversCustomHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addGroup(dovetCoversCustomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dovetCoversCustomPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(dovetCoversIncludeLable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dovetCoversIncludeTag)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dovetCoversIncludeSealBag)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dovetCoversIncludeCardBoard))
                    .addGroup(dovetCoversCustomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dovetCoverCustomFlap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dovetCoversCustomFlapLable)))
                .addContainerGap())
        );

        dovetCoversCustomFlapLable.setVisible(false);
        dovetCoverCustomFlap.setVisible(false);

        dovetCoversSubmitButton.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversSubmitButton.setText("Find Cost Per Unit");
        dovetCoversSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dovetCoversSubmitButtonActionPerformed(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel73.setText("Select Duvet Cover Type:");

        dovetCoversTypeCombo.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversTypeCombo.setModel(new javax.swing.DefaultComboBoxModel(logic.DuvetCoversLogic.getDuvetCoverTypes()));
        dovetCoversTypeCombo.setRenderer(new ComboBoxRenderer(logic.DuvetCoversLogic.getDuvetCoverTypes()));
        dovetCoversTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dovetCoversTypeComboActionPerformed(evt);
            }
        });

        jLabel297.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel297.setText("Margin:");

        jLabel298.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel298.setText("Taxes:");

        duvetCoversTaxField.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        duvetCoversTaxField.setText(Config.taxesRate);

        jLabel299.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel299.setText("%");

        jLabel300.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel300.setText("%");

        duvetCoversMarginField.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        duvetCoversMarginField.setText(Config.profitMargin);

        jLabel301.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel301.setText("Other cost:");

        duvetCoversOtherCostVal.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        duvetCoversOtherCostVal.setText("0.0");
        duvetCoversTaxField.setText(Config.taxesRate);

        jLabel302.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel302.setText("Quantity");

        quantity.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        quantity.setText("1");
        duvetCoversTaxField.setText(Config.taxesRate);

        javax.swing.GroupLayout duvetCoversCostingPanelLayout = new javax.swing.GroupLayout(duvetCoversCostingPanel);
        duvetCoversCostingPanel.setLayout(duvetCoversCostingPanelLayout);
        duvetCoversCostingPanelLayout.setHorizontalGroup(
            duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(duvetCoversCostingPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(duvetCoversCostingPanelLayout.createSequentialGroup()
                        .addComponent(dovetCoversUseCustom)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(duvetCoversCostingPanelLayout.createSequentialGroup()
                        .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel298)
                            .addComponent(jLabel297))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(duvetCoversCostingPanelLayout.createSequentialGroup()
                                .addComponent(duvetCoversTaxField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel299))
                            .addGroup(duvetCoversCostingPanelLayout.createSequentialGroup()
                                .addComponent(duvetCoversMarginField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel300)))
                        .addGap(134, 134, 134))
                    .addGroup(duvetCoversCostingPanelLayout.createSequentialGroup()
                        .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dovetCoversCustomPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, duvetCoversCostingPanelLayout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, duvetCoversCostingPanelLayout.createSequentialGroup()
                                .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel53)
                                    .addComponent(jLabel52)
                                    .addComponent(jLabel73)
                                    .addComponent(duvetCoverSizeLable)
                                    .addComponent(jLabel56))
                                .addGap(76, 76, 76)
                                .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(duvetCoversCostingPanelLayout.createSequentialGroup()
                                        .addComponent(dovetCoversWastage, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel54))
                                    .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(dovetCoversTypeCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dovetCoversMaterialTypeCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dovetCoversProductRangeCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dovetCoversSizeCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, duvetCoversCostingPanelLayout.createSequentialGroup()
                        .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(duvetCoversCostingPanelLayout.createSequentialGroup()
                                .addComponent(jLabel302)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(duvetCoversCostingPanelLayout.createSequentialGroup()
                                .addComponent(jLabel301)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(duvetCoversOtherCostVal, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(151, 151, 151))))
            .addGroup(duvetCoversCostingPanelLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(dovetCoversSubmitButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        duvetCoversCostingPanelLayout.setVerticalGroup(
            duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(duvetCoversCostingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addGap(11, 11, 11)
                .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dovetCoversProductRangeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addGap(9, 9, 9)
                .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dovetCoversMaterialTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(dovetCoversTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(duvetCoverSizeLable)
                    .addComponent(dovetCoversSizeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(dovetCoversWastage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dovetCoversUseCustom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dovetCoversCustomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel297)
                    .addComponent(duvetCoversMarginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel300))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel298)
                    .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel299)
                        .addComponent(duvetCoversTaxField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel301)
                    .addComponent(duvetCoversOtherCostVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(duvetCoversCostingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel302)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dovetCoversSubmitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel21.setPreferredSize(new java.awt.Dimension(400, 157));

        jLabel68.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel68.setText("Cutting Width:");

        jLabel69.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel69.setText("Cutting Height:");

        dovetCoversSMVValue.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversSMVValue.setText("0.00");

        jLabel70.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel70.setText("SMV Value:");

        dovetCoversCutWidth.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversCutWidth.setText("0.00");

        jLabel71.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel71.setText("Production Parameters");

        dovetCoversCutHeight.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversCutHeight.setText("0.00");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel70)
                    .addComponent(jLabel69)
                    .addComponent(jLabel68))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dovetCoversSMVValue)
                    .addComponent(dovetCoversCutHeight)
                    .addComponent(dovetCoversCutWidth))
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(jLabel71)
                .addGap(147, 147, 147))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel68)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel69)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dovetCoversCutWidth)
                        .addGap(18, 18, 18)
                        .addComponent(dovetCoversCutHeight)
                        .addGap(18, 18, 18)
                        .addComponent(dovetCoversSMVValue)))
                .addContainerGap())
        );

        jLabel66.setBackground(new java.awt.Color(204, 204, 204));
        jLabel66.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel66.setText("Toatal Cost Per Unit:");

        jLabel61.setBackground(new java.awt.Color(204, 204, 204));
        jLabel61.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel61.setText("Lable Cost:");

        dovetCoversCardBoardCost.setBackground(new java.awt.Color(204, 204, 204));
        dovetCoversCardBoardCost.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversCardBoardCost.setText("0.00");

        dovetCoversPOH.setBackground(new java.awt.Color(204, 204, 204));
        dovetCoversPOH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversPOH.setText("0.00");

        jLabel63.setBackground(new java.awt.Color(204, 204, 204));
        jLabel63.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel63.setText("Seal Bag Cost:");

        dovetCoversSealBagCost.setBackground(new java.awt.Color(204, 204, 204));
        dovetCoversSealBagCost.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversSealBagCost.setText("0.00");

        jLabel67.setBackground(new java.awt.Color(204, 204, 204));
        jLabel67.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel67.setText("Cost Per Unit");

        dovetCoversVelcoCost.setBackground(new java.awt.Color(204, 204, 204));
        dovetCoversVelcoCost.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversVelcoCost.setText("0.00");

        jLabel60.setBackground(new java.awt.Color(204, 204, 204));
        jLabel60.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel60.setText("Thread Cost:");

        jLabel72.setBackground(new java.awt.Color(204, 204, 204));
        jLabel72.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel72.setText("Card Board Cost: ");

        jLabel79.setBackground(new java.awt.Color(204, 204, 204));
        jLabel79.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel79.setText("Total Material Cost");

        dovetCoversLableCost.setBackground(new java.awt.Color(204, 204, 204));
        dovetCoversLableCost.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversLableCost.setText("0.00");

        dovetCoversZipperCost.setBackground(new java.awt.Color(204, 204, 204));
        dovetCoversZipperCost.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversZipperCost.setText("0.00");

        dovetCoversTagCost.setBackground(new java.awt.Color(204, 204, 204));
        dovetCoversTagCost.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversTagCost.setText("0.00");

        dovetCoversTotalMaterialCost.setBackground(new java.awt.Color(204, 204, 204));
        dovetCoversTotalMaterialCost.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        dovetCoversTotalMaterialCost.setText("0.00");

        jLabel76.setBackground(new java.awt.Color(204, 204, 204));
        jLabel76.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel76.setText("Velco Cost");

        dovetCoversThreadCost.setBackground(new java.awt.Color(204, 204, 204));
        dovetCoversThreadCost.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversThreadCost.setText("0.00");

        dovetCoversToatalCost.setBackground(new java.awt.Color(204, 204, 204));
        dovetCoversToatalCost.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        dovetCoversToatalCost.setText("0.00");

        jLabel64.setBackground(new java.awt.Color(204, 204, 204));
        jLabel64.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel64.setText("POH:");

        dovetCoversFabricCost.setBackground(new java.awt.Color(204, 204, 204));
        dovetCoversFabricCost.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversFabricCost.setText("0.00");

        jLabel75.setBackground(new java.awt.Color(204, 204, 204));
        jLabel75.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel75.setText("Zipper Cost");

        jLabel65.setBackground(new java.awt.Color(204, 204, 204));
        jLabel65.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel65.setText("Labour Cost:");

        jLabel74.setBackground(new java.awt.Color(204, 204, 204));
        jLabel74.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel74.setText("Button Cost");

        dovetCoversLabourCost.setBackground(new java.awt.Color(204, 204, 204));
        dovetCoversLabourCost.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversLabourCost.setText("0.00");

        dovetCoversButtonCost.setBackground(new java.awt.Color(204, 204, 204));
        dovetCoversButtonCost.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        dovetCoversButtonCost.setText("0.00");

        jLabel62.setBackground(new java.awt.Color(204, 204, 204));
        jLabel62.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel62.setText("Tag Cost:");

        jLabel59.setBackground(new java.awt.Color(204, 204, 204));
        jLabel59.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel59.setText("Fabric Cost:");

        jLabel331.setBackground(new java.awt.Color(204, 204, 204));
        jLabel331.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel331.setText("Net Selling Price:");

        jLabel332.setBackground(new java.awt.Color(204, 204, 204));
        jLabel332.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel332.setText("Taxes:");

        jLabel333.setBackground(new java.awt.Color(204, 204, 204));
        jLabel333.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel333.setText("Gross Selling Price:");

        dovetCoversNetSellingPrice.setBackground(new java.awt.Color(204, 204, 204));
        dovetCoversNetSellingPrice.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        dovetCoversNetSellingPrice.setText("0.00");

        dovetCoversTaxes.setBackground(new java.awt.Color(204, 204, 204));
        dovetCoversTaxes.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        dovetCoversTaxes.setText("0.00");

        dovetCoversGrossSellingPrice.setBackground(new java.awt.Color(204, 204, 204));
        dovetCoversGrossSellingPrice.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        dovetCoversGrossSellingPrice.setText("0.00");

        duvetExportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/export.png"))); // NOI18N
        duvetExportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duvetExportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(duvetExportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel79)
                            .addComponent(jLabel63)
                            .addComponent(jLabel72)
                            .addComponent(jLabel59)
                            .addComponent(jLabel60)
                            .addComponent(jLabel61)
                            .addComponent(jLabel62)
                            .addComponent(jLabel74)
                            .addComponent(jLabel75)
                            .addComponent(jLabel76)
                            .addComponent(jLabel66)
                            .addComponent(jLabel65)
                            .addComponent(jLabel64)
                            .addComponent(jLabel331)
                            .addComponent(jLabel332)
                            .addComponent(jLabel333))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dovetCoversTotalMaterialCost, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dovetCoversTagCost, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dovetCoversZipperCost, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dovetCoversLabourCost, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dovetCoversButtonCost, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dovetCoversFabricCost, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dovetCoversToatalCost, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dovetCoversThreadCost, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dovetCoversCardBoardCost, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dovetCoversPOH, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dovetCoversGrossSellingPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dovetCoversTaxes, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dovetCoversSealBagCost, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dovetCoversVelcoCost, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dovetCoversLableCost, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dovetCoversNetSellingPrice, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel67)
                        .addContainerGap())))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(duvetExportButton)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(dovetCoversFabricCost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dovetCoversThreadCost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dovetCoversLableCost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dovetCoversTagCost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dovetCoversCardBoardCost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dovetCoversSealBagCost)
                                .addGap(8, 8, 8)
                                .addComponent(dovetCoversButtonCost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dovetCoversZipperCost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dovetCoversVelcoCost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dovetCoversTotalMaterialCost)
                                .addGap(18, 18, 18)
                                .addComponent(dovetCoversPOH)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dovetCoversLabourCost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dovetCoversToatalCost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dovetCoversNetSellingPrice)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dovetCoversTaxes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dovetCoversGrossSellingPrice))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel61)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel62)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel72)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel63)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel74)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel75)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel76)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel79)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel64)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel65)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel66)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel331)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel332)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel333)))))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout duvetCversCPUPanel2Layout = new javax.swing.GroupLayout(duvetCversCPUPanel2);
        duvetCversCPUPanel2.setLayout(duvetCversCPUPanel2Layout);
        duvetCversCPUPanel2Layout.setHorizontalGroup(
            duvetCversCPUPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(duvetCversCPUPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(duvetCversCPUPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE))
                .addContainerGap())
        );
        duvetCversCPUPanel2Layout.setVerticalGroup(
            duvetCversCPUPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(duvetCversCPUPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(duvetCoversCostingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(duvetCversCPUPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(duvetCoversCostingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(duvetCversCPUPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        duvetCversCPUPanel2.setVisible(false);
    }// </editor-fold>//GEN-END:initComponents

    private void dovetCoversProductRangeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dovetCoversProductRangeComboActionPerformed
        dovetCoversMaterialTypeCombo.setModel(new DefaultComboBoxModel(DuvetCoversLogic.getMaterialTypes((String) dovetCoversProductRangeCombo.getSelectedItem())));
}//GEN-LAST:event_dovetCoversProductRangeComboActionPerformed

    private void dovetCoversSizeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dovetCoversSizeComboActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dovetCoversSizeComboActionPerformed

    private void dovetCoversWastageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dovetCoversWastageActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dovetCoversWastageActionPerformed

    private void dovetCoversUseCustomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dovetCoversUseCustomActionPerformed
        if (dovetCoversUseCustom.isSelected()) {
            dovetCoversCustomPanel.setVisible(true);
            if (((String) dovetCoversTypeCombo.getSelectedItem()).equals("envelope")) {
                dovetCoverCustomFlap.setVisible(true);
                dovetCoversCustomFlapLable.setVisible(true);
            }
            duvetCoverSizeLable.setVisible(false);
            dovetCoversSizeCombo.setVisible(false);
        } else {
            dovetCoversCustomPanel.setVisible(false);
            dovetCoverCustomFlap.setVisible(false);
            dovetCoversCustomFlapLable.setVisible(false);
            duvetCoverSizeLable.setVisible(true);
            dovetCoversSizeCombo.setVisible(true);
        }
}//GEN-LAST:event_dovetCoversUseCustomActionPerformed

    private void dovetCoversSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dovetCoversSubmitButtonActionPerformed
        DovetCoversViewModel dCost = new DovetCoversViewModel();
        String productRange = (String) dovetCoversProductRangeCombo.getSelectedItem();
        dCost.setProductRange(productRange);

        String materialType = (String) dovetCoversMaterialTypeCombo.getSelectedItem();
        dCost.setMaterialType(materialType);

        String size = (String) dovetCoversSizeCombo.getSelectedItem();
        dCost.setSize(size);

        String type = (String) dovetCoversTypeCombo.getSelectedItem();
        dCost.setDuvetCoverType(type);

        try {
            double wastage = Double.parseDouble(dovetCoversWastage.getText());
            if (wastage < 0 || wastage > 10) {
                JOptionPane.showMessageDialog(this, "Wastage should be between 0 and 10 %");
                return;
            }
            dCost.setWastage(wastage);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid wastage value");
            return;
        }

        try {
            double otherCost = Double.parseDouble(duvetCoversOtherCostVal.getText());
            if (otherCost < 0) {
                JOptionPane.showMessageDialog(this, "Please enter a valid value for other costs");
                return;
            }
            dCost.setOtherCost(otherCost);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid value for other costs");
            return;
        }

        try {
            double margin = Double.parseDouble(duvetCoversMarginField.getText());
            if (margin < 0) {
                JOptionPane.showMessageDialog(this, "Profit margin should be a positive value");
                return;
            }
            dCost.setMargin(margin);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid margin value");
            return;
        }

        try {
            double taxRate = Double.parseDouble(duvetCoversTaxField.getText());
            if (taxRate < 0) {
                JOptionPane.showMessageDialog(this, "Tax rate should be a positive value");
                return;
            }
            dCost.setTaxRate(taxRate);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid tax rate value");
            return;
        }

        boolean useCustom = dovetCoversUseCustom.isSelected();
        if (useCustom) {
            dCost.setIsCustom(useCustom);
            try {
                Double width = Double.parseDouble(dovetCoversCustomWidth.getText());
                if (width <= 0 || width > 120) {
                    JOptionPane.showMessageDialog(this, "Width should be between 0 and 120");
                    return;
                }
                dCost.setCustomWidth(width);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid width value");
                return;
            }

            try {
                Double height = Double.parseDouble(dovetCoversCustomHeight.getText());
                if (height <= 0 || height > 120) {
                    JOptionPane.showMessageDialog(this, "Height should be between 0 and 120");
                    return;
                }
                dCost.setCustomHeight(height);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid height value");
                return;
            }

            if (dCost.getDuvetCoverType().equals("envelope")) {
                try {
                    Integer flap = Integer.parseInt(dovetCoverCustomFlap.getText());
                    if (flap <= 0 || flap > 120) {
                        JOptionPane.showMessageDialog(this, "Flap size should be between 0 and 120");
                        return;
                    }
                    dCost.setFlap((double) flap);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid number for flap size");
                    return;
                }
            }

            dCost.setIncludeLable(dovetCoversIncludeLable.isSelected());
            dCost.setIncludeTag(dovetCoversIncludeTag.isSelected());
            dCost.setIncludeSealBag(dovetCoversIncludeSealBag.isSelected());
            dCost.setIncludeCardBoard(dovetCoversIncludeCardBoard.isSelected());
        }
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);

        DovetCoversViewModel dReturn = DuvetCoversLogic.getCostPerUnit(dCost);
        dovetCoversFabricCost.setText(format.format(dReturn.getFabricCost()) + "");
        dovetCoversThreadCost.setText(format.format(dReturn.getThreadCost()) + "");
        dovetCoversLableCost.setText(format.format(dReturn.getLableCost()) + "");
        dovetCoversTagCost.setText(format.format(dReturn.getTagCost()) + "");
        dovetCoversSealBagCost.setText(format.format(dReturn.getSealBagCost()) + "");
        dovetCoversCardBoardCost.setText(format.format(dReturn.getCardboardCost()) + "");
        dovetCoversPOH.setText(format.format(dReturn.getPohCost()) + "");
        dovetCoversLabourCost.setText(format.format(dReturn.getLabourCost()) + "");
        dovetCoversToatalCost.setText(format.format(dReturn.getTotalCost()) + "");
        dovetCoversCutWidth.setText(format.format(dReturn.getCuttingWidth()));
        dovetCoversCutHeight.setText(format.format(dReturn.getCuttingHeight()));
        dovetCoversSMVValue.setText(format.format(dReturn.getSmvValue()));
        dovetCoversButtonCost.setText(format.format(dReturn.getButtonCost()));
        dovetCoversZipperCost.setText(format.format(dReturn.getZipperCost()));
        dovetCoversVelcoCost.setText(format.format(dReturn.getVelcoCost()));
        dovetCoversTotalMaterialCost.setText(format.format(dReturn.getTotalMaterialCost()));
        dovetCoversNetSellingPrice.setText(format.format(dReturn.getNetSellingPrice()));
        dovetCoversTaxes.setText(format.format(dReturn.getTaxes()));
        dovetCoversGrossSellingPrice.setText(format.format(dReturn.getGrossSellingPrice()));

        duvetCversCPUPanel2.setVisible(true);
}//GEN-LAST:event_dovetCoversSubmitButtonActionPerformed

    private void dovetCoversTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dovetCoversTypeComboActionPerformed
        if ((dovetCoversTypeCombo.getSelectedItem()).equals("envelope")) {
            dovetCoversCustomFlapLable.setVisible(true);
            dovetCoverCustomFlap.setVisible(true);
        } else {
            dovetCoversCustomFlapLable.setVisible(false);
            dovetCoverCustomFlap.setVisible(false);

        }
}//GEN-LAST:event_dovetCoversTypeComboActionPerformed

    private void duvetExportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duvetExportButtonActionPerformed
        //ading the quotation object
        QuationObject qObject = new QuationObject(
                "Duvet Cover",
                dovetCoversProductRangeCombo.getSelectedItem() + "",
                dovetCoversMaterialTypeCombo.getSelectedItem() + "",
                dovetCoversUseCustom.isSelected() == true ? dovetCoversCustomHeight.getText() + "X" + dovetCoversCustomWidth.getText() : dovetCoversSizeCombo.getSelectedItem() + "",
                1,
                Double.parseDouble(dovetCoversGrossSellingPrice.getText().replaceAll(",", "")));

        //adding the costing summary object
        SummaryObject summaryObj = new SummaryObject(
                "Duvet Cover",
                dovetCoversProductRangeCombo.getSelectedItem() + "",
                dovetCoversMaterialTypeCombo.getSelectedItem() + "",
                "",
                dovetCoversUseCustom.isSelected() == true ? dovetCoversCutHeight.getText() + "X" + dovetCoversCustomHeight.getText() : dovetCoversSizeCombo.getSelectedItem() + "",
                1,
                Double.parseDouble(dovetCoversToatalCost.getText().replaceAll(",", "")),
                Double.parseDouble(duvetCoversMarginField.getText().replaceAll(",", "")),
                Double.parseDouble(duvetCoversTaxField.getText().replaceAll(",", "")));

        //have to add data to this
        ArrayList<Map.Entry<String, String>> prodSpecs = new ArrayList<Map.Entry<String, String>>();
        prodSpecs.add(new AbstractMap.SimpleEntry<String, String>("Product Range", dovetCoversProductRangeCombo.getSelectedItem() + ""));
        prodSpecs.add(new AbstractMap.SimpleEntry<String, String>("Material Type", dovetCoversMaterialTypeCombo.getSelectedItem() + ""));
        prodSpecs.add(new AbstractMap.SimpleEntry<String, String>("Duvet Cover Type", dovetCoversTypeCombo.getSelectedItem() + ""));
        prodSpecs.add(new AbstractMap.SimpleEntry<String, String>("Size", dovetCoversUseCustom.isSelected() == true ? dovetCoversCustomHeight.getText() + "X" + dovetCoversCustomWidth.getText() : dovetCoversSizeCombo.getSelectedItem() + ""));
        prodSpecs.add(new AbstractMap.SimpleEntry<String, String>("Wastage", dovetCoversWastage.getText() + ""));
        prodSpecs.add(new AbstractMap.SimpleEntry<String, String>("Flap", dovetCoverCustomFlap.getText() + ""));
        prodSpecs.add(new AbstractMap.SimpleEntry<String, String>("Include Lable", dovetCoversIncludeLable.isSelected() + ""));
        prodSpecs.add(new AbstractMap.SimpleEntry<String, String>("Include Tag", dovetCoversIncludeTag.isSelected() + ""));
        prodSpecs.add(new AbstractMap.SimpleEntry<String, String>("Include Seal Bag", dovetCoversIncludeSealBag.isSelected() + ""));
        prodSpecs.add(new AbstractMap.SimpleEntry<String, String>("Include Cardboard", dovetCoversIncludeCardBoard.isSelected() + ""));
        prodSpecs.add(new AbstractMap.SimpleEntry<String, String>("Margin", duvetCoversMarginField.getText() + ""));
        prodSpecs.add(new AbstractMap.SimpleEntry<String, String>("Taxes", duvetCoversTaxField.getText() + ""));
        prodSpecs.add(new AbstractMap.SimpleEntry<String, String>("Other Costs", duvetCoversOtherCostVal.getText() + ""));

        ArrayList<Map.Entry<String, String>> costDescs = new ArrayList<Map.Entry<String, String>>();
        costDescs.add(new AbstractMap.SimpleEntry<String, String>("Fabric Cost", dovetCoversFabricCost.getText() + ""));
        costDescs.add(new AbstractMap.SimpleEntry<String, String>("Thread Cost", dovetCoversThreadCost.getText() + ""));
        costDescs.add(new AbstractMap.SimpleEntry<String, String>("Lable Cost", dovetCoversLableCost.getText() + ""));
        costDescs.add(new AbstractMap.SimpleEntry<String, String>("Tag Cost", dovetCoversTagCost.getText() + ""));
        costDescs.add(new AbstractMap.SimpleEntry<String, String>("Cardboard Cost", dovetCoversCardBoardCost.getText() + ""));
        costDescs.add(new AbstractMap.SimpleEntry<String, String>("Seal Bag Cost", dovetCoversSealBagCost.getText() + ""));
        costDescs.add(new AbstractMap.SimpleEntry<String, String>("Button Cost", dovetCoversButtonCost.getText() + ""));
        costDescs.add(new AbstractMap.SimpleEntry<String, String>("Zipper Cost", dovetCoversZipperCost.getText() + ""));
        costDescs.add(new AbstractMap.SimpleEntry<String, String>("Velco Cost", dovetCoversVelcoCost.getText() + ""));
        costDescs.add(new AbstractMap.SimpleEntry<String, String>("Total Material Cost", dovetCoversTotalMaterialCost.getText() + ""));
        costDescs.add(new AbstractMap.SimpleEntry<String, String>("POH", dovetCoversPOH.getText() + ""));
        costDescs.add(new AbstractMap.SimpleEntry<String, String>("Labour Cost", dovetCoversLabourCost.getText() + ""));
        costDescs.add(new AbstractMap.SimpleEntry<String, String>("Total Cost Per Unit", dovetCoversToatalCost.getText() + ""));
        costDescs.add(new AbstractMap.SimpleEntry<String, String>("Net Selling Price", dovetCoversNetSellingPrice.getText() + ""));
        costDescs.add(new AbstractMap.SimpleEntry<String, String>("Taxes", dovetCoversTaxes.getText() + ""));
        costDescs.add(new AbstractMap.SimpleEntry<String, String>("Gross Selling Price", dovetCoversGrossSellingPrice.getText() + ""));

        ArrayList<Map.Entry<String, String>> manuSpecs = new ArrayList<Map.Entry<String, String>>();
        manuSpecs.add(new AbstractMap.SimpleEntry<String, String>("Cutting Width", dovetCoversCutWidth.getText() + ""));
        manuSpecs.add(new AbstractMap.SimpleEntry<String, String>("Cutting Height", dovetCoversCutHeight.getText() + ""));
        manuSpecs.add(new AbstractMap.SimpleEntry<String, String>("SMV Value", dovetCoversSMVValue.getText() + ""));


        try {
            int n = Integer.parseInt(quantity.getText());
            qObject.setQuantity(n);
            summaryObj.setQuantity(n);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity value");
            return;
        }


        ItemSummaryObject itemSumObj = new ItemSummaryObject("Duvet Cover", summaryObj, prodSpecs, costDescs, manuSpecs);
        MainWindow.quotation.addQuatationObject(qObject, itemSumObj);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                final AddOrderSuccess dialog = new AddOrderSuccess(new javax.swing.JFrame(), true);
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_duvetExportButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dovetCoverCustomFlap;
    private javax.swing.JLabel dovetCoversButtonCost;
    private javax.swing.JLabel dovetCoversCardBoardCost;
    private javax.swing.JLabel dovetCoversCustomFlapLable;
    private javax.swing.JTextField dovetCoversCustomHeight;
    private javax.swing.JPanel dovetCoversCustomPanel;
    private javax.swing.JTextField dovetCoversCustomWidth;
    private javax.swing.JLabel dovetCoversCutHeight;
    private javax.swing.JLabel dovetCoversCutWidth;
    private javax.swing.JLabel dovetCoversFabricCost;
    private javax.swing.JLabel dovetCoversGrossSellingPrice;
    private javax.swing.JRadioButton dovetCoversIncludeCardBoard;
    private javax.swing.JRadioButton dovetCoversIncludeLable;
    private javax.swing.JRadioButton dovetCoversIncludeSealBag;
    private javax.swing.JRadioButton dovetCoversIncludeTag;
    private javax.swing.JLabel dovetCoversLableCost;
    private javax.swing.JLabel dovetCoversLabourCost;
    private javax.swing.JComboBox dovetCoversMaterialTypeCombo;
    private javax.swing.JLabel dovetCoversNetSellingPrice;
    private javax.swing.JLabel dovetCoversPOH;
    private javax.swing.JComboBox dovetCoversProductRangeCombo;
    private javax.swing.JLabel dovetCoversSMVValue;
    private javax.swing.JLabel dovetCoversSealBagCost;
    private javax.swing.JComboBox dovetCoversSizeCombo;
    private javax.swing.JButton dovetCoversSubmitButton;
    private javax.swing.JLabel dovetCoversTagCost;
    private javax.swing.JLabel dovetCoversTaxes;
    private javax.swing.JLabel dovetCoversThreadCost;
    private javax.swing.JLabel dovetCoversToatalCost;
    private javax.swing.JLabel dovetCoversTotalMaterialCost;
    private javax.swing.JComboBox dovetCoversTypeCombo;
    private javax.swing.JRadioButton dovetCoversUseCustom;
    private javax.swing.JLabel dovetCoversVelcoCost;
    private javax.swing.JTextField dovetCoversWastage;
    private javax.swing.JLabel dovetCoversZipperCost;
    private javax.swing.JLabel duvetCoverSizeLable;
    private javax.swing.JPanel duvetCoversCostingPanel;
    private javax.swing.JTextField duvetCoversMarginField;
    private javax.swing.JTextField duvetCoversOtherCostVal;
    private javax.swing.JTextField duvetCoversTaxField;
    private javax.swing.JPanel duvetCversCPUPanel2;
    private javax.swing.JButton duvetExportButton;
    private javax.swing.JLabel jLabel297;
    private javax.swing.JLabel jLabel298;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel300;
    private javax.swing.JLabel jLabel301;
    private javax.swing.JLabel jLabel302;
    private javax.swing.JLabel jLabel331;
    private javax.swing.JLabel jLabel332;
    private javax.swing.JLabel jLabel333;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JTextField quantity;
    // End of variables declaration//GEN-END:variables

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new DuvetCoversCostingPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
