import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by samso on 2015-11-15.
 */
public class ArrayList<E> implements List<E> {
    private static final int CAPACITY = 1000;
    private int size;
    private E[] data;

    private class ArrayIterator implements Iterator<E> {
        private int j = 0;
        private boolean removable = false;


        /**
         * Test if there are more elements in list
         *
         * @return true if more item in list
         */
        @Override
        public boolean hasNext() {
            return j < size;
        }

        /**
         * Return the next object in the iterator
         *
         * @return next object
         * @throws NoSuchElementException
         */
        @Override
        public E next() throws NoSuchElementException {
            if (j == size)
                throw new NoSuchElementException("No next element");
            removable = true;
            return data[j++];
        }

        /**
         * Removes the element returned by most recent call to next
         *
         * @throws IllegalStateException if next has not yet been called
         * @throws IllegalStateException if remove was already called since recent next
         */
        @Override
        public void remove() throws IllegalStateException {
            if (!removable)
                throw new IllegalStateException("nothing to remove");
            ArrayList.this.remove(j - 1);
            j--;
            removable = false;
        }
    }

    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    ArrayList() {
        this(CAPACITY);
    }

    ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException("index out of bound");
        return data[i];
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException("index out of bound");
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i > size) throw new IndexOutOfBoundsException("index out of bound");
        if (size == data.length) resize(2 * data.length);
        for (int j = size - 1; j >= i; j--)
            data[j + 1] = data[j];
        data[i] = e;
        size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i > size) throw new IndexOutOfBoundsException("index out of bound");
        E temp = data[i];
        for (int j = i; i < size - 1; j++)
            data[j] = data[j + 1];
        data[size - 1] = null;
        size--;
        return temp;
    }

    private class ArrayIterator implements Iterator<E> {
        private int j = 0;
        private boolean removable = false;


        /**
         * Test if there are more elements in list
         *
         * @return true if more item in list
         */
        @Override
        public boolean hasNext() {
            return j < size;
        }

        /**
         * Return the next object in the iterator
         *
         * @return next object
         * @throws NoSuchElementException
         */
        @Override
        public E next() throws NoSuchElementException {
            if (j == size)
                throw new NoSuchElementException("No next element");
            removable = true;
            return data[j++];
        }

        /**
         * Removes the element returned by most recent call to next
         *
         * @throws IllegalStateException if next has not yet been called
         * @throws IllegalStateException if remove was already called since recent next
         */
        @Override
        public void remove() throws IllegalStateException {
            if (!removable)
                throw new IllegalStateException("nothing to remove");
            ArrayList.this.remove(j - 1);
            j--;
            removable = false;
        }
    }    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++)
            temp[i] = data[i];
        data = temp;
    }
}
