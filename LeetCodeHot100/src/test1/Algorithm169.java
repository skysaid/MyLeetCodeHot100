package test1;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Algorithm169 {
    public int majorityElement2(int[] nums) {
        int n=nums.length;
        if (n==1)return nums[0];
        Map<Integer,Integer> map= new TreeMap<>();
        int res=0;
        int count=0;

        for (int num:nums){
            if (map.containsKey(num)){
                if (res<map.get(num)+1){
                    res=map.get(num)+1;
                    count=num;
                }
                if (res>n/2)return num;
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        return count;
    }
    //不通过，实例里面有负数
    public int majorityElement3(int[] nums) {
        int n=nums.length;
        if (n==1)return nums[0];
        int max=0;
        for (int num:nums){
            max=Math.max(max,num);
        }
        int[] count=new int[max+1];
        for (int num:nums){
            count[num]+=1;
        }
        int res=0;
        for (int i=0;i<max+1;i++){
            if (count[i]>n/2){
                res=i;
                break;
            }
        }
        return res;
    }

    public int majorityElement(int[] nums) {
        int n=nums.length;
        if (n==1)return nums[0];
        Arrays.sort(nums);
        return nums[n/2];
    }
}
