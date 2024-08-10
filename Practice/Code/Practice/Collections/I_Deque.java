
package Practice.Collections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class I_Deque {
    public static void main(String[] args) {
        Deque<Integer> d = new LinkedList<>();
        d.add(10);
        d.add(20);
        d.add(30);
        d.add(10);
        d.add(20);
        d.add(30);
        
        System.out.println(d);
        System.out.println("");
        
        // ByDefault from head/front FIFO
        System.out.println("Element: "+d.element());
        System.out.println(d);
        System.out.println("Peek: "+d.peek());
        System.out.println(d);
        System.out.println("Poll: "+d.poll());
        System.out.println(d);
        System.out.println("Remove: "+d.remove());
        System.out.println(d);
        
        d.addFirst(9);
        d.addLast(31);
        System.out.println(d);
        
        d.push(00);
        System.out.println(d);
        d.pop();
        System.out.println(d);
       d.remove(30);
        System.out.println(d);
        System.out.println(d.pop());
    }
}
