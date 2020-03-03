package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res,new ArrayList<Integer>(),0,target,candidates);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> sub,int index, int target,int[] nums){
        if (target==0){
            res.add(new ArrayList<>(sub));
            return;
        }


        for(int i=index;i<nums.length;i++){
            if (target-nums[i]<0)break;
            sub.add(nums[i]);
            dfs(res,sub,i,target-nums[i],nums);
            sub.remove(sub.size()-1);

        }
    }
}
