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
        
        frameThread FThread = new frameThread(test);
        
        while (1==1) {
            FThread.sleep(100);
            
            FThread.run();
        }
    }
}

class frameThread extends Thread {
    
    private WordFrame hold;
    private int X;
    private int oldX;
    private int Y;
    private int oldY;
    
    public frameThread(WordFrame frame) {
        hold = frame;
    }
    
    @Override
    public void run() {
        X = ComponentTester.getXPos();
        Y = ComponentTester.getYPos();
        
        if (X != oldX || Y != oldY) {
            hold.repaint();
        }
        
        oldX = X;
        oldY = Y;
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

        g2.finalize();
        
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
        
        CharTester test  = new CharTester();
        add(test);
        
    }
    
    public void handleKeyPush(KeyEvent ke) {
        int key = ke.getKeyCode();
        
        switch (key) {
            case KeyEvent.VK_LEFT :
                ComponentTester.setXPos(ComponentTester.getXPos() - 5);
            case KeyEvent.VK_RIGHT :
                ComponentTester.setXPos(ComponentTester.getXPos() + 5);
            case KeyEvent.VK_DOWN :
                ComponentTester.setYPos(ComponentTester.getYPos() - 5);
            case KeyEvent.VK_UP :
                ComponentTester.setYPos(ComponentTester.getYPos() + 5);
        }
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
        switch (key) {
            case KeyEvent.VK_LEFT :
                ComponentTester.setXPos(ComponentTester.getXPos() - 5);
            case KeyEvent.VK_RIGHT :
                ComponentTester.setXPos(ComponentTester.getXPos() + 5);
            case KeyEvent.VK_DOWN :
                ComponentTester.setYPos(ComponentTester.getYPos() - 5);
            case KeyEvent.VK_UP :
                ComponentTester.setYPos(ComponentTester.getYPos() + 5);
        }
    }
}