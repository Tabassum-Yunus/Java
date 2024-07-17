package Assignment;

import Practice.Collections.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Aq13_MergeList_Sorted {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = Arrays.asList(30,20,50);
        List<Integer> merge = new ArrayList<>();
        l1.add(20);
        l1.add(10);
        l1.add(9);
        merge.addAll(l1);
        merge.addAll(l2);
        Collections.sort(merge);
        System.out.println(merge);
    }
}
