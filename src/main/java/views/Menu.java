package views;
import controllers.MenuController;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import routes.Router;


public class Menu extends javax.swing.JFrame {


    
    public Menu(MenuController controller) {
        initComponents();
        this.controller = controller;
        initList();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logResults = new java.awt.Button();
        addMember = new java.awt.Button();
        topLabel = new java.awt.Label();
        userList = new java.awt.List();
        addMember1 = new java.awt.Button();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logResults.setBackground(new java.awt.Color(51, 153, 255));
        logResults.setForeground(new java.awt.Color(255, 255, 255));
        logResults.setLabel("Print Results");
        logResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onLogResultClick(evt);
            }
        });
        logResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logResultsActionPerformed(evt);
            }
        });

        addMember.setBackground(new java.awt.Color(51, 153, 255));
        addMember.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addMember.setForeground(new java.awt.Color(255, 255, 255));
        addMember.setLabel("Add Member");
        addMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onAddMemberClick(evt);
            }
        });
        addMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberActionPerformed(evt);
            }
        });

        topLabel.setText("Fishing camp");

        userList.setBackground(new java.awt.Color(255, 255, 102));
        userList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userListActionPerformed(evt);
            }
        });

        addMember1.setBackground(new java.awt.Color(51, 153, 255));
        addMember1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addMember1.setForeground(new java.awt.Color(255, 255, 255));
        addMember1.setLabel("Start Event");
        addMember1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onStartEventClick(evt);
            }
        });
        addMember1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMember1ActionPerformed(evt);
            }
        });

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(topLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userList, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logResults, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(addMember1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(topLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userList, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(addMember1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(addMember, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logResults, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );

        addMember1.getAccessibleContext().setAccessibleName("startEvent");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void onAddMemberClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onAddMemberClick
            Router.createInputWindow();
    }//GEN-LAST:event_onAddMemberClick
 
    private void initList(){
        this.controller.getAllFishers().forEach(e->{
            userList.add(e.getName());
        });
    }
    
    
    private void onLogResultClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onLogResultClick
        // TODO add your handling code here:
    }//GEN-LAST:event_onLogResultClick

    private void onStartEventClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onStartEventClick
        addMember1.setForeground(Color.ORANGE);
        this.controller.startGame();
        addMember1.setForeground(Color.WHITE);
    }//GEN-LAST:event_onStartEventClick

    private void userListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userListActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        userList.removeAll();
        initList();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addMemberActionPerformed

    private void addMember1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMember1ActionPerformed
          
    }//GEN-LAST:event_addMember1ActionPerformed

    private void logResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logResultsActionPerformed
        Router.createLogger();
    }//GEN-LAST:event_logResultsActionPerformed

   
    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(() -> {
            try {
                Router.createMainWindow();
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button addMember;
    private java.awt.Button addMember1;
    private javax.swing.JButton jButton1;
    private java.awt.Button logResults;
    private java.awt.Label topLabel;
    private java.awt.List userList;
    // End of variables declaration//GEN-END:variables
    private MenuController controller;
}

