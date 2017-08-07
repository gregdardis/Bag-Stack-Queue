import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class is a Linked List implementation of the bag data structure, which can hold any
 * object or primitive. The wrapper classes must be used for primitives. 
 * 
 * This bag has methods to return the size, whether or not it is empty, or to add an
 * item to the bag. It also has an iterator which can be used to see all contents
 * of the bag. There is no method implemented to remove an item from the bag.
 * 
 */
public class Bag<Item> extends LinkedList<Item> implements Iterable<Item> {
    
    public Bag() {
        size = 0;
        first = null;
    }
    
    public void add(Item item) {
        super.addToFront(item);
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
