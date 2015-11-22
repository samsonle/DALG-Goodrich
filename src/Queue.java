/**
 * Created by samso on 2015-11-01.
 */
public interface Queue<E> {
    int size();

    boolean isEmpty();

    void enqueue(E e);

    E first();

    E dequeue();
}
