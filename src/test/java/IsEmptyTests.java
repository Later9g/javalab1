import org.example.MyList;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class IsEmptyTests {
    @Test
    public void testTsEmptyWithEmptyList(){
        MyList list = new MyList<>();

        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyWithNotEmptyList(){
        MyList list = new MyList<>(1);

        assertFalse(list.isEmpty());
    }

    @Test
    public void testIsEmptyAfterRemovingAllElements() {
        Integer[] i = {1,2,3,4};
        MyList<Integer> list = new MyList<>(i);

        list.clear();

        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyAfterRemovingOneElement(){
        MyList<Integer> list = new MyList<>(1);

        list.remove(0);

        assertTrue(list.isEmpty());
    }
}
