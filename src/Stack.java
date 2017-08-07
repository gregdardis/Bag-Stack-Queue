import java.util.Iterator;
import java.util.NoSuchElementException;

import LinkedList.DataIterator;

/**
 * This class is a Linked List implementation of the stack data structure, which can hold any
 * object or primitive. The wrapper classes must be used for primitives. 
 * 
 * This stack has methods to return the size, whether or not it is empty, pushing an
 * item to the stack, or popping an item off the stack (LIFO - last in first out).
 * It also has an iterator which can be used to see all contents of the stack.
 */
public class Stack<Item> implements Iterable<Item> {

    LinkedList<Item> list = new LinkedList<>();
    
    public Stack() {
        list.first = null;
        list.size = 0;
    }
    
    public int size() {
        return list.size();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public Iterator<Item> iterator() {
        return list.iterator();
    }
    
    /**
     * Pushes an item to the front of the Linked List stack.
     * 
     * @param item  Item to push
     */
    public void push(Item item) {
        list.addToFront(item);
    }
    
    /**
     * Pops an item from the front of the Linked List stack.
     * 
     * @return  Item popped off the stack
     */
    public Item pop() {
        return list.removeFirst();
    }
    
    /** Non JUnit testing while implementing */
    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
        int numberToAdd = 20;
        
        System.out.println("Size before adding anything: " + intStack.size());
        System.out.println("Stack is empty: " + intStack.isEmpty());
        
        for (int i = 0; i < numberToAdd; i++) {
            intStack.push(i);
        }
        
        System.out.println("\nSize after pushing " + numberToAdd + " ints: " + intStack.size());
        System.out.println("Stack is empty: " + intStack.isEmpty());
        
        System.out.println("\nNow lets see all contents in the stack: ");
        Iterator<Integer> stackIterator = intStack.iterator();
        
        while (stackIterator.hasNext()) {
            System.out.println(stackIterator.next());
        }
        
        System.out.println("Stack size still: " + intStack.size());
        System.out.println("Stack is empty: " + intStack.isEmpty());
        
        System.out.println("\nNow pop off the whole stack:");
        
        for (int i = 0; i < numberToAdd; i++) {
            System.out.println(intStack.pop());
        }
        
        System.out.println("Stack size: " + intStack.size());
        System.out.println("Stack is empty: " + intStack.isEmpty());
    }
}
