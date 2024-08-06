package Practice.Collections;

import java.util.LinkedList;
import java.util.Queue;

public class H_Queue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(10);
        q.add(20);
        q.add(30);
        
        System.out.println(q);
        System.out.println("");
        
        System.out.println("Element: "+q.element());
        System.out.println(q);
        q.add(90);
        System.out.println("Peek: "+q.peek());
        System.out.println(q);
        System.out.println("Poll: "+q.poll());
        System.out.println(q);
        System.out.println("Remove: "+q.remove());
        System.out.println(q);
    }
}
