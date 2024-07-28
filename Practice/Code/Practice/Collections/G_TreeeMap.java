package Practice.Collections;

import java.util.TreeMap;

public class G_TreeeMap {
    public static void main(String[] args) {
        TreeMap<Integer,String> tm = new TreeMap<>();
        tm.put(4, "cookie");
        tm.put(1, "tabassum");
        tm.put(3, "Oreo");
        tm.put(2, "Jerry");
        System.out.println(tm);
    }
}
