package datastructures;
import java.util.LinkedList;

/**
 * A generic binary tree class
 */
public class BinaryTree<T extends Comparable> {
    // root node
    private Node<T> root;
    
    // Node class to be used in the tree
    class Node<T extends Comparable> implements Comparable{
        public T data;
        public Node<T> left;
        public Node<T> right;
        
        public Node(T _obj){
            data = _obj;
            left = null;
            right = null;
        }
                
        @Override
        public int compareTo(Object obj){
            return data.compareTo((T)obj);
        }
        
        public void insert(T obj, Node<T> tree){
            if(tree.compareTo(obj) >= 0){
                if(tree.left == null)
                    tree.left = new Node<>(obj);
                else
                    insert(obj, tree.left);
            }
            else{
                if(tree.right == null)
                    tree.right = new Node<>(obj);
                else
                    insert(obj, tree.right);
            }
        }
    }
    
    /**
     * Create an empty binary tree 
     */
    public BinaryTree(){
        root = null;
    }
    
    /**
     * Print the tree in order
     */
    public void inOrder(){
        recInOrder(root);
    }
    private void recInOrder(Node<T> node){
        if(node != null){
            recInOrder(node.left);
            System.out.print(node.data.toString() + " ");
            recInOrder(node.right);
        }
    }
    
    /**
     * Print the tree pre-order
     */ 
    public void preOrder(){
        recPreOrder(root);
    }
    private void recPreOrder(Node<T> node){
        if(node != null){
            System.out.print(node.data.toString() + " ");
            recPreOrder(node.left);
            recPreOrder(node.right);
        }
    }
    
    /** 
     * Print the tree post-order
     */ 
    public void postOrder(){
        recPostOrder(root);
    }
    private void recPostOrder(Node<T> node){
        if(node != null){
            recPostOrder(node.left);
            recPostOrder(node.right);
            System.out.print(node.data.toString() + " ");
        }
    }
    
    /**
     * Recursively search for and return a reference to obj if it exist
     * null otherwise
     * @return reference to object in tree if it exist, null otherwise
     */ 
    public T recSearch(T obj){
        return recSearch(obj, root);
    }
    // recursive search for node. Does the actual work
    private T recSearch(T obj, Node<T> tree){
        if(tree == null || tree.compareTo(obj) == 0){
            return tree.data;
        }
        if(tree.compareTo(obj) < 0){
            return recSearch(obj, tree.right);
        }
        return recSearch(obj, tree.left);
    }
    
    /**
     * Iterative search for and return a reference to obj if it exist
     * null otherwise
     * @return reference to object in tree if it exist, null otherwise
     */ 
    public T itSearch(T obj){
        Node<T> tmp = root;
        while(tmp != null || tmp.compareTo(obj) != 0){
            tmp = (tmp.compareTo(obj) < 0)?tmp.right:tmp.left;
        }
        if(tmp != null)
            return tmp.data;
        return null;
    }
    
    /** 
     * Find the minimum height
     */ 
    public int minHeight(){
        return recMinHeight(root);
    } 
    private int recMinHeight(Node<T> tree){
        if(tree == null){
            return 0;
        }
        return 1 + Math.min(recMinHeight(tree.left),recMinHeight(tree.right));
    }
    
    /**
     * Find height of tree
     */ 
    public int maxHeight(){
        return recMaxHeight(root);
    }
    private int recMaxHeight(Node<T> tree){
        if(tree == null)
            return 0;
        return 1 + Math.max(recMaxHeight(tree.left),recMaxHeight(tree.right));
    }
    
    /**
     * Recursively insert obj into the tree 
     * @param obj to insert to the tree 
     */
    public void insert(T obj){
        if(root == null)
            root = new Node<>(obj);
        else
            root.insert(obj, root);
    }
    
    /**
     * Iteratively insert obj into the tree
     * @param obj to insert to the tree
     */
    public void itInsert(T obj){
        Node<T> nextNode = null,currentNode = root;
        int direction = 0;
        if(currentNode == null){
            root = new Node<>(obj);
            return;
        }
        while(true){
            nextNode = (currentNode.compareTo(obj) < 0)?currentNode.right:currentNode.left;
            if(nextNode == null){
                direction = (currentNode.compareTo(obj) < 0)?1:0;
                break;
            }
            currentNode = nextNode;
        }
        if(direction == 0){
            currentNode.left = new Node<>(obj);
        }
        else{
            currentNode.right = new Node<>(obj);
        }
    }
    
    /**
     * Print tree level by level
     */ 
    public void printLevel(){
        // check if tree is empty
        if(root == null)
            return;
        LinkedList<Node<T>> que = new LinkedList<>();
        Node<T> currentNode;
        int currentLevel = 1;
        int nextLevel = 0;
        que.add(root);
        while(!que.isEmpty()){
            currentNode = que.peekFirst();
            que.removeFirst();
            currentLevel--;
            if(currentNode != null){
                que.add(currentNode.left);
                que.add(currentNode.right);
                nextLevel+=2;
                System.out.print(currentNode.data.toString() + " ");
            }
            if(currentLevel == 0){
                System.out.println();
                currentLevel = nextLevel;
                nextLevel = 0;
            }
        }
    }
    
    /**
     * Remove obj from tree
     * @param obj to be removed from tree
     */
    public void remove(T obj){
        // check for null root
        if(root == null)
            return;
        Node<T> parent = null;
        Node<T> successor = null;
        Node<T> it = root;
        // find node to delete
        while(true){
            if(it == null)
                return;
            else if(it.compareTo(obj) == 0)
                break;
            parent = it;
            it = (it.compareTo(obj) < 0)?it.right:it.left;
        }
        
        // node to delete has two children
        if(it.left != null && it.right != null){
            // find successor
            parent = it;
            successor = it.right;
            while(successor.left != null){
                parent = successor;
                successor = successor.left;
            }
            
            // put successor info in place of node to delete
            it.data = successor.data;
            // remove successor
            if(parent.right == successor){
                parent.right = successor.right;
            }
            else{
                parent.left = successor.right;
            }           
        }
        // node to delete has only one child
        else{
            // pick non null direction
            
            // if parent is null, we are trying to delete the root node
            if(parent == null){
                root = (it.left == null)?it.right:it.left;
            }
            // if node to delete is on parent right
            // parent.right now points to non null direction
            // of node to delete
            else if(parent.right == it){
                    parent.right = (it.left == null)?it.right:it.left;
            }
            // node to delete is on left so parent.left
            // is equal to the non null direction of
            // the node to delete
            else{
                parent.left = (it.left == null)?it.right:it.left;    
            }
        }
    }
}
