import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    private Node first;
    
    private class Node {
        Item item;
        Node next;
    }
    
    public Iterator<Item> iterator() {
        return new StackIterator();
    }
    
    private class StackIterator implements Iterator<Item> {
        
        private Node current = first;
        
        public Item next() {
            Item currentItem = current.item;
            current = current.next;
            return currentItem;
        }
        
        public boolean hasNext() {
            return current != null;
        }
        
        public void remove() {
            throw new UnsupportedOperationException("Remove method can be buggy so it is not implemented in this stack iterator.");
        }
    }
    
    public static void main(String[] args) {
        
    }
}
