package test1;

import java.util.ArrayList;
import java.util.List;

public class Algorithm46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        if (n==0)return res;

        boolean[] hasUsed =new boolean[n];
        dfs(res,new ArrayList<>(),0,nums,hasUsed);
        return res;
    }
    void dfs(List<List<Integer>> res, List<Integer> path, int d,int[] nums, boolean[] hasUsed){
        if (d==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=0; i<nums.length;i++){
            if(!hasUsed[i]){
                path.add(nums[i]);
                hasUsed[i]=true;
                dfs(res,path,d+1,nums,hasUsed);
                hasUsed[i]=false;
                path.remove(path.size()-1);

            }
        }

    }
}
