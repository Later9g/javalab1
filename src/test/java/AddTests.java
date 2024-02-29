import org.example.MyList;
import org.junit.Test;

import java.util.NoSuchElementException;

import static junit.framework.TestCase.*;

public class AddTests {
    //Проверка, что add корректно добавляет элемент в пустой список.
    @Test
    public void testAddInEmptyLint(){
        MyList list = new MyList<>();

        list.add(1);

        assertEquals(1,list.size());
        assertTrue(list.contains(1));
        assertFalse(list.isEmpty());
    }

    //Проверка, что add корректно добавляет элемент в список существующих элементов.
    @Test
    public void testAddInNotEmptyList(){
        Integer [] a = {1,2,3,4,5,6,7};

        MyList<Integer> list = new MyList(a);

        int size = list.size();

        list.add(8);

        assertEquals(size + 1, list.size());
        assertTrue(list.contains(8));
    }

    //Проверка, что add корректно добавляет элемент в список существующих элементов после заданного индекса
    @Test
    public void testAddWithIndexInNotEmptyList(){
        Integer [] a = {1,2,3,4,5,6,7};

        MyList<Integer> list = new MyList(a);

        int size = list.size();

        list.add(8,3);

        assertEquals(size + 1, list.size());
        assertTrue(list.contains(8));
    }

    //Проверка, что add пробрасывает ошибку, когда индекс указан неверно.
    @Test(expected = NoSuchElementException.class)
    public void testAddWithInvalidIndexException(){
        MyList myList = new MyList<>();

        myList.add(10,10);
    }

    //Проверка, что add пробрасывает ошибку, когда значение равно null.
    @Test(expected = NullPointerException.class)
    public void testAddWithNull() {
        MyList<Integer> myList = new MyList<>();

        myList.add(null);
    }

    //Проверка, что add с индексом пробрасывает ошибку, когда значение равно null.
    @Test(expected = NullPointerException.class)
    public void testAddWithIndexWithNull(){
        Integer[] arr = {1,2,3,4,5};

        MyList<Integer> list = new MyList<>(arr);

        list.add(null,2);
    }
}
