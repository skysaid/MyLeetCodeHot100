package test1;

public class Algorithm543 {
    int res;
    //通过计算左子树和右子树的最大深度计算最长直径
    public int diameterOfBinaryTree(TreeNode root) {
       res=1;
       findeMaxDepth(root);
       return res-1;
    }

    public int findeMaxDepth(TreeNode root){
        if (root==null)return 0;
        int left=findeMaxDepth(root.left);
        int right=findeMaxDepth(root.right);
        //取当前最大路径 1.在这里看看是否这里的节点作为拐弯的路径是最长的
        res=Math.max(res,left+right+1);
        //返回最大深度
        return Math.max(left,right)+1;
    }
}
