/******************************************************************************
 * 
 * TrainModelPanel class
 * 
 * Developed by AJility
 * April 2014
 * 
 * Contributers:
 *  Stephen Ruzzini
 *  Drew Winfield
 *
 *****************************************************************************/

package GUILayer.TrainModel;
import DataLayer.Train.TrainModel.*;


public class TrainModelPanel extends javax.swing.JPanel {

    private TrainModel model; //TrainModel to be bound to the gui
    
    public TrainModelPanel() 
    {
        initComponents();
    }

    
    /* SetTrainModel(TrainModel m) sets the TrainModel to be bound to the gui
     * Parameters:
     *     TrainModel m - TrainModel to be bound to the gui
    */
    public void SetTrainModel(TrainModel m)
    {
        model = m;
        tMOutput.setTrainState(m.state);
        tMOutput.setPhysicsEngine(m.physics);
        tMInput.setTrainState(m.state);
        tMInput.setPhysicsEngine(m.physics);
    }
    
    //Update() updates the different parts of the gui
    public void Update()
    {
        tMOutput.update();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tMInput = new GUILayer.TrainModel.TMInput();
        tMOutput = new GUILayer.TrainModel.TMOutput();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tMInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tMOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tMOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tMInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUILayer.TrainModel.TMInput tMInput;
    private GUILayer.TrainModel.TMOutput tMOutput;
    // End of variables declaration//GEN-END:variables
}
