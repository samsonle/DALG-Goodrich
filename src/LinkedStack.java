/**
 * Created by samso on 2015-11-01.
 */
public class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public LinkedStack() {}

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E top() {
        return list.first();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    public static boolean isMatched(String expression) {
        final String opening = "({[";
        final String ending = ")}]";
        Stack<Character> s = new LinkedStack<>();
        for (char c : expression.toCharArray()) {
            if (opening.indexOf(c) != -1)
                s.push(c);
            else if (ending.indexOf(c) != -1) {
                if (s.isEmpty()) return false;
                if (ending.indexOf(c) != opening.indexOf(s.pop()))
                    return false;
            }
        }
        return s.isEmpty();
    }

    public static boolean isHTMLMatched(String html) {
        Stack<String> buffer = new LinkedStack<>();
        int j = html.indexOf('<');
        while (j != -1) {
            int k = html.indexOf('>', j + 1);
            if (k == -1) return false;
            String tag = html.substring(j + 1, k);
            if (!tag.startsWith("/")) buffer.push(tag);
            else {
                if (buffer.isEmpty()) return false;
                if (!tag.substring(1).equals(buffer.pop())) return false;
            }
            j = html.indexOf('<');
        }
        return buffer.isEmpty();
    }

}
