/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musikplayer;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.text.Normalizer.Form;

import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javazoom.jl.player.Player;

import javazoom.jl.decoder.JavaLayerException;
/**
 *
 * @author HP
 */
public class playermusik extends javax.swing.JFrame {
FileInputStream FIS;
BufferedInputStream BIS;
public Player player;
public long pauseLocation;
public long songTotalLength; 
public String fileLocation;
      DefaultListModel model = new DefaultListModel();
    private Player mp3;
    int a = 0;

private boolean canResume;
private String path;
private int total;
private int stopped;
private boolean valid;
 private volatile boolean continuePlaying = true;
    /**
     * Creates new form Player Musik
     */
    public playermusik() {
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

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        pause = new javax.swing.JButton();
        Playicon = new javax.swing.JButton();
        Stop = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pemutar Musik");

        jButton1.setText("Tambah musik");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        jButton2.setText("Play musik");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pause.setText("Pause");
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });

        Playicon.setText("Play");
        Playicon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayiconActionPerformed(evt);
            }
        });

        Stop.setText("Stop");
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopActionPerformed(evt);
            }
        });

        jButton3.setText("Delete musik");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Tidak memainkan musik");

        jLabel3.setText("Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(21, 21, 21)
                .addComponent(pause)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Playicon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Stop)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(166, 166, 166))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Playicon))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pause)
                            .addComponent(Stop))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         JFileChooser fc = new JFileChooser();
       JFrame jf = new JFrame();
       int setuju = fc.showOpenDialog(jf.add(fc));
       int posisi = jList1.getModel().getSize();
       if(setuju == JFileChooser.APPROVE_OPTION){
           File file = fc.getSelectedFile();
           String text = file.getPath();
           String[] txt;
           txt = new String[]{text};
           model.add(posisi, text);
       }
       jList1.setModel(model);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
        
            String main = (String) jList1.getSelectedValue();
           jLabel2.setText(main);
            FileInputStream inputfile=new FileInputStream(main);
            FIS = new FileInputStream(main);
            songTotalLength = FIS.available();
            BufferedInputStream bis=new BufferedInputStream(FIS);
            player=new Player(bis);
           
           fileLocation = main + "";
          
        }catch(FileNotFoundException | JavaLayerException e){
            JOptionPane.showMessageDialog(null,e);
        } catch (IOException ex) {
        Logger.getLogger(playermusik.class.getName()).log(Level.SEVERE, null, ex);
    }
       
        new Thread(){
           
            @Override
            public void run(){
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                    Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
        
        if(player != null) {
            
        }

                                 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int posisi = jList1.getSelectedIndex();
        model.remove(posisi);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed
        // TODO add your handling code here:
        if(player != null){
try {
pauseLocation = FIS.available();
player.close();
} catch (IOException ex) {
}
           jLabel2.setText("pause");
}
                      
    }//GEN-LAST:event_pauseActionPerformed

    private void PlayiconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayiconActionPerformed
        // TODO add your handling code here:
        try {
    
    if (player == null) {
            String main = (String) jList1.getSelectedValue();
           jLabel2.setText(main);
            FileInputStream inputfile=new FileInputStream(main);
            FIS = new FileInputStream(main);
            songTotalLength = FIS.available();
            BufferedInputStream bis=new BufferedInputStream(FIS);
            player=new Player(bis);
           
           fileLocation = main + "";
          
    }
    
    
    if (player != null) {
               
               
           jLabel2.setText("resume " +fileLocation);
    
FIS = new FileInputStream(fileLocation);

FIS.skip(songTotalLength - pauseLocation);
BIS = new BufferedInputStream(FIS);


player = new Player(BIS);
    
           }
    
      
     
} catch (FileNotFoundException ex) {
} catch (IOException ex) {

}   catch (JavaLayerException ex) {
        Logger.getLogger(playermusik.class.getName()).log(Level.SEVERE, null, ex);
    }

new Thread(){
@Override
public void run(){

    try{
player.play();

}
catch(JavaLayerException ex){
}
}

}.start();

    }//GEN-LAST:event_PlayiconActionPerformed

    private void StopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopActionPerformed
        // TODO add your handling code here:
         player.close();
       if(player != null){
player.close();
pauseLocation = 0;
songTotalLength = 0;
jLabel2.setText("music stoppen");
}
    }//GEN-LAST:event_StopActionPerformed

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
            java.util.logging.Logger.getLogger(playermusik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(playermusik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(playermusik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(playermusik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new playermusik().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Playicon;
    private javax.swing.JButton Stop;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pause;
    // End of variables declaration//GEN-END:variables
}
