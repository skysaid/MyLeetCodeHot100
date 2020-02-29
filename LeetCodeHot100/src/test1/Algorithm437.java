package test1;

import java.util.HashMap;

public class Algorithm437 {
//暴力递归，查询当前节点下总和为sum的路径的总和
    public int pathSum1(TreeNode root, int sum) {
        if (root==null)return 0;
        return pathSum1(root.left,sum)+pathSum1(root.right,sum)+count(root,sum);
    }
    //尝试计算当前节点的子节点是否有总和为sum的路径，返回成立的数目；
    private int count(TreeNode root, int sum){
        if(root==null)return 0;
        sum-=root.val;
        return (sum==0?1:0) + count(root.left,sum)+count(root.right,sum);
    }

    public int pathSum(TreeNode root, int sum) {
        //用一个映射记录当前子上而下的树中前缀和为pathSum的路径个数
        HashMap<Integer,Integer> map= new HashMap<>();
        //若路径和和sum相等，则会去查询map中路径和为0的值，这里就需要初始化为1
        map.put(0,1);
        return helper(root,map,sum,0);

    }
    private int helper(TreeNode root, HashMap<Integer,Integer> map,int sum ,int pathSum){
        int res=0;
        //递归返回条件
        if(root==null)return 0;
        //前缀和
        pathSum+=root.val;
        //若之前存在着与当前pathSum-sum相等的前缀，则把结果值加上它对应的路径个数
        res +=map.getOrDefault(pathSum-sum,0);
        //将当前的前缀和为pathSum的路径数加一
        map.put(pathSum,map.getOrDefault(pathSum,0)+1);
        //计算当前节点的左子树和右子树中满足条件的路径
        res+=helper(root.left,map,sum,pathSum)+helper(root.right,map,sum,pathSum);
        //回溯，防止影响其他子树
        /*
             root
             /  \
          *left   right
          /  \   /  \
        ll   lr  rl  rr
        由于*left的时候计算的路径，并不能给right使用，所以需要在返回上一层的时候回溯
         */
        map.put(pathSum,map.get(pathSum)-1);
        return res;

    }
}
