package test1;

import java.util.ArrayList;
import java.util.List;

public class Algorithm78 {
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        //添加空集
        res.add(new ArrayList<>());

        //循环递归添加
        for(int num:nums){
            List<List<Integer>> subset=new ArrayList<>();

            for (List<Integer> cur: res){
                subset.add(new ArrayList<Integer>(cur){{add(num);}});
            }

            for (List<Integer> cur: subset){
                res.add(cur);
            }



        }
        return res;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        //添加空集
        findsubset(res,new ArrayList<>(),nums,0);


        return res;
    }
    private void findsubset(List<List<Integer>> res, List<Integer> sub, int[] nums,int index){
        int n=nums.length;

        for (int j=index;j<n;j++){
            sub.add(nums[j]);
            res.add(new ArrayList<Integer>(sub));
            findsubset(res,sub,nums,j+1);
            sub.remove(sub.size()-1);
        }
    }
}
