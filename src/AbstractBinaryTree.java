import java.util.ArrayList;
/**
 * Created by samso on 2015-12-05.
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if (parent == null) return null;
        if (p == left(parent))
            return right(p);
        else
            return left(parent);
    }

    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null)
            count++;
        if (right(p) != null)
            count++;
        return count;
    }

    public Iterable<Position<E>> children(Position<E> p) {
        ArrayList<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null)
            snapshot.add(0, right(p));
        if (right(p) != null)
            snapshot.add(right(p));
        return snapshot;
    }
}
