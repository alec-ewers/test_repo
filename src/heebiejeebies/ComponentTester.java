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
        g.drawString("I am that I will.", MessageX, MessageY);
    }
    
    private int MessageX = 75;
    private int MessageY = 100;

}
