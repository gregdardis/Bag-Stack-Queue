import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BagJUnitTests {
    
    private static final int SIZE_EMPTY = 0;
    private static final int SIZE_ONE = 1;
    private static final int SIZE_TWO = 2;
    
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
        bag.add(5);
        assertEquals(false, bag.isEmpty());
    }
    
    @Test
    public void testBagSizeOne() {
        bag.add(5);
        assertEquals(SIZE_ONE, bag.size());
    }
    
    @Test
    public void testBagSizeTwo() {
        bag.add(5);
        bag.add(0);
        assertEquals(SIZE_TWO, bag.size());
    }
}
