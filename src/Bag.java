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
            throw new UnsupportedOperationException();
        }
    }
    
    public static void main(String[] args) {
        // testing
    }
}
