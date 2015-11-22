/**
 * Created by samso on 2015-11-22.
 */
public interface Position<E> {
    /**
     * Returns the element stored at this position
     *
     * @return the stored element
     * @throws IllegalStateException if position no longer valid
     */
    E getElement() throws IllegalStateException;
}
