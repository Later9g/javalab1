package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс MyList реализует односвязный список и все его основные методы
 *
 * @param <T> тип данных использующийся при работе с классом
 *
 * @author danila */
public class MyList<T>{

    private Node head;
    private int size;

    private class Node <T>{
        private T value;
        private Node next;

        public Node(T t){
            value = t;
            next = null;
        }

        @Override
        public String toString() {
            return " " + value;
        }
    }

    /**
     * Конструктором по умолчанию
     *
     * @example <p>Пример использования конструктора:
     *      <pre>{@code
     *           MyList list = new MyList();
     *      }</pre>
     * */
    public MyList(){
        head = null;
        size = 0;
    }

    /**
     * Конструктором с одним параметром
     *
     * @param t - принимает любой тип данных
     *
     * @example <p>Пример использования конструктора:
     *      <pre>{@code
     *           MyList list = new MyList(1);
     *      }</pre>
     * */
    public MyList(T t){
        try {
            head = new Node<>(t);
            size = 1;
        }catch (NullPointerException e){
            System.err.println("Null вставлять нечестно, будем считать что список пуст!");

            head = null;
            size = 0;
        }
    }

    /**
     * Конструктор, который позволяет преобразовывать массив в список
     *
     * @param t - приминает массив
     *
     * @example <p>Пример использования конструктора:
     *            <pre>{@code
     *                  Integer[] i = {1,2,3,4,5,6,7,8};
     *                  MyList<Integer> list = new MyList<>(i);
     *            }</pre>
     * */
    public MyList(T[] t){
        try{
            for(T i: t){
                add(i);
            }
        }catch(NullPointerException e){
            head = null;
            size = 0;
        }

    }


    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            @SuppressWarnings("unchecked")
            T value = (T) current.value; // не очень понятно, почему он просит меня кастить к T, ведь value имеет тип T
            current = current.next;
            return value;
        }
    }

    /**
     * С помощью метода add можно добавить значение в список
     *
     * @param t - элемент, который требуется добавить
     * */
    public void add(T t) {
        if (t == null) {
            throw new NullPointerException("null вставлять нельзя!");
        }

        if (head != null) {
            Node h1 = head;

            while (h1.next != null) {
                h1 = h1.next;
            }

            h1.next = new Node<>(t);
        } else {
            head = new Node<>(t);
        }
        size += 1;

    }

    /** Метод добавляет значение T на позицию index */
    public void add(T t, int index) {
            if (index > size - 1 || index < 0) {
                throw new NoSuchElementException("Индекс выходит за границы списка!");
            }
            else if(t == null){
                throw new NullPointerException("null вставлять нельзя!");
            }

            Node current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node next = current.next;
            Node value = new Node<>(t);

            current.next = value;
            value.next = next;

            size += 1;
    }
    /**
     * Метод contains проверяет, содержит ли список необходимый элемент
     *
     * @param t - искомый элемент
     *
     * @return True, если искомый элемент содержится в списке. False, если искомого элемента нет
     **/
    public boolean contains(T t){
        Node h1 = head;

        do{
            if(h1.value == t){
                return true;
            }
            h1 = h1.next;
        }while (h1 != null);
        return false;
    }

    /**
     * Метод set заменяет элемент по указанному индексу новым элементом.
     *
     * @param index - индекс элемента, которй необходимо заменить.
     *
     * @param element - значение, которое необходимо вставить.
     * */
    public void set(T element, int index){

        if(index > size - 1 || index < 0) {
            throw new NoSuchElementException("Индекс выходит за границы списка!");
        }

        int i = 0;
        Node h1 = head;

        while(i < index){
            h1 = h1.next;
            i++;
        }
        h1.value = element;
    }

    /**
     * Метод remove используется когда необходимо удалить 1 элемент в списке
     *
     * @param index - индекс элемента, который требуется удалить*/
    public void remove(int index) {

        if (index > size - 1 || index < 0) {
            throw new NoSuchElementException("Индекс выходит за границы списка!");
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            current.next = current.next.next;
        }
        size--;
    }

    /**
     * Метод deleteType удаляет все переменные в списке,
     * значение которых совпадает со значением указанном в агрументе метода
     *
     * @param t - значение, которое будет искать метод*/
    public void removeType(T t) {


        if (head == null) {
            throw new NullPointerException("Список пуст!");
        }
        int countOfDeleted = 0;

        Node current = head;
        Node prev = null;

        do {
            if (current.value != t) {
                prev = current;
                current = current.next;
            } else {
                if (prev != null) {
                    prev.next = current.next;
                    current = current.next;
                } else {
                    head = head.next;
                }

                countOfDeleted += 1;
            }
        } while (current != null);

        if (countOfDeleted != 0) {
            System.out.println("Удалено " + countOfDeleted + " переменных!");
        } else {
            System.out.println("В списке таких значений нету");
        }

        size -= countOfDeleted;

    }

    /**
     * Метод принт выводит все элементы списка в строку
     * */
    public void print() {

        if (head == null) {
            throw new NullPointerException("Список пуст!");
        }

        Node h1 = head;

        do {
            System.out.print(h1.value + " ");
            h1 = h1.next;
        } while (h1 != null);

        System.out.println();

    }

    /**Метод size показывает текущий размер списка*/
    public int size(){
        return size;
    }

    /**Метод isEmpty нужен для проверки списка на пустоту*/
    public boolean isEmpty(){
        return head == null;
    }

    /**Метод clear чистит весь список*/
    public void clear(){
        head = null;
        size = 0;
    }

}
