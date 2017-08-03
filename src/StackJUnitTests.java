import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;

public class StackJUnitTests {
    
    private static final int SIZE_EMPTY = 0;
    private static final int SIZE_ONE = 1;
    private static final int SIZE_TWO = 2;
    
    private static final Integer FIRST_PUSHED_ELEMENT = 14;
    private static final Integer SECOND_PUSHED_ELEMENT = 11;
    
    Stack<Integer> intStack = new Stack<>();
    
    @Test
    public void testEmptyStackSize() {
        assertEquals(SIZE_EMPTY, intStack.size());
    }
    
    @Test
    public void testPushOneElement() {
        intStack.push(FIRST_PUSHED_ELEMENT);
        assertEquals(SIZE_ONE, intStack.size());
    }
    
    @Test
    public void testPushTwoElements() {
        intStack.push(FIRST_PUSHED_ELEMENT);
        intStack.push(SECOND_PUSHED_ELEMENT);
        assertEquals(SIZE_TWO, intStack.size());
    }
    
    @Test
    public void testPopElements() {
        intStack.push(FIRST_PUSHED_ELEMENT);
        intStack.push(SECOND_PUSHED_ELEMENT);
        assertEquals(SECOND_PUSHED_ELEMENT, intStack.pop());
        assertEquals(FIRST_PUSHED_ELEMENT, intStack.pop());
        assertEquals(SIZE_EMPTY, intStack.size());
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testPopEmptyStack() {
        intStack.pop();
    }
    
}
