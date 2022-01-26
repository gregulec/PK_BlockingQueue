/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk_blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Agnieszka
 */
public class Buffer implements IBuffer{

    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    
    @Override
    public void put(int v) {
        try {
            queue.put(v);
        } catch (InterruptedException ex) {
            System.out.println(" producer interrupted");
        }
    }

    @Override
    public int get() {
        int temp = 0;
        try {
            temp = queue.take();
        } catch (InterruptedException ex) {
            System.out.println(" consumer interrupted");
        }
        return temp;
    }   
}
