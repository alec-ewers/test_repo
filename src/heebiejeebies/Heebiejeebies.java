/*
 * This is a test space for learning the tools that we are going to need for
 * the new game. God I love having freedom to do stuff like this.
 */
package heebiejeebies;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author alec.ewers
 */
public class Heebiejeebies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                WordFrame tester = new WordFrame();
                tester.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                tester.setVisible(true);
            } 
            
        });
        
//        JFrame JFrame1 = new JFrame();
//        JFrame1.setSize(800, 600);
//        JFrame1.setLocation(125, 90);
//        JFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        Container content = JFrame1.getContentPane();
//        ComponentTester component = new ComponentTester();
//        
//        JFrame1.add(content);
//        
//        JFrame1.setVisible(true);
    }
    
}
