/*
 * This is a test space for learning the tools that we are going to need for
 * the new game. God I love having freedom to do stuff like this.
 */
package heebiejeebies;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author alec.ewers
 */
public class CharTester {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                WordFrame test = new WordFrame();
                test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                test.setVisible(true);
            }
        });
    }
        
 }


//It goes kind of like this:
//You start able to move around.
//You can enter a menu with e.
//while in the menu, pressing a button will skip dialog.
//when encountering a proper menu, up and down will ove the cursor.
//e will select.
//press x to return to movement.

class ComponentTester extends JComponent {
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        Image ted = Toolkit.getDefaultToolkit().getImage("backblock.png");
        Image jeff = Toolkit.getDefaultToolkit().getImage("char.png");
        Image rob = Toolkit.getDefaultToolkit().getImage("textBox.png");
        Image bob = Toolkit.getDefaultToolkit().getImage("cursor.png");
        
        for (int I = 0; I < 640/64 + 1; I++) {
            for (int J = 0; J < 480/64 + 1; J++) {
                g2.drawImage(ted, I * 64, J * 64, this);
            }
        }
        
        g2.drawImage(rob, 0, 480-150, this);
        
        try {
            reader.read("menutest");
        } catch (IOException e) {
            
        }
        
        String content = reader.getRead();
        int dialogPos = 0;
        ComponentTester.setNext(true);
        
        for (String I : content.split("\n")) {
            if (ComponentTester.getNext() == true) {
                if (I.contains("/'/")) {
                    for (String J : I.split("/'/")) {
                        g2.drawString(J, 50, 350 + dialogPos * 25);
                        dialogPos++;
                        ComponentTester.setMaxPos(ComponentTester.getMaxPos() + 1);
                    }
                } else {
                    g2.drawString(I, 35, 340);
                }
            }
            ComponentTester.setNext(false);
        }
        
        if (ComponentTester.getMenu() == true) {
            g2.drawImage(bob, 35, 480-165 + ComponentTester.getCursPos() * 25, this);
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
    
    public static boolean getMenu() {
        return isMenu;
    }
    
    public static void setMenu(boolean newMenu) {
        isMenu = newMenu;
    }
    
    public static boolean getSpeaking() {
        return isSpeaking;
    }
    
    public static void setSpeaking (boolean newTalk) {
        isSpeaking = newTalk;
    }
    
    public static boolean getNext() {
        return isNext;
    }
    
    public static void setNext (boolean newFollow) {
        isNext = newFollow;
    }
    
    public static void setCursPos(int y) {
        if (cursPos + y != -1 || cursPos + y != maxPos + 1) {
            cursPos += y;
        }
    }
    
    public static int getCursPos() {
        return cursPos;
    }
    
    public static void setMaxPos(int y) {
        maxPos = y;
    }
    
    public static int getMaxPos() {
        return maxPos;
    }
    
    private static boolean isMenu = false;
    private static boolean isNext = false;
    private static boolean isSpeaking = false;
    private static int X = 75;
    private static int Y = 100;
    private static int cursPos = 0;
    private static int maxPos;

}

class reader {
    
    private static String content;
    
    public static void read(String target) throws IOException {
        String continent = new String(Files.readAllBytes(Paths.get(target + ".txt")));
        content = continent;
    }
    
    public static String getRead() {
        return content;
    }
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
        
        if (ComponentTester.getMenu() == false) {
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
            } else if (key == KeyEvent.VK_E) {
                ComponentTester.setYPos(ComponentTester.getYPos() - 5);
                ComponentTester.setMenu(true);
            }
        } else if (ComponentTester.getMenu() == true) {
            if (ComponentTester.getSpeaking() == true) {
                if (key != 0) {
                    ComponentTester.setNext(true);
                }
            } else if (ComponentTester.getSpeaking() == false) {
                if (key == KeyEvent.VK_UP) {
                    ComponentTester.setCursPos(-1);
                } else if (key == KeyEvent.VK_DOWN) {
                    ComponentTester.setCursPos(1);
                } else if (key == KeyEvent.VK_X) {
                    ComponentTester.setMenu(false);
                }
            }
        }
    }
}