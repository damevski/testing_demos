import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IteratorTest {

    private List<String> list;
    private Iterator<String> iter;

    @BeforeEach
    public void setupFixture()
    {
        list = new ArrayList<String>();
        list.add("cat");
        list.add("dog");
        iter = list.iterator();
    }

    //T,T,T,T
    @Test
    public void testBaseCase()
    {
        assertTrue(iter.hasNext());
        String c = iter.next();
        assertEquals("cat",c);
        iter.remove();
        assertFalse(list.contains("cat"));
    }

    //T,F,T,T
    @Test
    public void testRemove_C2()
    {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add(null);
        Iterator<String> iter2 = list2.iterator();
        assertNull(iter2.next());
    }

    //T,T,F,T
    @Test
    public void testRemove_C3()
    {
        assertThrows(UnsupportedOperationException.class, () -> {
            list = Collections.unmodifiableList(list);
            iter = list.iterator();
            iter.next();
            iter.remove();
        });
    }

    //T,T,T,F
    @Test
    public void testRemove_C4()
    {
        assertThrows(IllegalStateException.class, () -> {
            iter.remove();
        });
    }



}
