/*
 * This code was written by Alec Ewers, whether he's proud of it
 * or not. It is distributed freely so long as you include this
 * header and give what you think is appropriate credit.
 * This code comes with no warranty, implied or otherwise.
 */

package heebiejeebies;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author alec.ewers
 */
public class ComponentTester extends JComponent {
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        Image ted = Toolkit.getDefaultToolkit().getImage("backblock.png");
        
        for (int I = 0; I < 640/64 + 1; I++) {
            for (int J = 0; J < 480/64 + 1; J++) {
                g2.drawImage(ted, I * 64, J * 64, this);
            }
        }

        g2.finalize();
        
        //g2.drawImage(ted, 10, 10, this);
        //g2.finalize();
    }
    
    private int MessageX = 75;
    private int MessageY = 100;

}
