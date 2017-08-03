import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BagJUnitTests {
    
    private static final int SIZE_EMPTY = 0;
    private static final int SIZE_ONE = 1;
    private static final int SIZE_TWO = 2;
    
    private static final int FIRST_ADDED_ELEMENT = 5;
    private static final int SECOND_ADDED_ELEMENT = 13;
    
    Bag<Integer> bag = new Bag<Integer>();
    
    @Test
    public void testBagSizeZero() {
        assertEquals(SIZE_EMPTY, bag.size());
    }
    
    @Test
    public void testBagIsEmpty() {
        assertEquals(true, bag.isEmpty());
    }
    
    @Test
    public void testBagIsNotEmpty() {
        bag.add(FIRST_ADDED_ELEMENT);
        assertEquals(false, bag.isEmpty());
    }
    
    @Test
    public void testBagSizeOne() {
        bag.add(FIRST_ADDED_ELEMENT);
        assertEquals(SIZE_ONE, bag.size());
    }
    
    @Test
    public void testBagSizeTwo() {
        bag.add(FIRST_ADDED_ELEMENT);
        bag.add(SECOND_ADDED_ELEMENT);
        assertEquals(SIZE_TWO, bag.size());
    }
}
