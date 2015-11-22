/**
 * Created by samso on 2015-11-15.
 */
public class ArrayList<E> implements List<E> {
    private static final int CAPACITY = 1000;
    private int size;
    private E[] data;

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

    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++)
            temp[i] = data[i];
        data = temp;
    }
}
