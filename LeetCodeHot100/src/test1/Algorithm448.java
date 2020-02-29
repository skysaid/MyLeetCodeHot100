package test1;

import java.util.ArrayList;
import java.util.List;

public class Algorithm448 {
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> list =new ArrayList<>();
        int len=nums.length;
        int[] res=new int[len+1];
        for (int i=0;i<len;i++){
            res[nums[i]]++;
        }
        for (int i=1;i<res.length;i++){
            if(res[i]==0)list.add(i);
        }
        return list;
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list =new ArrayList<>();
        int len=nums.length;
        for (int i=0;i<len;i++){
            int temp=Math.abs(nums[i]);
            if (nums[temp-1]<0)continue;
            nums[temp-1]*=-1;
        }
        for (int i=0;i<len;i++){
            if(nums[i]>0)list.add(i+1);
        }
        return list;
    }

}
