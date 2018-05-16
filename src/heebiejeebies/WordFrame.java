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
