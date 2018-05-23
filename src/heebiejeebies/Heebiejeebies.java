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
import java.util.ArrayList;

/**
 *
 * @author alec.ewers
 */
public class Heebiejeebies {
    
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

class WordFrame extends JFrame {
    
    public WordFrame() {
        
        setTitle("I hate this parent/child heirarchy crap.");
        setSize(640, 480);
        
        addKeyListener(new listening());
        
        ComponentTester test  = new ComponentTester();
        add(test);
        
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
        
        Image rob = Toolkit.getDefaultToolkit().getImage("textBox.png");
        Image bob = Toolkit.getDefaultToolkit().getImage("cursor.png");

        g2.drawImage(rob, 0, 480-150, this);
        
        try {
            reader.read("menutest", iteration);
        } catch (IOException e) {
            
        }
        
        iteration++;
        
        int dialogPos = 0;
        
        String[] hold = reader.getReadList();
        
        if (ComponentTester.getNext() == true) {
            ComponentTester.setSpeechPos(ComponentTester.getSpeechPos() + 1 <= 
                    hold.length - 1 ? 
                    ComponentTester.getSpeechPos() + 1 : 
                    ComponentTester.getSpeechPos());
        }
        
        String I = hold[ComponentTester.getSpeechPos()];
        if (I.contains("/'/")) {
            int L = 0;
            ComponentTester.setMaxPos(Character.getNumericValue(
                    I.charAt(0)));
            for (String J : I.split("/'/")) {
                for (String K : J.split("_")) {
                    if (L % 2 != 1) {
                        if (L == 0) {
                            g2.drawString(K.substring(1), 50, 360 
                                    + dialogPos * 25);
                            dialogPos++;
                            ComponentTester.setMenu(true);
                            L++;
                        } else {
                            g2.drawString(K, 50, 360 + dialogPos * 25);
                            dialogPos++;
                            ComponentTester.setMenu(true);
                            L++;
                        }
                    } else {
                        outputs.add(K);
                        L++;
                    }
                }
            }
        } else {
            g2.drawString(I, 35, 360);
            ComponentTester.setSpeaking(true);
        }
        ComponentTester.setNext(false);
        
        if (ComponentTester.getMenu() == true) {
            g2.drawImage(bob, 35, 350 + ComponentTester.getCursPos() * 25, 
                    this);
        }
        
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            
        }
        
        repaint();
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
        if (cursPos + y != -1 && cursPos + y != maxPos) {
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
    
    public static String getOutputs(int index) {
        return outputs.get(index);
    }
    
    public static void setSpeechPos(int y) {
        speechPos = y;
    }
    
    public static int getSpeechPos() {
        return speechPos;
    }
    
    private static ArrayList<String> outputs = new ArrayList<>(); 
    private static boolean isMenu = false;
    private static boolean isNext = false;
    private static boolean isSpeaking = false;
    private static int cursPos = 0;
    private static int maxPos = 0;
    private static int speechPos = 0;
    private static int iteration = 0;

}

class reader {
    
    private static String content;
    private static ArrayList<String> parts = new ArrayList<>();
    
    public static void read(String target, int iteration) throws IOException {
        if (iteration == 0) {
            String continent = new String(Files.readAllBytes(Paths.get(target 
                    + ".txt")));
            content = continent;
            for (String I: content.split("\n")) {
                parts.add(I);
            }
        }
    }
    
    public static String getRead() {
        return content;
    }
    
    public static String [] getReadList() { 
        return parts.toArray(new String[parts.size()]);
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

        if (ComponentTester.getSpeaking() == true) {
            if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_ENTER) {
                ComponentTester.setNext(true);
                ComponentTester.setSpeaking(false);
            }
        } else if (ComponentTester.getSpeaking() == false) {
            if (key == KeyEvent.VK_UP) {
                ComponentTester.setCursPos(-1);
            } else if (key == KeyEvent.VK_DOWN) {
                ComponentTester.setCursPos(1);
            } else if (key == KeyEvent.VK_X) {
                ComponentTester.setMenu(false);
            } else if (ComponentTester.getMenu() == true && 
                    key == KeyEvent.VK_ENTER) {
                ComponentTester.setMenu(false);
                System.out.println(ComponentTester.getOutputs(
                        ComponentTester.getCursPos()));
                ComponentTester.setNext(true);
            }
        }
    }
}