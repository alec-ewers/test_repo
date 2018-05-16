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
public class CharTester extends JComponent {

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        Image ted = Toolkit.getDefaultToolkit().getImage("char.png");
        
        g2.drawImage(ted, 75, 75, this);
        
        g2.finalize();
        
        //g2.drawImage(ted, 10, 10, this);
        //g2.finalize();
    }
    
    
}
