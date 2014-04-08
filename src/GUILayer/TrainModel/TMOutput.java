/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUILayer.TrainModel;

/**
 *
 * @author drewwinfield
 */
public class TMOutput extends javax.swing.JPanel {

    /**
     * Creates new form StateDisplay
     */
    public TMOutput() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outputsLabel = new javax.swing.JLabel();
        velocityOutputLabel = new javax.swing.JLabel();
        rightDoorOutputLabel = new javax.swing.JLabel();
        eBrakeOutputLabel = new javax.swing.JLabel();
        sBrakeOutputLabel = new javax.swing.JLabel();
        exteriorLightsOutputLabel = new javax.swing.JLabel();
        leftDoorOutputLabel = new javax.swing.JLabel();
        interiorLightsOutputLabel = new javax.swing.JLabel();
        mphLabel = new javax.swing.JLabel();
        sBrakeDisplayBox = new javax.swing.JTextField();
        eBrakeDisplayBox = new javax.swing.JTextField();
        rightDoorDisplayBox = new javax.swing.JTextField();
        leftDoorDisplayBox = new javax.swing.JTextField();
        intLightsDisplayBox = new javax.swing.JTextField();
        extLightsDIsplayBox = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();

        outputsLabel.setText("Outputs");

        velocityOutputLabel.setText("Velocity");

        rightDoorOutputLabel.setText("Door open/close (Right side) \u0000");

        eBrakeOutputLabel.setText("Emergency Brake");

        sBrakeOutputLabel.setText("Service Brake");

        exteriorLightsOutputLabel.setText("Lights on/off (Exterior) \u0000");

        leftDoorOutputLabel.setText("Door open/close (Left side) \u0000");

        interiorLightsOutputLabel.setText("Lights on/off (Interior) \u0000");

        mphLabel.setText("mph");

        sBrakeDisplayBox.setText("Off");

        eBrakeDisplayBox.setText("Off");

        rightDoorDisplayBox.setText("Closed");

        leftDoorDisplayBox.setText("Closed");

        intLightsDisplayBox.setText("Off");

        extLightsDIsplayBox.setText("Off");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(outputsLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(velocityOutputLabel)
                        .addComponent(interiorLightsOutputLabel)
                        .addComponent(leftDoorOutputLabel)
                        .addComponent(rightDoorOutputLabel)
                        .addComponent(exteriorLightsOutputLabel)
                        .addComponent(sBrakeOutputLabel)
                        .addComponent(eBrakeOutputLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mphLabel))
                    .addComponent(sBrakeDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eBrakeDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightDoorDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leftDoorDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(intLightsDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(extLightsDIsplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outputsLabel)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(velocityOutputLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mphLabel)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sBrakeOutputLabel)
                    .addComponent(sBrakeDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eBrakeOutputLabel)
                    .addComponent(eBrakeDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rightDoorOutputLabel)
                    .addComponent(rightDoorDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leftDoorOutputLabel)
                    .addComponent(leftDoorDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interiorLightsOutputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(intLightsDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exteriorLightsOutputLabel)
                    .addComponent(extLightsDIsplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField eBrakeDisplayBox;
    private javax.swing.JLabel eBrakeOutputLabel;
    private javax.swing.JTextField extLightsDIsplayBox;
    private javax.swing.JLabel exteriorLightsOutputLabel;
    private javax.swing.JTextField intLightsDisplayBox;
    private javax.swing.JLabel interiorLightsOutputLabel;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField leftDoorDisplayBox;
    private javax.swing.JLabel leftDoorOutputLabel;
    private javax.swing.JLabel mphLabel;
    private javax.swing.JLabel outputsLabel;
    private javax.swing.JTextField rightDoorDisplayBox;
    private javax.swing.JLabel rightDoorOutputLabel;
    private javax.swing.JTextField sBrakeDisplayBox;
    private javax.swing.JLabel sBrakeOutputLabel;
    private javax.swing.JLabel velocityOutputLabel;
    // End of variables declaration//GEN-END:variables
}
