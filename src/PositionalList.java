/**
 * Created by samso on 2015-11-22.
 */
public interface PositionalList<E> {
    /**
     * Return number of elements in List
     */
    int size();

    /**
     * Return if list is empty
     */
    boolean isEmpty();

    /**
     * Return the first Position in list or null if empty
     */
    Position<E> first();

    /**
     * Return the last Position in list or null if empty
     */
    Position<E> last();

    /**
     * Return the Position immediately before Position p or null if p is first
     */
    Position<E> before(Position<E> p) throws IllegalArgumentException;

    /**
     * Return the Position immediately after Position p or null if p is last
     */
    Position<E> after(Position<E> p) throws IllegalArgumentException;

    /**
     * Insert first then returns its new Position
     */
    Position<E> addFirst(E e);

    /**
     * Insert last then returns its new Position
     */
    Position<E> addLast(E e);

    /**
     * Insert e before Position p then return its new Position
     */
    Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Insert e after Position p then return its new Position
     */
    Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Replace the element stored at Position p and returns the replaced element
     */
    E set(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Remove the element at Position p and returns it (invalidate p)
     */
    E remove(Position<E> p) throws IllegalArgumentException;

    Iterable<Position<E>> positions();
}
