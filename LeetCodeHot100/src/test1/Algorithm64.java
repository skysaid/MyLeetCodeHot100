package test1;

import java.util.HashMap;
import java.util.Map;

public class Algorithm64 {
    public int minPathSum(int[][] grid) {
        int[][] index=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0&&j==0){
                    index[i][j]=grid[i][j];
                }else if(i==0){
                    index[i][j]=grid[i][j]+index[i][j-1];
                }else if(j==0){
                    index[i][j]=grid[i][j]+index[i-1][j];
                }else {
                    index[i][j]=grid[i][j]+Math.min(index[i-1][j],index[i][j-1]);
                }
            }
        }
        return index[grid.length-1][grid[0].length-1];
    }


    public static void main(String[] args) {
        int[][] grid=new int[][]{{1,2},{3,4},{5,6}};
        System.out.println(grid[0].length);
        System.out.println(""+1+2);
    }


}
