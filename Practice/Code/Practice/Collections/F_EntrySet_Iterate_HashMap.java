package Practice.Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class F_EntrySet_Iterate_HashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Tabassum", 1);
        hm.put("Jerry", 1);
        hm.put("Oreo", 1);
        hm.put("Denny", 1);
        hm.put("Cookie", 1);
        
        System.out.println(hm);
        
        System.out.println("");
       
        for(Map.Entry<String, Integer> m : hm.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
        
        System.out.println("");
        
        Set<String> s = hm.keySet();
        for(String i:s){
            System.out.println(i+" "+hm.get(i));
        }
    }
}
