import org.example.MyList;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class RemoveTests {
    private MyList<Integer> list;
    @Before
    public void init(){
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        list = new MyList<>(arr);
    }

    //Проверка, что remove удаляет необходимое значение
    @Test
    public void testRemoveRemovesRequiredValue(){
        int size = list.size();

        list.remove(3); //предполагаемое значение 4

        assertEquals(size - 1, list.size());
        assertFalse(list.contains(4));
    }

    //Проверка, что remove корректно удаляет первый элемент.
    @Test
    public void testRemoveRemovesFirstValue(){
        int size = list.size();

        list.remove(0); //предполагаемое значение 4

        assertEquals(size - 1, list.size());
        assertFalse(list.contains(1));
    }

    //Проверка, что remove обрабатывает исключение, когда индекс выходит за границы списка
    @Test(expected = NoSuchElementException.class)
    public void testRemoveIndexOutOfBoundsException(){
        list.remove(20);
    }

    //Проверка, что метод removeType действительно удаляет все элементы
    @Test
    public void testRemoveTypeRemovesCorrectly(){
        list.add(2);
        list.add(2);

        int size = list.size();

        list.removeType(2);

        assertEquals(size - 3, list.size());
        assertFalse(list.contains(2));
    }

    //Проверка метода на проброс ошибки при пустом списке
    @Test(expected = NullPointerException.class)
    public void testRemoveTypeInEmptyList(){
        list.clear();

        list.removeType(2);
    }
}
