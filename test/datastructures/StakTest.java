/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;


public class StakTest {
    private Stak<Integer> stack;
    public StakTest() {
        stack = new Stak<>();
    }

    /**
     * Test of push method, of class Stak.
     */
    @Test
    public void testPushOne() {
        Integer number = new Integer(1);
        stack.push(number);
        assertEquals(number,stack.peek());
    }

    /**
     * Test of push method, of class Stak.
     */
    @Test
    public void testPushMany() {
        Integer number = new Integer(1);
        for(int i = 0; i < 10; i++){
            stack.push(i);
        }
        assertEquals(new Integer(9),stack.peek());        
    }
    
    /**
     * Test of pop method, of class Stak.
     */
    @Test
    public void testPopOne() {
        Integer number = new Integer(1);
        stack.push(number);
        assertEquals(number,stack.pop());
    }
    
    /**
     * Test of pop method, of class Stak.
     */
    @Test
    public void testPopMany() {
        Integer[] list = new Integer[5];
        for(int i = 0; i < list.length; i++){
            list[i] = i;
            stack.push(i);
        }
        for(int i = list.length - 1; i >= 0; i--){
            if(list[i].compareTo(stack.pop()) != 0)
                fail("Stack not in right order");
        }    
    }

    /**
     * Test of empty method, of class Stak.
     */
    @Test
    public void testEmpty() {
        assertTrue("Queue should be empty", stack.empty());
    }
    
    /**
     * Test empty method
     */
    @Test
    public void testNotEmpty(){
        stack.push(new Integer(1));
        assertFalse("Queue should not be empty", stack.empty());
    }

    /**
     * Test of peek method, of class Stak.
     */
    @Test
    public void testPeek() {
        Integer number = new Integer(1);
        stack.push(number);
        assertEquals(number,stack.peek());
    }
    
    /**
     * Test of peek method, of class Stak.
     */
    @Test
    public void testPeekEmpty() {
        assertNull(stack.peek());
    }
}
