/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author zesty
 */
public class QueTest {
    private Que<Integer> queue;
    
    public QueTest() {
        queue = new Que<>();
    }

    /**
     * Test of enqueue method, of class Que.
     */
    @Test
    public void testEnqueueOne() {
        Integer number = new Integer(1);
        queue.enqueue(number);
        assertEquals(number,queue.peek());
    }
    /**
     * Test of enqueue method, of class Que.
     */
    @Test
    public void testEnqueueMany() {
        for(int i = 0; i < 10; i++){
            queue.enqueue(i);
        }
        assertEquals(new Integer(0),queue.peek());        
    }

    /**
     * Test of dequeue method, of class Que.
     */
    @Test
    public void testDequeueOne() {
        Integer number = new Integer(1);
        queue.enqueue(number);
        assertEquals(number,queue.dequeue());
    }
    
    /**
     * Test of dequeue method, of class Que.
     */
    @Test
    public void testDequeueMany() {
        Integer[] list = new Integer[5];
        for(int i = 0; i < list.length; i++){
            list[i] = i;
            queue.enqueue(i);
        }
        for(int i = 0; i < list.length;i++){
            if(list[i].compareTo(queue.dequeue()) != 0)
                fail("Queue not in correct order");
        }
    }
    
    /**
     * Test empty method
     */
    @Test
    public void testEmpty(){
        assertTrue("Queue should be empty", queue.empty());
    }
    
    /**
     * Test empty method
     */
    @Test
    public void testNotEmpty(){
        queue.enqueue(new Integer(1));
        assertFalse("Queue should not be empty", queue.empty());
    }

    /**
     * Test of peek method, of class Que.
     */
    @Test
    public void testPeek() {
        Integer number = new Integer(1);
        queue.enqueue(number);
        assertEquals(number,queue.peek());
    }
    
    /**
     * Test of peek method, of class Que.
     */
    @Test
    public void testPeekEmpty() {
        assertNull(queue.peek());
    }
}
