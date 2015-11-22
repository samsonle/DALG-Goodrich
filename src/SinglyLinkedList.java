/**
 * Created by samle on 2015-10-30.
 */
public class SinglyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E elem) { this(elem, null); }
        public Node(E elem, Node<E> n) {
            element = elem;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {}
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(E elem) {
        head = new Node<E>(elem, head);
        if (isEmpty())
            tail = head;
        size++;
    }

    public void addLast(E elem) {
        Node<E> n = new Node<E>(elem);
        if (isEmpty())
            head = n;
        else
            tail.setNext(n);
        tail = n;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        E ret = head.getElement();
        head = head.getNext();
        size--;
        if (isEmpty()) tail = null;
        return ret;
    }
}
