package test1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Algorithm349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(int e :nums1){
            set.add(e);
        }

        for (int e:nums2){
            if(set.contains(e)){
                set.remove(e);
                list.add(e);
            }
        }
        int [] res=new int[list.size()];
        for (int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
}
