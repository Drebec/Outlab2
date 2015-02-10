/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JFrame;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

/**
 *
 * @author Drew
 */
public class PhoneList extends JFrame{
    public PhoneList() {
        super("Phone List");        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new FileIO());
        getContentPane().add(new PhonePanel());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    
    private class FileIO implements WindowListener {
        public void windowDeactivated(WindowEvent e) {
            
        }
        
        public void windowActivated(WindowEvent e) {
            
        }
        
        public void windowDeiconified(WindowEvent e) {
            
        }
        
        public void windowIconified(WindowEvent e) {
            
        }
        
        public void windowClosed(WindowEvent e) {
            
        }
        
        public void windowClosing(WindowEvent e) {
            File fileOut = new File(PhonePanel.getList().printToFile());
            System.exit(0);
        }
        
        public void windowOpened(WindowEvent e) {
            File fileIn = new File();
        }
    }
    
    public static void main(String[] args) {
        PhoneList list = new PhoneList();
    }
}
