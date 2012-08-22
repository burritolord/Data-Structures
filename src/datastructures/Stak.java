package datastructures;
/**
 * A generic stack class that represents a last-in-first-out stack of objects. 
 */
public class Stak<E> {
    // list holding data
    private Linked<E> stack;
    
    /**
     * Creates an empty stack
     */
    public Stak(){
        stack = new Linked<>();
    }
    
    /**
     * Creates a stack containing objects in list
     * @param list of objects to be inserted. first object will
     * be at the bottom of the stack
     */
    public Stak(E[] list){
        for(E it : list){
            stack.addBeg(it);
        }
    }
    
    /**
     * Add an object to the top of the stack
     * @param obj 
     */
    public void push(E obj){
        stack.addBeg(obj);
    }
    
    /**
     * Return object on top of the stack and remove it
     * @return last object pushed on the stack
     */
    public E pop(){
        E returnVal = stack.getFirst();
        stack.removeFirst();
        return returnVal;
    }
    
    /**
     * Test if stack is empty
     * @return true if stack contains zero elements, false otherwise
     */
    public boolean empty(){
        return (stack.size() == 0);
    }
    
    /**
     * Look at object to the top of the stack without removing it
     * @return the object on top of the stack
     */
    public E peek(){
        return stack.getFirst();
    }
    
    /**
     * Create sting containing stack elements in order of top to bottom
     * @return sting containing stack elements separated by spaces
     */
    @Override
    public String toString(){
        return stack.toString();
    }
    
    /**
     * Remove all values in list 
     */
    public void clear(){
        stack.clear();
    }
}
