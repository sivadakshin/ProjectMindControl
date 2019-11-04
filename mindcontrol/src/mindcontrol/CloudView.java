/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindcontrol;

/**
 *
 * @author siva
 */
public class CloudView extends javax.swing.JFrame {

    /**
     * Creates new form CloudView
     */
    public CloudView() {
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

        title = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        configurebutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        title.setBackground(new java.awt.Color(60, 60, 60));
        title.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        title.setText("Select a cloud service");

        description.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        description.setText("Select a cloud service from the following");

        jComboBox1.setToolTipText("");

        configurebutton.setText("configure");
        configurebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configurebuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(configurebutton)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(configurebutton))
                .addContainerGap(173, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configurebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configurebuttonActionPerformed
       String cloudname=(String) jComboBox1.getItemAt(jComboBox1.getSelectedIndex());
      if(cloudname.equals("webhook"))
      {
          MindControl.cloud=new Webhook();
          MindControl.cloud.setCloudname("webhook");
      }
       setVisible(false);
           new Thread((new Runnable() {
        @Override
        public void run() {
       MindControl.cloud.setCloudconfig();
               }
      })).start();
    }//GEN-LAST:event_configurebuttonActionPerformed

    /**
     * @param args the command line arguments
     */
      public void setup() {                         
        // TODO add your handling code here:
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jComboBox1.addItem("webhook");
                //jComboBox1.addItem("ewelink");
                setVisible(true);
            }
        });
           //add cloud services here
          
          
       
    }  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton configurebutton;
    private javax.swing.JLabel description;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}