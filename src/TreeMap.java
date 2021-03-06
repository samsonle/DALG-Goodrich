//import java.util.Comparator;
//
///**
// * Created by samle75 on 11/8/15.
// */
//
//public class TreeMap<K, V> extends AbstractSortedMap<K, V> {
//    protected BalanceableBinaryTree<K, V> tree = new BalanceableBinaryTree<>();
//
//    public TreeMap() {
//        super();
//        tree.addRoot(null);
//    }
//
//    public TreeMap(Comparator<K> comp) {
//        super(comp);
//        tree.addRoot(null);
//    }
//
//    public int size() {
//        return (tree.size() - 1) / 2;
//    }
//
//    private void expandExternal(Position<Entry<K, V>> p, Entry<K, V> entry) {
//        tree.set(p, entry);
//        tree.addLeft(p, null);
//        tree.addRight(p, null);
//    }
//
//    protected Position<Entry<K, V>> root() { return tree.root(); }
//
//    private Position<Entry<K, V>> treeSearch(Position<Entry<K, V>> p, K key) {
//        if (isExternal(p))
//            return p;
//        int comp = compare(key, p.getElement());
//        if (comp == 0)
//            return p;
//        else if (comp < 0)
//            return treeSearch(left(p), key);
//        else
//            return treeSearch(right(p), key);
//    }
//
//    public V get(K key) throws IllegalArgumentException {
//        checkKey(key);
//        Position<Entry<K, V>> p = treeSearch(root(), key);
//        rebalanceAccess(p);
//        if (isExternal(p)) return null;
//        return p.getElement().getValue();
//    }
//
//    public V put(K key, V value) throws IllegalArgumentException {
//        checkKey(key);
//        Entry<K, V> newEntry = new MapEntry<>(key, value);
//        Position<Entry<K, V>> p = treeSearch(root(), key);
//        if (isExternal(p)) {
//            expandExternal(p, newEntry);
//            rebalanceInsert(p);
//            return null;
//        } else {
//            V old = p.getElement().getValue();
//            set(p, newEntry);
//            rebalanceAccess(p);
//            return old;
//        }
//    }
//
//    public V remove(K key) throws IllegalArgumentException {
//        checkKey(key);
//        Position<Entry<K, V>> p = treeSearch(root(), key);
//        if (isExternal(p)) {
//            rebalanceAccess(p);
//            return null;
//        } else {
//            V old = p.getElement().getVale();
//            if (isInternal(left(p)) && isInternal(right(p))) {
//                Position<Entry<K, V>> replacement = treeMax(left(p));
//                set(p, replacement.getElement());
//                p = replacement;
//            }
//            Position<Entry<K, V>> leaf = (isExternal(left(p)) ? left(p) : right(p));
//            Position<Entry<K, V>> sib = sibling(leaf);
//            remove(leaf);
//            remove(p);
//            rebalanceDelete(sib);
//            return old;
//        }
//    }
//
//    protected Position<Entry<K, V>> treeMax(Position<Entry<K, V>> p) {
//        Position<Entry<K, V>> walk = p;
//        while (isInternal(walk))
//            walk = right(walk);
//        return parent(walk);
//    }
//
//    public Entry<K,V> lastEntry() {
//        if (isEmpty()) return null;
//        return treeMax(root()).getElement();
//    }
//
//    public Entry<K, V> floorEntry(K key) throws IllegalArgumentException {
//        checkKey(key);
//        Position<Entry<K, V>> p = treeSearch(root(), key);
//        if (isInternal(p)) return p.getElement();
//        while (!isRoot(p)) {
//            if (p == right(parent(p)))
//                return parent(p).getElement();
//            else
//                p = parent(p);
//        }
//        return null;
//    }
//
//    private Iterable<Entry<K, V>> entrySet() {
//        ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());
//        for (Position<Entry<K, V>> p : tree.inorder())
//            if (isInternal(p)) buffer.add(p.getElement());
//        return buffer;
//    }
//
//    public Iterable<Entry<K, V>> subMap(K fromKey, K toKey) {
//        ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());
//        if (compare(fromKey, toKey) < 0)
//            subMapRecurse(fromKey, toKey, root(), buffer);
//        return buffer;
//    }
//
//    private void subMapRecurse(K fromKey, K toKey, Position<Entry<K, V>> p, ArrayList<Entry<K, V>> buffer) {
//        if (isInternal(p))
//            if (compare(p.getElement(), fromKey) < 0)
//                subMapRecurse(fromKey, toKey, right(p), buffer);
//            else {
//                subMapRecurse(fromKey, toKey, left(p), buffer);
//                if (compare(p.getElement(), toKey) < 0) {
//                    buffer.add(p.getElement());
//                    subMapRecurse(fromKey, toKey, right(p), buffer);
//                }
//            }
//    }
//}
