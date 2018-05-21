/*
 * This is a test space for learning the tools that we are going to need for
 * the new game. God I love having freedom to do stuff like this.
 */
package heebiejeebies;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author alec.ewers
 */
public class Heebiejeebies {
    
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException{
        WordFrame test = new WordFrame();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
        
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
        
        g2.drawImage(jeff, X, Y, this);
        
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            
        }
        
        repaint();
        //g2.drawImage(ted, 10, 10, this);
        //g2.finalize();
    }
    
    //turns out that the JComponent class 
    
    public static void setXPos(int x) {
        X = x;
    }
    
    public static int getXPos() {
        return X;
    }
    
    public static void setYPos(int y) {
        Y = y;
    }
    
    public static int getYPos() {
        return Y;
    }
    
    private static int X = 75;
    private static int Y = 100;

}

class WordFrame extends JFrame {
    
    public WordFrame() {
        dispose();
        
        setTitle("I hate this parent/child heirarchy crap.");
        setSize(640, 480);
        
        addKeyListener(new listening());
        
        ComponentTester test  = new ComponentTester();
        add(test);
        
    }
}

class listening implements KeyListener {
    
    //included for functionality's sake
    @Override
    public void keyTyped(KeyEvent ke) {
    }
    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
    //responds to inputs of different types
    @Override
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT) {
            ComponentTester.setXPos(ComponentTester.getXPos() - 5);
            //System.out.println("We have left-off!");
        } else if (key == KeyEvent.VK_RIGHT) {
            ComponentTester.setXPos(ComponentTester.getXPos() + 5);
            //System.out.println("It's a right-off!");
        } else if (key == KeyEvent.VK_DOWN) {
            ComponentTester.setYPos(ComponentTester.getYPos() + 5);
            //System.out.println("You're getting me down!");
        } else if (key == KeyEvent.VK_UP) {
            ComponentTester.setYPos(ComponentTester.getYPos() - 5);
            //System.out.println("Try to keep up!");
        }
    }
}