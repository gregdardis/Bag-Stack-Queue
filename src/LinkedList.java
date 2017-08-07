import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;
    
    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }
    
    private class Node {
        private Item item;
        private Node next;
    }

    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public Iterator<Item> iterator() {
        return new DataIterator();
    }
    
    /**
     * Inserts an item at the start of the Linked List.
     * 
     * @param item  Item to insert
     */
    public void addToFront(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item.");
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
        size++;
    }
    
    /**
     * Inserts an item onto the end of the Linked List.
     * 
     * @param item  Item to insert
     */
    public void addToBack(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item.");
        }
        if (isEmpty()) {
            last = new Node();
            last.item = item;
            first = last;
        } else {
            Node newLast = new Node();
            newLast.item = item;
            last.next = newLast;
            last = newLast;
        }
        size++;
    }
    
    /**
     * Removes an item from the start of the Linked List.
     * 
     * @return  Item removed    
     */
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty, can't remove an item.");
        }
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }
    
    private class DataIterator implements Iterator<Item> {
        
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
            throw new UnsupportedOperationException("Remove method can be buggy so it is not implemented in this iterator.");
        }
    }
    
}
