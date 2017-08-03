import java.util.Iterator;
import java.util.NoSuchElementException;

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
    
    public int size() {
        return queueSize;
    }
    
    public boolean isEmpty() {
        return queueSize == 0;
    }
    
    /**
     * Inserts an item onto the end of the Linked List queue.
     * 
     * @param item  Item to insert
     */
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item to queue.");
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
        queueSize++;
    }
    

    /**
     * Removes an item from the start of the Linked List queue.
     * 
     * @return  Item removed
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty, can't remove an item.");
        }
        Item item = first.item;
        first = first.next;
        queueSize--;
        return item;
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
    
    public static void main(String[] args) {
        Queue<Integer> intQueue = new Queue<>();
        int numberToAdd = 20;
        
        System.out.println("Size before adding anything: " + intQueue.size());
        System.out.println("Queue is empty: " + intQueue.isEmpty());
        
        for (int i = 0; i < numberToAdd; i++) {
            intQueue.enqueue(i);
        }
        
        System.out.println("\nSize after add " + numberToAdd + " ints: " + intQueue.size());
        System.out.println("Queue is empty: " + intQueue.isEmpty());
        
        System.out.println("\nNow lets see all contents in the queue: ");
        Iterator<Integer> queueIterator = intQueue.iterator();
        
        while (queueIterator.hasNext()) {
            System.out.println(queueIterator.next());
        }
        
        System.out.println("Queue size still: " + intQueue.size());
        System.out.println("Queue is empty: " + intQueue.isEmpty());
        
        System.out.println("\nNow dequeue the whole queue:");
        
        for (int i = 0; i < numberToAdd; i++) {
            System.out.println(intQueue.dequeue());
        }
        
        System.out.println("Queue size: " + intQueue.size());
        System.out.println("Queue is empty: " + intQueue.isEmpty());
    }
    
}
