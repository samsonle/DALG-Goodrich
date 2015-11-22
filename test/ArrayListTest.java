import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.rules.ExpectedException;

/**
 * Created by samle75 on 11/21/15.
 */
public class ArrayListTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();


    ArrayList<Integer> al;
    @Before
    public void setUp() throws Exception {
        al = new ArrayList<>();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void zeroSizeEmptyList() {
        assertTrue(al.isEmpty());
        assertEquals(0, al.size());
    }

    @Test
    public void oneElementListTestingIsEmpty() {
        al.add(0, 1);
        assertFalse(al.isEmpty());
    }

    @Test
    public void oneElementListTestingSize() {
        al.add(0, 1);
        assertEquals(1, al.size());
    }

    @Test
    public void addThenRemoveElementTestingIsEmpty() {
        al.add(0, 1);
        al.remove(1);
        assertTrue(al.isEmpty());
    }

    @Test
    public void addOneTestingZeroIndex() {
        al.add(0, 1);
        assertEquals(1, (int) al.get(0));
    }

    @Test
    public void addTwoElementGetIndexOne() {
        al.add(0, 1);
        al.add(1, 2);
        assertEquals(2, (int) al.get(1));
    }

    @Test
    public void addOneSetOneGetOne() {
        al.add(0, 1);
        al.set(0, 2);
        assertEquals(2, (int) al.get(0));
    }

    @Test
    public void indexOutOfBoundException() {
        thrown.expect(IndexOutOfBoundsException.class);
        al.add(2,0);
    }

    @Test
    public void indexNegativeOutOfBoundException() {
        thrown.expect(IndexOutOfBoundsException.class);
        al.add(-1, 2);
    }

    @Test
    public void addFirstGetSecond() {
        al.add(0, 1);
        al.add(0, 2);
        assertEquals(1, (int)al.get(1));
    }

    @Test
    public void removeFirst() {
        al.add(0, 1);
        assertEquals(1, (int)al.remove(0));
    }
}