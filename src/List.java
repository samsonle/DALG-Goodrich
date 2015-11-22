/**
 * Created by samso on 2015-11-15.
 */
public interface List<E> {
    int size();

    boolean isEmpty();

    E get(int i) throws IndexOutOfBoundsException;
    E set(int i, E e) throws IndexOutOfBoundsException;

    void add(int i, E e) throws IndexOutOfBoundsException;
    E remove(int i) throws IndexOutOfBoundsException;
}
