/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject3;

/**
 *
 * @author PC GAMER
 */
public class NewJFrame extends javax.swing.JFrame {
    int x = 100;
    int y = 100;

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
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

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(32767, 32767));

        jPanel1.setPreferredSize(new java.awt.Dimension(32767, 32767));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, Short.MAX_VALUE, Short.MAX_VALUE)
        );

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32307, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        jTextArea1.append(evt.getKeyChar()+"\n");
        
        if (evt.getKeyChar() == 'h') {
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y, x, y + 300);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x +100, y, x + 100, y + 300);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y + 150, x + 100, y + 150);
            x = 150 + x;
        }
        if (evt.getKeyChar() == 'o') {
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y, x +100, y);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y, x, y + 300);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y + 300, x + 100, y + 300);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x + 100, y, x + 100, y + 300);
            x = 150 + x;
        }
        if (evt.getKeyChar() == 'l'){
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y, x, y + 300);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y + 300, x + 100, y + 300);
            x = 150 + x;
        }
        if (evt.getKeyChar() == 'a'){
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y, x, y + 300);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x + 100, y, x + 100, y + 300);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y + 150, x + 100, y + 150);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y, x + 100, y);
            x = 150 + x;
        }
        if(evt.getKeyChar() == 'm'){
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y, x, y + 300);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x + 100, y, x + 100, y + 300);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y, x + 50, y + 150);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x + 100, y, x + 50, y + 150);
            x = 150 + x;
        }
        if(evt.getKeyChar() == 'u'){
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y, x, y + 300);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y + 300, x + 100, y + 300);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x + 100, y + 300, x + 100, y);
            x = 150 + x;
        }
        if (evt.getKeyChar() == 'n') {
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y, x, y + 300);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x +100, y, x + 100, y + 300);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y, x + 100, y + 300);
            x = 150 + x;
        }
        if (evt.getKeyChar() == 'd'){
            Dibujo.hacerLinea(jPanel1.getGraphics(), x , y, x, y + 300);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x + 100, y + 50, x + 100, y + 250);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y, x + 100, y + 50);
            Dibujo.hacerLinea(jPanel1.getGraphics(), x, y + 300, x + 100, y +250);
            x = 150 + x;
        }
        if (evt.getKeyChar() == ' '){
            x = 150 + x;
        }
        if (evt.getKeyChar() == '\n'){
            x = 100;
            y =  y + 400;
        }
        
    }//GEN-LAST:event_jTextField1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
