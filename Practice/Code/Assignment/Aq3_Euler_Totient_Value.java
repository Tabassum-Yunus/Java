
package Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Aq3_Euler_Totient_Value {
    public static void main(String[] args) {
        int[] arr = {2,6,4,9,8,8,9,13,13};
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(!hm.containsKey(arr[i]))
                hm.put(arr[i], 1);
            else
                hm.put(arr[i], hm.get(arr[i])+1);
        }
        ArrayList<Integer> a = new ArrayList<>(hm.values());
        Collections.sort(a);
        
        int max_occ = a.get(a.size()-1);
        int key ;
        for(Map.Entry<Integer, Integer> m : hm.entrySet()){
            if(m.getValue() == max_occ){
                key = m.getKey();
                System.out.println("key: "+key);
                System.out.println("etv: "+rel_prime(key));
            }     
        }
    }
    public static int rel_prime(int n){
        int count=1;
        for (int i = 2; i < n; i++) {
            if(gcd(n,i)==1){
                count++;
            }
                
        }
        return count;
    }
 
    public static int gcd(int a,int b){
        int r=a%b;
        while(r!=0){
            a=b;
            b=r;
            r=a%b;    
        }
        return b;
    }
}
