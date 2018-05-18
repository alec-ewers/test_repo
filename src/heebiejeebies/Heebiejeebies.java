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
                WordFrame test = new WordFrame(3);
                test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                test.setVisible(true);
            } 
            
        });
       
        
        
    }
}

class ComponentTester extends JComponent {
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        Image ted = Toolkit.getDefaultToolkit().getImage("backblock.png");
        Image jeff = Toolkit.getDefaultToolkit().getImage("char.png");
        
        for (int I = 0; I < 640/64 + 1; I++) {
            for (int J = 0; J < 480/64 + 1; J++) {
                g2.drawImage(ted, I * 64, J * 64, this);
            }
        }
        
        g2.drawImage(jeff, 75, 75, this);

        g2.finalize();
        
        //g2.drawImage(ted, 10, 10, this);
        //g2.finalize();
    }
    
    private int MessageX = 75;
    private int MessageY = 100;

}

class WordFrame extends JFrame {
    
    public WordFrame(int init) {
        setTitle("I hate this parent/child heirarchy crap.");
        setSize(640, 480);
        
        if (init % 2 == 0) {
            CharTester test = new CharTester();
            add(test);
        }else if (init % 2 == 1) {
            ComponentTester tester = new ComponentTester();
            add(tester);
        }
        //ComponentTester tester = new ComponentTester();
        ////CharTester test = new CharTester();
        //add(tester);
        ////add(test);
    }

}