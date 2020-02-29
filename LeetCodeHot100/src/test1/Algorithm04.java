package test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Algorithm04 {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int index=nums1.length+nums2.length;
        double result=0;
        ArrayList<Integer> list =new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for (int val: nums2) {
            list.add(val);
        }
        Collections.sort(list);
        if(index%2==1){
            result=list.get(index/2);
        }else {
            result=((double)list.get(index/2)+(double)list.get((index/2)-1))/2;
        }
        return result;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index=nums1.length+nums2.length;
        double result=0;
        ArrayList<Integer> list =new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for (int val: nums2) {
            list.add(val);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1>o2)return 1;
                if(o2>o1)return -1;
                return 0;
            }
        });
        if(index%2==1){
            result=list.get(index/2);
        }else {
            result=((double)list.get(index/2)+(double)list.get((index/2)-1))/2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        int[] numss={4,7,9};
        ArrayList<Integer> list =new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        for (int val: numss) {
            list.add(val);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1>o2)return -1;
                if(o2>o1)return 1;
                return 0;
            }
        });
        Iterator<Integer> i=list.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
