/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heebiejeebies;

/**
 *
 * @author mr_penumbra
 * @Override run() the run method of thread
 */
public class ThreadTester implements Runnable {
    
    public ThreadTester() { 
        Thread thread = new Thread(this);
        thread.start();
    }
    
    @Override
    public void run() {
        System.out.println("I did a thing.");
    }
    
}
