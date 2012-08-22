package datastructures;

/**
 * Implementation of a circular linked list class. Circular design was
 * chosen to make inserting and retrieving from either end of the list O(1)
 */
public class Linked<E> {
    // List head
    private Node<E> tail;
    // number of nodes in list
    private int size;
    
    // Node class to be used in the list
    class Node<T>{
        public Node<T> next;
        public T data;
        
        // compares the values
        public boolean compare(T obj){
            return data.equals(obj);
        }
        
        public Node(T _obj){
            data = _obj;
            next = null;
        }
    }
    
    /**
     * Creates an empty list
     */
    public Linked(){
        tail = null;
        size = 0;
    }
    
    /** 
     * Create a list containing the elements of array
     */ 
    public Linked(E[] array){
        for(E in : array){
            add(in);
        }
    }
    
    /**
     * Search for object obj in the list
     * @param object to search for in the list
     * @return true if the the specified object is in the list, false otherwise
     */ 
    public boolean search(E obj){
        boolean exist = false;
        if(tail != null){
            for(Node<E> list = tail; list != tail && !exist; list = list.next){
                if(list.compare(obj))
                    exist = true;
            }
        }
        return exist;
    }
    
    /** 
     * Append new node to list
     * @param object to be appended to the list 
     */
    public void add(E obj){
        addEnd(obj);
    }
    
    /**
     * Append a new node to the list
     * @param object to be appended to the list
     */ 
    public void addEnd(E obj){
        Node<E> newNode = new Node<>(obj);
        Node<E> tmp = tail;
        // check if tail null
        if(tail == null){
            tail = newNode;
            newNode.next = tail;
        }
        else{
            // new node point to beginning
            newNode.next = tail.next;
            // old tail point to new node 
            tail.next = newNode;
            // new node is new tail
            tail = newNode;
        }
        size++;
    }
    
    /** 
     * Insert new node to the beginning
     * @param object to be prepended to the list
     */ 
    public void addBeg(E obj){
        Node<E> newNode = new Node<>(obj);
        Node<E> tmp = tail;
        // check if tail null
        if(tail == null){
            tail = newNode;
            newNode.next = tail;
        }
        else{
            // new node point to old head
            newNode.next = tail.next;
            // tail point to new head 
            tail.next = newNode;
        }
        // increase size of list
        size++;
    }
    
    /** 
     * Remove first occurrence of an object with the same value as obj
     * @param object with equal value as the one to remove from the list
     * @return true if an object is removed, false otherwise
     */ 
    public boolean remove(E obj){        
        if(tail == null)
            return false;
        
        Node<E> list = tail.next;
        // delete tail if only node
        if(size == 1 && (tail.compare(obj))){
            tail = null;
            size--;
            return true;
        }
        // delete head node
        if(list.compare(obj)){
            tail.next = list.next;
            size--;
            return true;
        }
        // delete middle nodes
        while(list.next != tail){
            if(list.next.compare(obj)){
                // remove node from list
                list.next = list.next.next;
                size--;
                return true;
            }
            list = list.next;
        }
        // delete tail node
        if(tail.compare(obj)){
            list.next = tail.next;
            tail = list;
            size--;
            return true;
        }
        return false;
    }

//    remove node at index i
//    public void remove(int i){
//        // check bounds
//        if(i < 0 || i >= size){
//            throw new IndexOutOfBoundsException();
//        }
//        
//        
//    }
    
    /** 
     * Remove tail object from list
     * @return true if the tail is removed, false otherwise
     */
    public boolean removeLast(){
        if(tail == null)
            return false;
        
        Node<E> list = tail;
        // delete list if only one node
        if(size == 1){
            tail = null;
            size--;
        }
        // locate node before tail
        else{
            while(list.next != tail){
                list = list.next;
            }
            // remove tail node
            list.next = list.next.next;
            tail = list;
            size--;
        }
        return true;
    }
    
    /**
     * Remove head object from list
     * @return true if the head is removed, false otherwise
     */
    public boolean removeFirst(){
        if(tail != null){
            return remove(tail.next.data);
        }
        return false;
    }
    
    /** 
     * Return a reference to the first object with the same value as obj. If obj
     * doesn't exist, null is returned.
     * @param object containing value you want to search for in the list
     * @return reference to the first object with the same value as obj, null if 
     * obj doesn't exist
     */ 
    public E get(E obj){
        if(tail != null){
            // obtain the head of the list
            Node<E> list = tail.next;
            while(list != tail){
                if(list.compare(obj)){
                    return list.data;
                }
                list = list.next;
            }
            // check if obj equal tail
            if(list.compare(obj)){
                return list.data;
            }
        }
        return null;
    }
    
    /** 
     * Retrieve the first object in the list
     * @return first item in list, null if list is empty
     */ 
    public E getFirst(){
        if(tail != null){
            return tail.next.data;
        }
        return null;
    }
    
    /** 
     * Retrieve the last object in the list
     * @return last item in list, null if list is empty
     */ 
    public E getLast(){
        if(tail != null){
            return tail.data;
        }
        return null;
    }
    
    /**
     * Return the size of the list
     * @return number representing size of the list
     */ 
    public int size(){
        return size;
    }
    
    /**
     * Remove all values in list 
     */
    public void clear(){
        if(tail == null)
            return;
        Node<E> it = tail.next;
        Node<E> next;
        while(it != tail){
            next = it.next;
            it.next = null;
            it.data = null;
            it = next;
        }
        tail = null;
        size = 0;
    }
    
    @Override
    public String toString(){
        String returnVal = new String();
        if(tail != null){
            Node<E> list = tail.next;
            while(list != tail){
                returnVal += list.data.toString() + " ";
                list = list.next;
            }
            returnVal += tail.data.toString();
        }
        return returnVal;
    }
    
    public void print(){
        if(tail != null){
            System.out.println("head: " + tail.next.data.toString());
            for(Node<E> list = tail.next.next; list != tail; list = list.next){
                System.out.println("node: " + list.data.toString());
            }
            System.out.println("tail: " + tail.data.toString());
        }
    }
}
