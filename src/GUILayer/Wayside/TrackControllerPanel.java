/******************************************************************************
 * 
 * TrackControllerPanel class
 * 
 * Developed by AJility
 * April 2014
 * 
 * Contributers:
 *  Nathan Hachten
 * 
 * DISCLAIMER:
 *   This document contains un-editable code generated by NetBeans.  Due to this
 *  un-editable code, this document does not follow the AJility coding standard.
 *
 *****************************************************************************/

package GUILayer.Wayside;

import DataLayer.TrackModel.Switch;
import DataLayer.Wayside.TrackController;
import java.util.ArrayList;

public class TrackControllerPanel extends javax.swing.JPanel {
    TrackController controller;
    /**
     * Creates new form TrackControllerPanel
     */
    public TrackControllerPanel() {
        initComponents();
    }
    
    public void SetController(TrackController controller)
    {
        this.controller = controller;
        refreshComponents();
    }
    
    private void refreshComponents()
    {
         ArrayList<Switch> switches = this.controller.getSwitchInfo();
         String[] s = new String[switches.size()];
         String straightDesc; 
         String divergentDesc; 
         int i = 0;
         for (Switch sw : switches)
         {
             s[i++] = "Switch " + (sw.switchID-1);
             
         }
         switchComboBox.setModel(new javax.swing.DefaultComboBoxModel(s));
         this.switchLabelOne.setText(s[0]);
         this.switchLabelTwo.setText(s[1]);
         
         updateSwitchSelectText();
         updateSwitchStatus();
         
         

    }
    
    private void updateSwitchSelectText()
    {
        ArrayList<Switch> switches = this.controller.getSwitchInfo();

        int n = this.switchComboBox.getSelectedIndex();
        
        Switch sw = switches.get(n);
        this.straightRB.setText(sw.approachBlock + " to " + sw.straightBlock);
        this.divergentRB.setText(sw.approachBlock + " to " + sw.divergentBlock);
             
        
    }

    private void updateSwitchStatus()
    {
        ArrayList<Switch> switches = this.controller.getSwitchInfo();
        Switch sw1 = switches.get(0);
        Switch sw2 = switches.get(1);
        String statusOne, statusTwo;
        
        if (sw1.straight)
        {
            statusOne = sw1.approachBlock + ":" + sw1.straightBlock;
        }
        else
        {
            statusOne = sw1.approachBlock + ":" + sw1.divergentBlock;
        }
        
        if (sw2.straight)
        {
            statusTwo = sw2.approachBlock + ":" + sw2.straightBlock;
        }
        else
        {
            statusTwo = sw2.approachBlock + ":" + sw2.divergentBlock;
        }
        
        this.switchStatusOne.setText(statusOne);
        this.switchStatusTwo.setText(statusTwo);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        switchButtonGroup = new javax.swing.ButtonGroup();
        lightButtonGroup = new javax.swing.ButtonGroup();
        crossingButtonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        switchComboBox = new javax.swing.JComboBox();
        straightRB = new javax.swing.JRadioButton();
        divergentRB = new javax.swing.JRadioButton();
        setSwitchButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lightComboBox = new javax.swing.JComboBox();
        greenRB = new javax.swing.JRadioButton();
        yellowRB = new javax.swing.JRadioButton();
        redRB = new javax.swing.JRadioButton();
        setLightButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        crossingComboBox = new javax.swing.JComboBox();
        activeRB = new javax.swing.JRadioButton();
        inactiveRB = new javax.swing.JRadioButton();
        setCrossingButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        switchLabelOne = new javax.swing.JLabel();
        switchStatusOne = new javax.swing.JLabel();
        switchLabelTwo = new javax.swing.JLabel();
        switchStatusTwo = new javax.swing.JLabel();
        updateStatusButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(360, 200));

        jLabel1.setText("Track Controller Manual Overrides");

        jLabel2.setText("Switch Select");

        switchComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        switchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchComboBoxActionPerformed(evt);
            }
        });

        switchButtonGroup.add(straightRB);
        straightRB.setText("jRadioButton1");

        switchButtonGroup.add(divergentRB);
        divergentRB.setText("jRadioButton2");

        setSwitchButton.setText("Set");
        setSwitchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setSwitchButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Light Select");

        lightComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lightButtonGroup.add(greenRB);
        greenRB.setText("Green");

        lightButtonGroup.add(yellowRB);
        yellowRB.setText("Yellow");

        lightButtonGroup.add(redRB);
        redRB.setText("Red");

        setLightButton.setText("Set");

        jLabel4.setText("Crossing Select");

        crossingComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        crossingButtonGroup.add(activeRB);
        activeRB.setText("Active");

        crossingButtonGroup.add(inactiveRB);
        inactiveRB.setText("Inactive");

        setCrossingButton.setText("Set");

        jLabel5.setText("Switch Status");

        switchLabelOne.setText("jLabel6");

        switchStatusOne.setText("jLabel7");

        switchLabelTwo.setText("jLabel8");

        switchStatusTwo.setText("jLabel9");

        updateStatusButton.setText("Update");
        updateStatusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStatusButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(switchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(straightRB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(divergentRB))
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lightComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(greenRB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(yellowRB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(redRB))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(crossingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(activeRB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inactiveRB)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(setLightButton)
                                    .addComponent(setCrossingButton)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(setSwitchButton)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(switchLabelOne)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(switchStatusOne)
                                                .addGap(35, 35, 35)
                                                .addComponent(switchLabelTwo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(switchStatusTwo))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(updateStatusButton))))))
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)))
                    .addComponent(updateStatusButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(switchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(straightRB)
                    .addComponent(divergentRB)
                    .addComponent(setSwitchButton)
                    .addComponent(switchLabelOne)
                    .addComponent(switchStatusOne)
                    .addComponent(switchLabelTwo)
                    .addComponent(switchStatusTwo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lightComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(greenRB)
                        .addComponent(yellowRB)
                        .addComponent(redRB)
                        .addComponent(setLightButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crossingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activeRB)
                    .addComponent(inactiveRB)
                    .addComponent(setCrossingButton))
                .addContainerGap(9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setSwitchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setSwitchButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<Switch> switches = this.controller.getSwitchInfo();
        Switch switchCommand = null;
        Switch selectedSwitch;
        boolean dir;
        selectedSwitch = switches.get(this.switchComboBox.getSelectedIndex());
        
        if (this.straightRB.isSelected())
        {
            dir = true;
        }
        else
        {
            dir = false;
        }
        
        switchCommand = new Switch(selectedSwitch.lineID, selectedSwitch.switchID, selectedSwitch.approachBlock, 
                selectedSwitch.straightBlock, selectedSwitch.divergentBlock, dir);
        
        this.controller.sendSwitchStateSignal(switchCommand);
        //this.updateSwitchStatus();
        
    }//GEN-LAST:event_setSwitchButtonActionPerformed

    private void switchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchComboBoxActionPerformed
        // TODO add your handling code here:
        this.updateSwitchSelectText();
    }//GEN-LAST:event_switchComboBoxActionPerformed

    private void updateStatusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStatusButtonActionPerformed
        // TODO add your handling code here:
        this.updateSwitchStatus();
    }//GEN-LAST:event_updateStatusButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton activeRB;
    private javax.swing.ButtonGroup crossingButtonGroup;
    private javax.swing.JComboBox crossingComboBox;
    private javax.swing.JRadioButton divergentRB;
    private javax.swing.JRadioButton greenRB;
    private javax.swing.JRadioButton inactiveRB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.ButtonGroup lightButtonGroup;
    private javax.swing.JComboBox lightComboBox;
    private javax.swing.JRadioButton redRB;
    private javax.swing.JButton setCrossingButton;
    private javax.swing.JButton setLightButton;
    private javax.swing.JButton setSwitchButton;
    private javax.swing.JRadioButton straightRB;
    private javax.swing.ButtonGroup switchButtonGroup;
    private javax.swing.JComboBox switchComboBox;
    private javax.swing.JLabel switchLabelOne;
    private javax.swing.JLabel switchLabelTwo;
    private javax.swing.JLabel switchStatusOne;
    private javax.swing.JLabel switchStatusTwo;
    private javax.swing.JButton updateStatusButton;
    private javax.swing.JRadioButton yellowRB;
    // End of variables declaration//GEN-END:variables
}
