import org.example.MyList;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static junit.framework.TestCase.*;

public class SetTests {
    private MyList<Integer> list;

    @Before
    public void init(){
        Integer[] arr = {1,2,3,4,5,6,7};
        list = new MyList<>(arr);
    }

    //Проверка, что элемент действительно изменяется и не изменятся размер
    @Test
    public void testSetWithNotEmptyList(){
        int size = list.size();

        list.set(9,2);

        assertTrue(list.contains(9));
        assertFalse(list.contains(3));
        assertEquals(size,list.size());


    }

    //Действительно ли метод пробрасывает ошибку при неправильно указанном индексе
    @Test(expected = NoSuchElementException.class)
    public void testSetWithBadIndex(){
        list.set(1,10);
    }
}
