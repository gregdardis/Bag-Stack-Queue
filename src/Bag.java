import java.util.Iterator;

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
    
    // size()
    // isEmpty()
    // add()
    
    public Iterator<Item> iterator() {
        return new BagIterator();
    }
    
    private class BagIterator implements Iterator<Item> {
        
        private Node current = first;
        
        public Item next() {
            
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
        // next
        // hasNext
        // remove throws exception
    }
}
