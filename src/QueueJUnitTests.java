import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;

public class QueueJUnitTests implements JUnitConstants {

    Queue<Integer> intQueue = new Queue<>();
    
    @Test
    public void testEmptyQueueSize() {
        assertEquals(SIZE_EMPTY, intQueue.size());
    }
    
    @Test
    public void testAddOneElement() {
        intQueue.enqueue(FIRST_ELEMENT);
        assertEquals(SIZE_ONE, intQueue.size());
    }
    
    @Test
    public void testAddTwoElements() {
        intQueue.enqueue(FIRST_ELEMENT);
        intQueue.enqueue(SECOND_ELEMENT);
        assertEquals(SIZE_TWO, intQueue.size());
    }
    
    @Test
    public void testRemoveElements() {
        intQueue.enqueue(FIRST_ELEMENT);
        intQueue.enqueue(SECOND_ELEMENT);
        assertEquals(FIRST_ELEMENT, intQueue.dequeue());
        assertEquals(SECOND_ELEMENT, intQueue.dequeue());
        assertEquals(SIZE_EMPTY, intQueue.size());
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testRemoveFromEmptyQueue() {
        intQueue.dequeue();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddNull() {
        intQueue.enqueue(null);
    }
    
}
