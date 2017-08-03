import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BagJUnitTests implements JUnitConstants {

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
        bag.add(FIRST_ELEMENT);
        assertEquals(false, bag.isEmpty());
    }
    
    @Test
    public void testBagSizeOne() {
        bag.add(FIRST_ELEMENT);
        assertEquals(SIZE_ONE, bag.size());
    }
    
    @Test
    public void testBagSizeTwo() {
        bag.add(FIRST_ELEMENT);
        bag.add(SECOND_ELEMENT);
        assertEquals(SIZE_TWO, bag.size());
    }
}
