import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    
    private Node first;
    private Node last;
    private int queueSize;
    
    public Queue() {
        first = null;
        last = null;
        queueSize = 0;
    }
    
    private class Node {
        Item item;
        Node next;
    }
    
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }
    
    private class QueueIterator implements Iterator<Item> {
        
        private Node current = first;
        
        public Item next() {
            Item nextItem = current.item;
            current = current.next;
            return nextItem;
        }
        
        public boolean hasNext() {
            return current != null;
        }
        
        public void remove() {
            throw new UnsupportedOperationException("Remove method can be buggy so it is not implemented in this queue iterator.");
        }
    }
    
}
