package Practice.Collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class A_Iterator {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(4,7,2,9,4);
        Iterator i = l.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
        System.out.println("");
        
        
        for(Integer lt:l){
            System.out.println(lt);
        }
    }
}
