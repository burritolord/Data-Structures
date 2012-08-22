package datastructures;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class LinkedTest {
    private Linked<Integer> list;
    
    public LinkedTest() {
        list = new Linked<>();
    }
    
    /**
     * Test retrieving the first item
     */
    @Test
    public void testGetFirst() {
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        assertEquals(new Integer(1), list.getFirst());
    }

    /**
     * Test retrieving the last item
     */
    @Test
    public void testGetLast() {
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        assertEquals(new Integer(3), list.getLast());
    }
    
    /**
     * Test adding a single item
     */
    @Test
    public void testAddOneItem() {
        Integer node = new Integer(1);
        list.add(node);
        assertEquals("Integer not found", node, list.get(1));
    }

    /**
     * Test adding many items
     */
    @Test
    public void testAddManyItems() {
        for(int i = 0; i < 10; i++){
            list.add(new Integer(i));
        }
        
        for(int i = 0; i < 10; i++){
            if(list.get(i) == null)
                fail("An item was not added");
        }
    }
    
    /**
     * Test adding an item to the end
     */
    @Test
    public void testAddEnd() {
        Integer node1 = new Integer(1);
        Integer node2 = new Integer(2);
        list.addEnd(node1);
        list.addEnd(node2);
        assertEquals(node2, list.getLast());
    }

    /**
     * Test adding to the beginning
     */
    @Test
    public void testAddBeg() {
        Integer node1 = new Integer(1);
        Integer node2 = new Integer(2);
        list.addBeg(node1);
        list.addBeg(node2);
        assertEquals(node2, list.getFirst());
    }

    /**
     * Delete an item in the list
     */
    @Test
    public void testRemove() {
        list.add(new Integer(1));
        assertTrue(list.remove(1));
        assertNull(list.get(1));
    }

    /**
     * Test of removeLast method, of class Linked.
     */
    @Test
    public void testRemoveLast() {
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.removeLast();
        assertEquals(new Integer(1), list.getLast());
    }

    /**
     * Test of removeFirst method, of class Linked.
     */
    @Test
    public void testRemoveFirst() {
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.removeFirst();
        assertEquals(new Integer(2), list.getFirst());
    }

    /**
     * Test removing from empty list
     */
    @Test
    public void testRemoveEmpty() {
        list.remove(1);
        assertEquals(null, list.get(1));
    }
    
    /**
     * Test removing from empty list
     */
    @Test
    public void testRemoveNonExist() {
        list.add(1);
        list.remove(2);
        assertEquals(null, list.get(2));
    }
    
    /**
     * Test of get method, of class Linked.
     */
    @Test
    public void testGet() {
        list.add(new Integer(1));
        assertEquals(new Integer(1),list.get(1));
    }

    /**
     * Test retrieving from empty list
     */
    @Test
    public void testGetEmpty() {
        assertEquals(null ,list.get(1));
    }
    
    /**
     * Test of size method, of class Linked.
     */
    @Test
    public void testSize() {
        for(int i = 0; i < 10; i++){
            list.add(new Integer(i));
        }
        assertEquals(10, list.size());
    }
    
    /**
     * Test clear list of size 1
     */
    @Test
    public void testClearOne(){
        list.add(new Integer(1));
        list.clear();
        assertNull(list.getFirst());
        assertEquals(0, list.size());
    }
    
    /**
     * Test clear list of size 10
     */
    @Test
    public void testClearMany(){
        for(int i = 0; i < 10; i++){
            list.add(new Integer(i));
        }
        list.clear();
        for(int i = 0; i < 10; i++){
            if(list.get(i) != null){
                fail("List was not completely emptied");
            }
        }
        assertEquals(0, list.size());
    }
}
