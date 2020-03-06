package test1;

public class Algorithm96 {
    //状态转移函数G（i）+=（0，i求和）G（i-1）*G（n-i）
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        //第一个循环控制构建的二叉搜索树的长度，第二个循环控制根的选择。
        for (int i=2;i<=n;i++){
            for (int j=1;j<=i;j++){
                G[j]=G[j-1]*G[i-j];
            }
        }
        return G[n];
    }


}
