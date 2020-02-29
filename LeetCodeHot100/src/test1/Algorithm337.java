package test1;

public class Algorithm337 {
    public int rob(TreeNode root) {
        //将结果存于根节点，并以负数标记已经搜索过的节点
        if(root==null)return 0;
        else if(root.val<0)return -root.val;

        int sum1=0, sum2=0;//记录取自身的最大结果以及取子叶的最大结果

        if(root.left!=null){
            sum2=sum2+rob(root.left);
            if(root.left.left!=null){
                sum1=sum1+rob(root.left.left);
            }
            if (root.left.right!=null){
                sum1=sum1+rob(root.left.right);
            }
        }
        if(root.right!=null){
            sum2=sum2+rob(root.right);
            if(root.right.left!=null){
                sum1=sum1+rob(root.right.left);
            }
            if (root.right.right!=null){
                sum1=sum1+rob(root.right.right);
            }
        }
        root.val=-Math.max(sum1+root.val,sum2);
        return -root.val;
    }
}
