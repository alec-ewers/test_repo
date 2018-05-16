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
       
    }
    
}
