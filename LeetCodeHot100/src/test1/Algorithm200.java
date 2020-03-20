package test1;

public class Algorithm200 {
    //深度优先搜索
    public int numIslands(char[][] grid) {
        if (grid==null||grid.length==0)return 0;
        int rlen=grid.length,clen=grid[0].length;
        int res=0;
        for (int i=0;i<rlen;i++){
            for (int j=0;j<clen;j++){
                if (grid[i][j]=='1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid,int i,int j){
        int rlen=grid.length,clen=grid[0].length;

        //判断坐标是否出界
        if (i>=rlen || i<0 || j>=clen || j<0 ||grid[i][j] == '0')return;

        //标记为已经访问
        grid[i][j]='0';

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
