/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author priva_000
 */
public class FooterNavigationPanel extends javax.swing.JPanel {

    /**
     * Creates new form FooterNavigationPanel
     */
    public FooterNavigationPanel() {
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

        btnLogin = new javax.swing.JButton();
        btnHighscore = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(1, 0));

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        add(btnLogin);

        btnHighscore.setText("Highscore");
        btnHighscore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHighscoreActionPerformed(evt);
            }
        });
        add(btnHighscore);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        AppState.getInstance().setState(AppStates.AUTHENTICATE);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnHighscoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHighscoreActionPerformed
        AppState.getInstance().setState(AppStates.HIGHSCORE);
    }//GEN-LAST:event_btnHighscoreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHighscore;
    private javax.swing.JButton btnLogin;
    // End of variables declaration//GEN-END:variables
}
