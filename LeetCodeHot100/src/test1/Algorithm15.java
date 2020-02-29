package test1;

import java.util.*;

public class Algorithm15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0)break;
            if(i>0&&nums[i]==nums[i-1])continue;
            twosum(list,nums,i);
        }
        return list;
    }
    private void twosum(List<List<Integer>> list,int[] nums,int i){
        int l=i+1,r=nums.length-1;
        while(r>l){
            int index=nums[i]+nums[l]+nums[r];
            if(index<0){
                while(r>l&&nums[l]==nums[++l]);
            }else if(index>0){
                while(r>l&&nums[r]==nums[--r]);
            }else{
                list.add(new ArrayList<>(Arrays.asList(nums[i],nums[l],nums[r])));
                while(r>l&&nums[l]==nums[++l]);
                while(r>l&&nums[r]==nums[--r]);
            }
        }
    }
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }


}
