import java.util.Iterator;
import java.util.NoSuchElementException;

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
        Bag<Integer> bag = new Bag<Integer>();
        int numberToAdd = 20;
        
        System.out.println("Size before adding anything: " + bag.size());
        System.out.println("It is empty: " + bag.isEmpty());
        for (int i = 0; i < numberToAdd; i++) {
            bag.add(i);
        }
        System.out.println("Size after adding " + numberToAdd + " ints: " + bag.size());
        System.out.println("It is empty: " + bag.isEmpty());
        Iterator<Integer> bagIterator = bag.iterator();
        
        System.out.println("\nNow lets see all contents in the bag:");
        while (bagIterator.hasNext()) {
            System.out.println(bagIterator.next());
        }
        
        System.out.println("Size still " + bag.size());
        System.out.println("It is empty: " + bag.isEmpty());
    }
}
