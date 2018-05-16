/*
 * This code was written by Alec Ewers, whether he's proud of it
 * or not. It is distributed freely so long as you include this
 * header and give what you think is appropriate credit.
 * This code comes with no warranty, implied or otherwise.
 */

package heebiejeebies;

import javax.swing.*;

/**
 *
 * @author alec.ewers
 */
public class WordFrame extends JFrame {
    
    public WordFrame() {
        setTitle("I hate this parent/child heirarchy crap.");
        setSize(640, 480);
        
        ComponentTester tester = new ComponentTester();
        add(tester);
    }

}
