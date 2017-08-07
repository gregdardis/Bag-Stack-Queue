import java.util.Iterator;

/**
 * This class is a Linked List implementation of the queue data structure, which can hold any
 * object or primitive. The wrapper classes must be used for primitives. 
 * 
 * This queue has methods to return the size, whether or not it is empty, adding an
 * item to the back of the queue, or removing an item from the front of the queue (FIFO - first in first out).
 * It also has an iterator which can be used to see all contents of the queue.
 */
public class Queue<Item> implements Iterable<Item> {
    
    LinkedList<Item> list = new LinkedList<>();
    
    public int size() {
        return list.size();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    @Override
    public Iterator<Item> iterator() {
        return list.iterator();
    }
    
    /**
     * Inserts an item onto the end of the Linked List queue.
     * 
     * @param item  Item to insert
     */
    public void enqueue(Item item) {
        list.addToBack(item);
    }

    /**
     * Removes an item from the start of the Linked List queue.
     * 
     * @return  Item removed
     */
    public Item dequeue() {
        return list.removeFirst();
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
