package datastructures;
/**
 * A generic queue class that represents a first-in-first-out queue of objects 
 */
public class Que<E> {
    // list holding data
    private Linked<E> queue;
    
    /**
     * Creates an empty queue
     */
    public Que(){
        queue = new Linked<>();
    }
    
    /**
     * Create a queue containing objects in list
     * @param list of objects to insert into the queue 
     */
    public Que(E[] list){
        for(E it : list)
            queue.addEnd(it);
    }
    
    /**
     * Add an object to the queue
     * @param obj to be inserted in queue
     */
    public void enqueue(E obj){
        queue.addEnd(obj);
    }
    
    /**
     * Return object in beginning of queue and remove it
     * @return first object in the queue
     */
    public E dequeue(){
        E returnVal = queue.getFirst();
        queue.removeFirst();
        return returnVal;
    }
    
    /**
     * Test if the queue is empty
     * @return true if the queue is empty, false otherwise
     */
    public boolean empty(){
        return (queue.size() == 0);
    }
    
    /**
     * Look at the object in the front of the queue without removing it
     * @return the object in front of the queue
     */
    public E peek(){
        return queue.getFirst();
    }
    
    @Override
    public String toString(){
        return queue.toString();
    }
}