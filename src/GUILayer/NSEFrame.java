/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUILayer;
import DataLayer.*;

/**
 *
 * @author domino54
 */
public class NSEFrame extends javax.swing.JFrame {

    public NSE NSEObject;
    /**
     * Creates new form NSEFrame
     */
    public NSEFrame() {
        initComponents();
        this.NSEObject = new NSE(1, 10); //create new NSE object with 10 trains
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        speed_group = new javax.swing.ButtonGroup();
        wallClock_Radio = new javax.swing.JRadioButton();
        wallClock10_Radio = new javax.swing.JRadioButton();
        start_button = new javax.swing.JToggleButton();
        pause_button = new javax.swing.JButton();
        reset_button = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        CTC_panel = new javax.swing.JPanel();
        Waysides_panel = new javax.swing.JPanel();
        TrackModel_panel = new javax.swing.JPanel();
        Trains_panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        speed_group.add(wallClock_Radio);
        wallClock_Radio.setText("Wall Clock");

        speed_group.add(wallClock10_Radio);
        wallClock10_Radio.setText("10x Wall Clock");

        start_button.setText("Start");

        pause_button.setText("Pause");

        reset_button.setText("Reset");

        javax.swing.GroupLayout CTC_panelLayout = new javax.swing.GroupLayout(CTC_panel);
        CTC_panel.setLayout(CTC_panelLayout);
        CTC_panelLayout.setHorizontalGroup(
            CTC_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 921, Short.MAX_VALUE)
        );
        CTC_panelLayout.setVerticalGroup(
            CTC_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("CTC", CTC_panel);

        javax.swing.GroupLayout Waysides_panelLayout = new javax.swing.GroupLayout(Waysides_panel);
        Waysides_panel.setLayout(Waysides_panelLayout);
        Waysides_panelLayout.setHorizontalGroup(
            Waysides_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 921, Short.MAX_VALUE)
        );
        Waysides_panelLayout.setVerticalGroup(
            Waysides_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Waysides", Waysides_panel);

        javax.swing.GroupLayout TrackModel_panelLayout = new javax.swing.GroupLayout(TrackModel_panel);
        TrackModel_panel.setLayout(TrackModel_panelLayout);
        TrackModel_panelLayout.setHorizontalGroup(
            TrackModel_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 921, Short.MAX_VALUE)
        );
        TrackModel_panelLayout.setVerticalGroup(
            TrackModel_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Track Model", TrackModel_panel);

        javax.swing.GroupLayout Trains_panelLayout = new javax.swing.GroupLayout(Trains_panel);
        Trains_panel.setLayout(Trains_panelLayout);
        Trains_panelLayout.setHorizontalGroup(
            Trains_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 921, Short.MAX_VALUE)
        );
        Trains_panelLayout.setVerticalGroup(
            Trains_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Trains", Trains_panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(wallClock_Radio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wallClock10_Radio)
                        .addGap(18, 18, 18)
                        .addComponent(start_button)
                        .addGap(18, 18, 18)
                        .addComponent(pause_button)
                        .addGap(18, 18, 18)
                        .addComponent(reset_button)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wallClock_Radio)
                    .addComponent(wallClock10_Radio)
                    .addComponent(start_button)
                    .addComponent(pause_button)
                    .addComponent(reset_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel 
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NSEFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NSEFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NSEFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NSEFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        */

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NSEFrame().setVisible(true);
            }
        });*/
        
        NSE nse = new NSE(1, 10);
        nse.RunAutomatic();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CTC_panel;
    private javax.swing.JPanel TrackModel_panel;
    private javax.swing.JPanel Trains_panel;
    private javax.swing.JPanel Waysides_panel;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton pause_button;
    private javax.swing.JButton reset_button;
    private javax.swing.ButtonGroup speed_group;
    private javax.swing.JToggleButton start_button;
    private javax.swing.JRadioButton wallClock10_Radio;
    private javax.swing.JRadioButton wallClock_Radio;
    // End of variables declaration//GEN-END:variables
}
