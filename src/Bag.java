import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class is a Linked List implementation of the bag data structure, which can hold any
 * object or primitive. The wrapper classes must be used for primitives. 
 * 
 * This bag has methods to return the size, whether or not it is empty, or to add an
 * item to the bag. It also has an iterator which can be used to see all contents
 * of the bag.
 * 
 * @author Greg Dardis
 */
public class Bag<Item> implements Iterable<Item> {

    private Node first;
    
    private int bagSize;
    
    private class Node {
        private Item item;
        private Node next;
    }
    
    public Bag() {
        bagSize = 0;
        first = null;
    }
    
    public int size() {
        return bagSize;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void add(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item to bag.");
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
        bagSize++;
    }
    
    public Iterator<Item> iterator() {
        return new BagIterator();
    }
    
    private class BagIterator implements Iterator<Item> {
        
        private Node current = first;
        
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        public boolean hasNext() {
            return current != null;
        }
        
        public void remove() {
            throw new UnsupportedOperationException("Remove method can be buggy so it is not implemented in this bag iterator.");
        }
    }
    
    /** Non JUnit testing while implementing */
    public static void main(String[] args) {
        Bag<Integer> intBag = new Bag<>();
        int numberToAdd = 20;
        
        System.out.println("Size before adding anything: " + intBag.size());
        System.out.println("Bag is empty: " + intBag.isEmpty());
        
        for (int i = 0; i < numberToAdd; i++) {
            intBag.add(i);
        }
        
        System.out.println("Size after adding " + numberToAdd + " ints: " + intBag.size());
        System.out.println("Bag is empty: " + intBag.isEmpty());
        Iterator<Integer> bagIterator = intBag.iterator();
        
        System.out.println("\nNow lets see all contents in the bag:");
        while (bagIterator.hasNext()) {
            System.out.println(bagIterator.next());
        }
        
        System.out.println("Bag size still: " + intBag.size());
        System.out.println("Bag is empty: " + intBag.isEmpty());
    }
}
