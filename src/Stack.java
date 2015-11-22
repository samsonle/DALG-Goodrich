/**
 * Created by samso on 2015-11-01.
 */
public interface Stack<E> {
    int size();

    boolean isEmpty();

    void push(E e);

    E top();

    E pop();
}
