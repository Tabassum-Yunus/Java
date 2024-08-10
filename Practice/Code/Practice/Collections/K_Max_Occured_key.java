package Practice.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class K_Max_Occured_key {
    public static void main(String[] args) {
        
    HashMap<String, Integer> hm = new HashMap<>(); 
    
        hm.put("Adil", 20);
        hm.put("Jerry", 5);
        hm.put("Oreo", 21);
        hm.put("Denny", 19);
        //System.out.println(hm);
        List<Integer> l = new ArrayList<>(hm.values());

        Collections.sort(l);
        int key=l.get(l.size()-1);


        //System.out.println(key);
        for (Map.Entry<String,Integer> m : hm.entrySet()) {
            if(m.getValue() == key)
                System.out.println("MAximium occured String "+ m.getKey()+" and times "+m.getValue());
        }
        System.out.println(l);
    }
}
