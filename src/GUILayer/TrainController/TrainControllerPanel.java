/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUILayer.TrainController;

import DataLayer.Train.TrainController.*;
import java.text.DecimalFormat;

/**
 *
 * @author domino54
 */
public class TrainControllerPanel extends javax.swing.JPanel {

    private TrainController controller; //TrainController that gui is boud to
    
    
    public TrainControllerPanel() 
    {
        initComponents();
        this.controller = null;
    }
    
    
    /* SetTrainCOntroller(TrainController c) sets the controller bound to the gui
     * Paramters:
     *     TrainController c - controller to bind to the gui
    */
    public void SetTrainController(TrainController c)
    {
        this.controller = c;
        this.UpdateTrainControllerGUI();
        this.controller.VelocitySetPoint = this.vSetPoint_slide.getValue()/1000;
        this.controller.DesiredTemperature = convertToCelcius(this.desiredTemp_slide.getValue());
    }
    
    /* UpdateTrainControllerGUI() updates all aspects of the gui
    */
    public void UpdateTrainControllerGUI()
    {
        //V Set Point
        int controllerVSet = (int)(this.controller.VelocitySetPoint * 1000);
        this.vSetPoint_slide.setValue(controllerVSet);
        double x = ConvertToMPH(controllerVSet);
        this.vSetPoint_status.setText("" + Double.parseDouble(new DecimalFormat("##.##").format(x)) + " mph");
        
        //Desired Temp
        this.desiredTemp_slide.setValue(convertToFarenheit(this.controller.DesiredTemperature));
        this.desiredTemp_status.setText("" + this.desiredTemp_slide.getValue() + " Degrees (F)");
        
        //E Brake
        this.setEBrakeGUI();
        
        //S Brake
        this.setSBrakeGUI();
        
        //Int. Lights
        this.setIntLightsGUI();
        
        //Ext. Lights
        this.setExtLightsGUI();
        
        //R Doors
        this.setRDoorsGUI();
        
        //L Doors
        this.setLDoorsGUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        vSetPoint_slide = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        desiredTemp_slide = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        eBrake_on = new javax.swing.JToggleButton();
        eBrake_off = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        sBrake_on = new javax.swing.JToggleButton();
        sBrake_off = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        extLights_on = new javax.swing.JToggleButton();
        extLights_off = new javax.swing.JToggleButton();
        intLights_off = new javax.swing.JToggleButton();
        intLights_on = new javax.swing.JToggleButton();
        lDoors_close = new javax.swing.JToggleButton();
        lDoors_open = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rDoors_open = new javax.swing.JToggleButton();
        rDoors_close = new javax.swing.JToggleButton();
        vSetPoint_status = new javax.swing.JLabel();
        desiredTemp_status = new javax.swing.JLabel();

        jLabel1.setText("V Set Point");

        vSetPoint_slide.setMaximum(19444);
        vSetPoint_slide.setValue(0);
        vSetPoint_slide.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                vSetPoint_Changed(evt);
            }
        });

        jLabel2.setText("Desired Temp");

        desiredTemp_slide.setMaximum(85);
        desiredTemp_slide.setMinimum(40);
        desiredTemp_slide.setValue(72);
        desiredTemp_slide.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                desiredTemp_Changed(evt);
            }
        });

        jLabel3.setText("E. Brake");

        eBrake_on.setText("Engage");
        eBrake_on.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                eBrake_Clicked(evt);
            }
        });

        eBrake_off.setText("Disengage");
        eBrake_off.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                eBrakeOff_Clicked(evt);
            }
        });

        jLabel4.setText("S. Brake");

        sBrake_on.setText("Engage");
        sBrake_on.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sBrake_Clicked(evt);
            }
        });

        sBrake_off.setText("Disengage");
        sBrake_off.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sBrakeOff_Clicked(evt);
            }
        });

        jLabel5.setText("Int. Lights");

        jLabel6.setText("Ext. Lights");

        extLights_on.setText("On");
        extLights_on.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                extLights_Clicked(evt);
            }
        });

        extLights_off.setText("Off");
        extLights_off.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                extLightsOff_Clicked(evt);
            }
        });

        intLights_off.setText("Off");
        intLights_off.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                intLightsOff_Clicked(evt);
            }
        });

        intLights_on.setText("On");
        intLights_on.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                intLights_Clicked(evt);
            }
        });

        lDoors_close.setText("Close");
        lDoors_close.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lDoorsClose_Clicked(evt);
            }
        });

        lDoors_open.setText("Open");
        lDoors_open.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lDoors_Clicked(evt);
            }
        });

        jLabel7.setText("L Doors");

        jLabel8.setText("R Doors");

        rDoors_open.setText("Open");
        rDoors_open.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rDoors_Clicked(evt);
            }
        });

        rDoors_close.setText("Close");
        rDoors_close.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rDoorsClose_Close(evt);
            }
        });

        vSetPoint_status.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        vSetPoint_status.setText("0 mph");

        desiredTemp_status.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        desiredTemp_status.setText("72 F");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(intLights_on)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(intLights_off))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vSetPoint_slide, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(desiredTemp_slide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vSetPoint_status))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(desiredTemp_status))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(extLights_on)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(extLights_off)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rDoors_open)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rDoors_close))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lDoors_open)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lDoors_close))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eBrake_on)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eBrake_off))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sBrake_on)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sBrake_off)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vSetPoint_slide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel1)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(desiredTemp_slide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(desiredTemp_status)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(vSetPoint_status)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(intLights_on)
                            .addComponent(intLights_off))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(extLights_on)
                            .addComponent(extLights_off)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(eBrake_on)
                            .addComponent(eBrake_off))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(sBrake_on)
                            .addComponent(sBrake_off))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(rDoors_open)
                            .addComponent(rDoors_close))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lDoors_open)
                            .addComponent(lDoors_close))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    /* ConvertToMPH(double x) converts meters/sec to mph
     * Paramters:
     *     double x - speed in meters/sec
     * Returns - double, speed in mph
    */
    public static double ConvertToMPH(double x)
    {
        double mps = x / 1000;
        return mps * 2.23694;
    }
    
    //Fired when the Velocity Setpoint slider is changed
    private void vSetPoint_Changed(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_vSetPoint_Changed
        // TODO add your handling code here:
        double mps = this.vSetPoint_slide.getValue();
        double x = ConvertToMPH(mps);
        this.vSetPoint_status.setText("" + Double.parseDouble(new DecimalFormat("##.##").format(x)) + " mph");
        this.controller.VelocitySetPoint = mps/1000;
    }//GEN-LAST:event_vSetPoint_Changed

    //Fired when the Desired Temperature slider is changed
    private void desiredTemp_Changed(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_desiredTemp_Changed
        // TODO add your handling code here:
        int degreesF = this.desiredTemp_slide.getValue();
        this.desiredTemp_status.setText("" + degreesF + " Degrees (F)");
        this.controller.DesiredTemperature = convertToCelcius(degreesF);
    }//GEN-LAST:event_desiredTemp_Changed

    //Fired when the E Brake Engage is Clicked
    private void eBrake_Clicked(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_eBrake_Clicked
        // TODO add your handling code here:
        boolean onDepressed = this.eBrake_on.isSelected();
        boolean offDepressed = this.eBrake_off.isSelected();
        
        if (onDepressed && offDepressed) //On is depressed
        {
            this.eBrake_off.setSelected(!offDepressed); //pop off button up
            this.controller.OperatorEBrake = TrainController.OperatorInputStatus.ON;
        }
        else if (!onDepressed && offDepressed) //off is selected
        {
            this.controller.OperatorEBrake = TrainController.OperatorInputStatus.OFF;
        }
        else if (onDepressed && !offDepressed) //on selected
        {
            this.controller.OperatorEBrake = TrainController.OperatorInputStatus.ON;
        }
        else if (!onDepressed && !offDepressed)
        {
            this.controller.OperatorEBrake = TrainController.OperatorInputStatus.AUTO;
        }
    }//GEN-LAST:event_eBrake_Clicked

    //Fired when the E Brake Disengage is clicked
    private void eBrakeOff_Clicked(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_eBrakeOff_Clicked
        // TODO add your handling code here:
        boolean onDepressed = this.eBrake_on.isSelected();
        boolean offDepressed = this.eBrake_off.isSelected();
        
        if (onDepressed && offDepressed) //Of and on is depressed
        {
            this.eBrake_on.setSelected(!onDepressed); //pop off button up
            this.controller.OperatorEBrake = TrainController.OperatorInputStatus.OFF;
        }
        else if (!onDepressed && offDepressed) //off is selected
        {
            this.controller.OperatorEBrake = TrainController.OperatorInputStatus.OFF;
        }
        else if (onDepressed && !offDepressed) //on selected
        {
            this.controller.OperatorEBrake = TrainController.OperatorInputStatus.ON;
        }
        else if (!onDepressed && !offDepressed)
        {
            this.controller.OperatorEBrake = TrainController.OperatorInputStatus.AUTO;
        }
    }//GEN-LAST:event_eBrakeOff_Clicked

    //Fired when the S Brake Engage is clicked
    private void sBrake_Clicked(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sBrake_Clicked
        // TODO add your handling code here:
        boolean onDepressed = this.sBrake_on.isSelected();
        boolean offDepressed = this.sBrake_off.isSelected();
        
        if (onDepressed) //On is depressed
        {
            this.controller.OperatorSBrake = TrainController.OperatorInputStatus.ON;
            if (offDepressed) //off is also depressed
            {
                this.sBrake_off.setSelected(false); //pop off button up
            }
        }
        else if (!onDepressed && offDepressed) //off is selected
        {
            this.controller.OperatorSBrake = TrainController.OperatorInputStatus.OFF;
        }
        else //nothing is selected
        {
            this.controller.OperatorSBrake = TrainController.OperatorInputStatus.AUTO;
        }
    }//GEN-LAST:event_sBrake_Clicked

    //Fired when teh S Brake Disengage is clicked
    private void sBrakeOff_Clicked(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sBrakeOff_Clicked
        // TODO add your handling code here:
        boolean onDepressed = this.sBrake_on.isSelected();
        boolean offDepressed = this.sBrake_off.isSelected();
        
        if (offDepressed) //Off is depressed
        {
            this.controller.OperatorSBrake = TrainController.OperatorInputStatus.OFF;
            if (onDepressed) //on is also depressed
            {
                this.sBrake_on.setSelected(false); //pop on button up
            }
        }
        else if (!offDepressed && onDepressed) //on is selected
        {
            this.controller.OperatorSBrake = TrainController.OperatorInputStatus.ON;
        }
        else //nothing is selected
        {
            this.controller.OperatorSBrake = TrainController.OperatorInputStatus.AUTO;
        }
    }//GEN-LAST:event_sBrakeOff_Clicked

    //Fired when the Interior Lights on is clicked
    private void intLights_Clicked(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_intLights_Clicked
        // TODO add your handling code here:
        boolean onDepressed = this.intLights_on.isSelected();
        boolean offDepressed = this.intLights_off.isSelected();
        
        if (onDepressed) //On is depressed
        {
            this.controller.OperatorIntLights = TrainController.OperatorInputStatus.ON;
            if (offDepressed) //off is also depressed
            {
                this.intLights_off.setSelected(false); //pop off button up
            }
        }
        else if (!onDepressed && offDepressed) //off is selected
        {
            this.controller.OperatorIntLights = TrainController.OperatorInputStatus.OFF;
        }
        else //nothing is selected
        {
            this.controller.OperatorIntLights = TrainController.OperatorInputStatus.AUTO;
        }
    }//GEN-LAST:event_intLights_Clicked

    //Fired when the Interior Lights off is clicked
    private void intLightsOff_Clicked(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_intLightsOff_Clicked
        // TODO add your handling code here:
        boolean onDepressed = this.intLights_on.isSelected();
        boolean offDepressed = this.intLights_off.isSelected();
        
        if (offDepressed) //Off is depressed
        {
            this.controller.OperatorIntLights = TrainController.OperatorInputStatus.OFF;
            if (onDepressed) //on is also depressed
            {
                this.intLights_on.setSelected(false); //pop on button up
            }
        }
        else if (!offDepressed && onDepressed) //on is selected
        {
            this.controller.OperatorIntLights = TrainController.OperatorInputStatus.ON;
        }
        else //nothing is selected
        {
            this.controller.OperatorIntLights = TrainController.OperatorInputStatus.AUTO;
        }
    }//GEN-LAST:event_intLightsOff_Clicked

    //Fired when the Exterior Lights on is clicked
    private void extLights_Clicked(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_extLights_Clicked
        // TODO add your handling code here:
        boolean onDepressed = this.extLights_on.isSelected();
        boolean offDepressed = this.extLights_off.isSelected();
        
        if (onDepressed) //On is depressed
        {
            this.controller.OperatorExtLights = TrainController.OperatorInputStatus.ON;
            if (offDepressed) //off is also depressed
            {
                this.extLights_off.setSelected(false); //pop off button up
            }
        }
        else if (!onDepressed && offDepressed) //off is selected
        {
            this.controller.OperatorExtLights = TrainController.OperatorInputStatus.OFF;
        }
        else //nothing is selected
        {
            this.controller.OperatorExtLights = TrainController.OperatorInputStatus.AUTO;
        }
    }//GEN-LAST:event_extLights_Clicked

    //Fired when the Exterior Lights off is clicked
    private void extLightsOff_Clicked(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_extLightsOff_Clicked
        // TODO add your handling code here:
        boolean onDepressed = this.extLights_on.isSelected();
        boolean offDepressed = this.extLights_off.isSelected();
        
        if (offDepressed) //Off is depressed
        {
            this.controller.OperatorExtLights = TrainController.OperatorInputStatus.OFF;
            if (onDepressed) //on is also depressed
            {
                this.extLights_on.setSelected(false); //pop on button up
            }
        }
        else if (!offDepressed && onDepressed) //on is selected
        {
            this.controller.OperatorExtLights = TrainController.OperatorInputStatus.ON;
        }
        else //nothing is selected
        {
            this.controller.OperatorExtLights = TrainController.OperatorInputStatus.AUTO;
        }
    }//GEN-LAST:event_extLightsOff_Clicked

    //Fired when the Left Doors open is clicked
    private void lDoors_Clicked(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_lDoors_Clicked
        // TODO add your handling code here:
        boolean onDepressed = this.lDoors_open.isSelected();
        boolean offDepressed = this.lDoors_close.isSelected();
        
        if (onDepressed) //On is depressed
        {
            this.controller.OperatorLeftDoor = TrainController.OperatorInputStatus.ON;
            if (offDepressed) //off is also depressed
            {
                this.lDoors_close.setSelected(false); //pop off button up
            }
        }
        else if (!onDepressed && offDepressed) //off is selected
        {
            this.controller.OperatorLeftDoor = TrainController.OperatorInputStatus.OFF;
        }
        else //nothing is selected
        {
            this.controller.OperatorLeftDoor = TrainController.OperatorInputStatus.AUTO;
        }
    }//GEN-LAST:event_lDoors_Clicked

    //Fired when the Left Doors close is clicked
    private void lDoorsClose_Clicked(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_lDoorsClose_Clicked
        // TODO add your handling code here:
        boolean onDepressed = this.lDoors_open.isSelected();
        boolean offDepressed = this.lDoors_close.isSelected();
        
        if (offDepressed) //Off is depressed
        {
            this.controller.OperatorLeftDoor = TrainController.OperatorInputStatus.OFF;
            if (onDepressed) //on is also depressed
            {
                this.lDoors_open.setSelected(false); //pop on button up
            }
        }
        else if (!offDepressed && onDepressed) //on is selected
        {
            this.controller.OperatorLeftDoor = TrainController.OperatorInputStatus.ON;
        }
        else //nothing is selected
        {
            this.controller.OperatorLeftDoor = TrainController.OperatorInputStatus.AUTO;
        }
    }//GEN-LAST:event_lDoorsClose_Clicked

    //Fired when the Right Doors open is clicked
    private void rDoors_Clicked(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rDoors_Clicked
        // TODO add your handling code here:
        boolean onDepressed = this.rDoors_open.isSelected();
        boolean offDepressed = this.rDoors_close.isSelected();
        
        if (onDepressed) //On is depressed
        {
            this.controller.OperatorRightDoor = TrainController.OperatorInputStatus.ON;
            if (offDepressed) //off is also depressed
            {
                this.rDoors_close.setSelected(false); //pop off button up
            }
        }
        else if (!onDepressed && offDepressed) //off is selected
        {
            this.controller.OperatorRightDoor = TrainController.OperatorInputStatus.OFF;
        }
        else //nothing is selected
        {
            this.controller.OperatorRightDoor = TrainController.OperatorInputStatus.AUTO;
        }
    }//GEN-LAST:event_rDoors_Clicked

    //FIred when the Right Doors close is clicked
    private void rDoorsClose_Close(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rDoorsClose_Close
        // TODO add your handling code here:
        boolean onDepressed = this.rDoors_open.isSelected();
        boolean offDepressed = this.rDoors_close.isSelected();
        
        if (offDepressed) //Off is depressed
        {
            this.controller.OperatorRightDoor = TrainController.OperatorInputStatus.OFF;
            if (onDepressed) //on is also depressed
            {
                this.rDoors_open.setSelected(false); //pop on button up
            }
        }
        else if (!offDepressed && onDepressed) //on is selected
        {
            this.controller.OperatorRightDoor = TrainController.OperatorInputStatus.ON;
        }
        else //nothing is selected
        {
            this.controller.OperatorRightDoor = TrainController.OperatorInputStatus.AUTO;
        }
    }//GEN-LAST:event_rDoorsClose_Close


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider desiredTemp_slide;
    private javax.swing.JLabel desiredTemp_status;
    private javax.swing.JToggleButton eBrake_off;
    private javax.swing.JToggleButton eBrake_on;
    private javax.swing.JToggleButton extLights_off;
    private javax.swing.JToggleButton extLights_on;
    private javax.swing.JToggleButton intLights_off;
    private javax.swing.JToggleButton intLights_on;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JToggleButton lDoors_close;
    private javax.swing.JToggleButton lDoors_open;
    private javax.swing.JToggleButton rDoors_close;
    private javax.swing.JToggleButton rDoors_open;
    private javax.swing.JToggleButton sBrake_off;
    private javax.swing.JToggleButton sBrake_on;
    private javax.swing.JSlider vSetPoint_slide;
    private javax.swing.JLabel vSetPoint_status;
    // End of variables declaration//GEN-END:variables
    
    /* convertToCelcius(int f) converts farenheit to celcius
     * Parameters:
     *     int f - temp in farenheit
     * Returns - double, temp in celcius
    */
    private double convertToCelcius(int f)
    {
        double x = (((f - 32) * 5) / 9);
        return x;
    }
    
    /* converToFarenheit(double c) converts celcius to farenheit
     * Parameters:
     *     double c - temp in celcius
     * Returns - int, temp in farenheit
    */
    private int convertToFarenheit(double c)
    {
        int x = (int)(((c * 9) / 5) + 32);
        return x;
    }
    
    //setEBrakeGUI() sets the E brake buttons based on the controller
    private void setEBrakeGUI()
    {
        if (this.controller.OperatorEBrake == TrainController.OperatorInputStatus.ON) //ON
        {
            this.eBrake_on.setSelected(true);
            this.eBrake_off.setSelected(false);
        }
        else if (this.controller.OperatorEBrake == TrainController.OperatorInputStatus.OFF) //OFF
        {
            this.eBrake_on.setSelected(false);
            this.eBrake_off.setSelected(true);
        }
        else //AUTO
        {
            this.eBrake_on.setSelected(false);
            this.eBrake_off.setSelected(false);
        }
    }
    
    //setExtLightsGUI() sets the Exterior lights buttons based on the controller
    private void setExtLightsGUI()
    {
        if (this.controller.OperatorExtLights == TrainController.OperatorInputStatus.ON) //ON
        {
            this.extLights_on.setSelected(true);
            this.extLights_off.setSelected(false);
        }
        else if (this.controller.OperatorExtLights == TrainController.OperatorInputStatus.OFF) //OFF
        {
            this.extLights_on.setSelected(false);
            this.extLights_off.setSelected(true);
        }
        else //AUTO
        {
            this.extLights_on.setSelected(false);
            this.extLights_off.setSelected(false);
        }
    }
    
    //setIntLightsGUI() sets the Interior lights buttons based on the controller
    private void setIntLightsGUI() 
    {
        if (this.controller.OperatorIntLights == TrainController.OperatorInputStatus.ON) //ON
        {
            this.intLights_on.setSelected(true);
            this.intLights_off.setSelected(false);
        }
        else if (this.controller.OperatorIntLights == TrainController.OperatorInputStatus.OFF) //OFF
        {
            this.intLights_on.setSelected(false);
            this.intLights_off.setSelected(true);
        }
        else //AUTO
        {
            this.intLights_on.setSelected(false);
            this.intLights_off.setSelected(false);
        }
    }
    
    //setLDoorsGUI() sets the Left Doors buttons based on the controller
    private void setLDoorsGUI()
    {
        if (this.controller.OperatorLeftDoor == TrainController.OperatorInputStatus.ON) //ON
        {
            this.lDoors_open.setSelected(true);
            this.lDoors_close.setSelected(false);
            
        }
        else if (this.controller.OperatorLeftDoor == TrainController.OperatorInputStatus.OFF) //OFF
        {
            this.lDoors_open.setSelected(false);
            this.lDoors_close.setSelected(true);
        }
        else //AUTO
        {
            this.lDoors_open.setSelected(false);
            this.lDoors_close.setSelected(false);
        }
    }
    
    //setRDoorsGUI() sets the Right Doors buttons based on the controller
    private void setRDoorsGUI()
    {
        if (this.controller.OperatorRightDoor == TrainController.OperatorInputStatus.ON) //ON
        {
            this.rDoors_open.setSelected(true);
            this.rDoors_close.setSelected(false);
            
        }
        else if (this.controller.OperatorRightDoor == TrainController.OperatorInputStatus.OFF) //OFF
        {
            this.rDoors_open.setSelected(false);
            this.rDoors_close.setSelected(true);
        }
        else //AUTO
        {
            this.rDoors_open.setSelected(false);
            this.rDoors_close.setSelected(false);
        }
    }
    
    //setSBrakeGUI() sets the S brake buttons based on the controller
    private void setSBrakeGUI()
    {
        if (this.controller.OperatorSBrake == TrainController.OperatorInputStatus.ON) //ON
        {
            this.sBrake_on.setSelected(true);
            this.sBrake_off.setSelected(false);
        }
        else if (this.controller.OperatorSBrake == TrainController.OperatorInputStatus.OFF) //OFF
        {
            this.sBrake_on.setSelected(false);
            this.sBrake_off.setSelected(true);
        }
        else //AUTO
        {
            this.sBrake_on.setSelected(false);
            this.sBrake_off.setSelected(false);
        }
    }
}
