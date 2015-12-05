import java.util.Comparator;

/**
 * Created by samso on 2015-12-05.
 */
public class StringLengthComparator implements Comparator<String> {
    public int compare(String a, String b) {
        if (a.length() < b.length()) return -1;
        else if (a.length() == b.length()) return 0;
        else return 1;
    }
}
