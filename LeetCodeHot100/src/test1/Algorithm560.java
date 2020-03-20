package test1;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;

public class Algorithm560 {
    public int subarraySum1(int[] nums, int k) {
        if (nums.length==0)return 0;
        int len =nums.length;
        int s=0,res=0;


        for (int i=0;i<len;i++){
            s=0;
            for (int j=i;j<len;j++){
                s+=nums[j];
                if (s==k)res++;
            }
        }
        return res;
    }
    public int subarraySum(int[] nums, int k) {
        if (nums.length==0)return 0;
        int len =nums.length;
        int s=0,res=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for (int i=0;i<len;i++){
            s+=nums[i];
            if (map.containsKey(s-k)){
                res+=map.get(s-k);
            }
            map.put(s,map.getOrDefault(s,0)+1);
        }
        return res;
    }
}
