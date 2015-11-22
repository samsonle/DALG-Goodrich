import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by samso on 2015-11-01.
 */
public class ArrayStack<E> implements Stack<E> {
    static final int CAPACITY = 1000;
    private E[] data;
    private int index = -1;

    public ArrayStack() { this(CAPACITY); }
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return index + 1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == CAPACITY) throw new IllegalStateException("Stack is full");
        data[++index] = e;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[index];
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E ret = data[index];
        data[index] = null;
        index--;
        return ret;
    }

    public static <E> void reverse(E[] a) {
        Stack<E> buffer = new ArrayStack<>(a.length);
        for (int i = 0; i < a.length; i++)
            buffer.push(a[i]);
        for (int i = 0; i < a.length; i++)
            a[i] = buffer.pop();

    }

    public static void main(String[] args) {
        Stack<Integer> S = new ArrayStack<>(); // contents: ()
        S.push(5); // contents: (5)
        S.push(3); // contents: (5, 3)
        System.out.println(S.size()); // contents: (5, 3) outputs 2
        System.out.println(S.pop()); // contents: (5) outputs 3
        System.out.println(S.isEmpty()); // contents: (5) outputs false
        System.out.println(S.pop()); // contents: () outputs 5
        System.out.println(S.isEmpty()); // contents: () outputs true
        System.out.println(S.pop()); // contents: () outputs null
        S.push(7); // contents: (7)
        S.push(9); // contents: (7, 9)
        System.out.println(S.top()); // contents: (7, 9) outputs 9
        S.push(4); // contents: (7, 9, 4)
        System.out.println(S.size()); // contents: (7, 9, 4) outputs 3
        System.out.println(S.pop()); // contents: (7, 9) outputs 4
        S.push(6); // contents: (7, 9, 6)
        S.push(8); // contents: (7, 9, 6, 8)
        System.out.println(S.pop());

        Integer[] a = {4, 8, 15, 16, 23, 42};
        String[] s = {"Jack", "Kate", "Hurley", "Jin", "Michael"};
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
        reverse(a);
        reverse(s);
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
    }
}
