//возможно при переоткрытии файла нужно удалять старый плеер
//удалить controllerUpdate и import java.awt.*; pack в самом конце?
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.media.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Menu extends javax.swing.JFrame implements ActionListener, ControllerListener {
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1; // End of variables declaration//GEN-END:variables
    public JMenuBar getjMenuBar1 (){return jMenuBar1;}
    public JButton btn_play, btn_pause, btn_stop;
    private String mediafile=null;
    private File file;
    JFXPanel pnl;
    MediaPlayer mediaplayer;




    public static void main(String args[]) { /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }   //</editor-fold>
         /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    } // Variables declaration - do not modify//GEN-BEGIN:variables

    Menu ()
    {
        initComponents();
        setTitle("Media Player");
        setSize(1000, 524);
        setLocation(0, 0);
    }

    private void initComponents() {
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jMenu1.setText("File");
        jMenuItem1.setText("open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenuBar1.add(jMenu1);
        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);
        setJMenuBar(jMenuBar1);
        pnl = new JFXPanel();


        btn_play=new JButton ("Play");
        btn_play.setBounds(60, 400, 220, 30);
        pnl.setBounds(800, 800, 200, 100);

        pnl.setLayout(null);
        pnl.add(btn_play);
        add (pnl);
        setVisible(true);

        /*Media musicFile = new Media(
                "file:///C:/Users/Wovch/Desktop/Player/lumen_-_dukh_vremeni_(zaycev.net).mp3");
        File f=new File ("C:/Users/Wovch/Desktop/Player/1.mp4");
        String s=f.toString();
        System.out.println (s);
        String rep=s.replace("\\", "/");

        String files="file:///"+rep;
        System.out.println (files);
        */

        pack();

    }




    public void controllerUpdate(ControllerEvent ce) { //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            System.out.println ("adsf");
            Container con = getContentPane();
            if (ce instanceof RealizeCompleteEvent) {




                con.doLayout();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getfile() { //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            JFileChooser choose = new JFileChooser();
            choose.showOpenDialog(this);
            file = choose.getSelectedFile();
            //file= new File ("C:\\Create_Media_Player_In_Java_Using_NetBeans_By_Umes.mpg");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
        } catch (HeadlessException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        System.out.println (file);
        String s=file.toString();
        String rep=s.replace("\\", "/");
        rep="file:///"+rep;
        return rep;

    }


    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            mediafile=getfile();
            if (mediafile==null) {}
            Media videoFile = new Media(mediafile);
            if (mediaplayer!=null) {mediaplayer.stop();}
            mediaplayer = new MediaPlayer(videoFile);
            //mediaplayer.setAutoPlay(true);
            mediaplayer.setVolume(0.5);

            pnl.setScene(new Scene(new MediaControl(mediaplayer)));
            repaint();
            //pack();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}