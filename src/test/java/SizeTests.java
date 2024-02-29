import org.example.MyList;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SizeTests {

    private Integer[] a;
    @Before
    public void init(){
        a = new Integer[] {1,2,3,4,5,6,7};
    }

    //Проверка, что метод size верно выводит размер пустого списка
    @Test
    public void testSizeWhenListIsEmpty(){
        MyList list = new MyList();

        assertEquals(0,list.size());
    }

    //Проверка, что метод size верно выводит размер списка из одного элемента
    @Test
    public void testSizeWithOneElementInList(){
        MyList<Integer> list = new MyList<>(1);

        assertEquals(1,list.size());
    }

    //Проверка, что метод size верно выводит размер списка с переданным в него массивом
    @Test
    public void testSizeWithArrayInside(){
        MyList<Integer> list = new MyList<>(a);
        assertEquals(7,list.size());
    }

    //Проверка, что метод size верно выводит размер списка, после удаления элемента
    @Test
    public void testSizeAfterRemovingOneElement(){
        MyList<Integer> list = new MyList<>(a);

        list.remove(2);

        assertEquals(6,list.size());
    }

    //Проверка, что метод size верно выводит размер списка после удаления нескольких элементов
    @Test
    public void testSizeAfterRemovingType(){
        Integer[] b = {1,2,3,4,5,4,4,5,8,9};

        MyList<Integer> list = new MyList<>(b);

        list.removeType(4);

        assertEquals(7, list.size());
    }
}
