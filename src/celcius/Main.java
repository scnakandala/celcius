package celcius;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.DBConnectionFailed;
import view.MainWindow;

public class Main {

    public static void main(String[] args) {
        if (!Config.checkDBConnection()) {
            java.awt.EventQueue.invokeLater(new Runnable() {

                public void run() {
                    DBConnectionFailed dialog = new DBConnectionFailed(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                }
            });
        } else {
            try {
                java.awt.EventQueue.invokeLater(new Runnable() {

                    public void run() {
//                        try {
//                            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//                        } catch (ClassNotFoundException ex) {
//                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (InstantiationException ex) {
//                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IllegalAccessException ex) {
//                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (UnsupportedLookAndFeelException ex) {
//                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                        }
                        MainWindow mainWindow = new MainWindow();
                        MainWindow.setDefaultLookAndFeelDecorated(true);
                        mainWindow.setVisible(true);
                        mainWindow.setExtendedState(mainWindow.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                    }
                });

            } catch (Exception e) {
                java.awt.EventQueue.invokeLater(new Runnable() {

                    public void run() {
                        DBConnectionFailed dialog = new DBConnectionFailed(new javax.swing.JFrame(), true);
                        dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                            @Override
                            public void windowClosing(java.awt.event.WindowEvent e) {
                                System.exit(0);
                            }
                        });
                        dialog.setVisible(true);
                    }
                });
            }
        }
    }
}
