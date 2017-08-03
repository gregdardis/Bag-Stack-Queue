import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;

public class StackJUnitTests implements JUnitConstants {
    
    Stack<Integer> intStack = new Stack<>();
    
    @Test
    public void testEmptyStackSize() {
        assertEquals(SIZE_EMPTY, intStack.size());
    }
    
    @Test
    public void testPushOneElement() {
        intStack.push(FIRST_ELEMENT);
        assertEquals(SIZE_ONE, intStack.size());
    }
    
    @Test
    public void testPushTwoElements() {
        intStack.push(FIRST_ELEMENT);
        intStack.push(SECOND_ELEMENT);
        assertEquals(SIZE_TWO, intStack.size());
    }
    
    @Test
    public void testPopElements() {
        intStack.push(FIRST_ELEMENT);
        intStack.push(SECOND_ELEMENT);
        assertEquals(SECOND_ELEMENT, intStack.pop());
        assertEquals(FIRST_ELEMENT, intStack.pop());
        assertEquals(SIZE_EMPTY, intStack.size());
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testPopEmptyStack() {
        intStack.pop();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testPushNull() {
        intStack.push(null);
    }
    
}
