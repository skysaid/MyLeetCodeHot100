package test1;

public class Algorithm114 {
    public void flatten1(TreeNode root) {

        while (root!=null){
            //左子树为 null，直接考虑下一个节点
            if (root.left==null){
                root=root.right;
            }else {
                // 找左子树最右边的节点
                TreeNode temp=root.left;
                while(temp.right!=null){
                    temp=temp.right;
                }
                //将原来的右子树接到左子树的最右边节点
                temp.right=root.right;
                // 将左子树插入到右子树的地方

                root.right=root.left;
                root.left=null;


                root=root.right;
            }

        }


        return;

    }

    //--------------------------------------后序遍历
    private TreeNode pre = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }



}
