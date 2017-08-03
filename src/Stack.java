import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class is a Linked List implementation of the stack data structure, which can hold any
 * object or primitive. The wrapper classes must be used for primitives. 
 * 
 * This stack has methods to return the size, whether or not it is empty, pushing an
 * item to the stack, or popping an item off the stack.
 * It also has an iterator which can be used to see all contents of the bag.
 */
public class Stack<Item> implements Iterable<Item> {

    private Node first;
    private int stackSize;
    
    private class Node {
        Item item;
        Node next;
    }
    
    public Stack() {
        first = null;
        stackSize = 0;
    }
    
    public int size() {
        return stackSize;
    }
    
    public boolean isEmpty() {
        return stackSize == 0;
    }
    
    public void push(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot push null item to stack.");
        }
        if (isEmpty()) {
            first = new Node();
            first.item = item;
        } else {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
        }
        stackSize++;
    }
    
    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty, can't pop anything off.");
        }
        Item item = first.item;
        first = first.next;
        stackSize--;
        return item;
    }
    
    public Iterator<Item> iterator() {
        return new StackIterator();
    }
    
    private class StackIterator implements Iterator<Item> {
        
        private Node current = first;
        
        public Item next() {
            Item currentItem = current.item;
            current = current.next;
            return currentItem;
        }
        
        public boolean hasNext() {
            return current != null;
        }
        
        public void remove() {
            throw new UnsupportedOperationException("Remove method can be buggy so it is not implemented in this stack iterator.");
        }
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
