/**
 * Created by samle75 on 11/5/15.
 */
public class ArrayQueue<E> implements Queue<E> {
    static final int CAPACITY = 10000;
    private int size = 0;
    private int f = 0;
    private E[] data;

    public ArrayQueue() { this(CAPACITY); }
    public ArrayQueue(int capacity) {
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
    public void enqueue(E e) {
        if (size == data.length) return;
        data[(size + f) % data.length] = e;
        size++;
    }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return data[f];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E ret = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        size--;
        return null;
    }

    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public void p() {
        for (int i = 0; i < size; i++)
            System.out.print(data[(f + i) % data.length] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> aq = new ArrayQueue<>(5);
        System.out.println(aq.isEmpty());
        aq.enqueue(3);
        aq.enqueue(5);
        aq.print();
        System.out.println(aq.dequeue());
        aq.print();
        aq.p();
        aq.enqueue(1);
        aq.enqueue(2);
        aq.enqueue(3);
        aq.print();
        aq.p();
        aq.enqueue(6);
        aq.print();
        aq.p();

    }
}
