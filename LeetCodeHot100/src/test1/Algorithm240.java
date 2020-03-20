package test1;

public class Algorithm240 {
    //深度优先搜索(需要额外空间保存原本数组)
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)return false;
        int[][] clone=matrix.clone();
        return search(clone,target,0,0);
    }
    private boolean search(int[][] matrix,int target, int i,int j){
        if (i<0||j<0||i>=matrix.length||j>=matrix[0].length||matrix[i][j]==Integer.MIN_VALUE)return false;
        if (matrix[i][j]==target)return true;

        int temp=matrix[i][j];
        matrix[i][j]=Integer.MIN_VALUE;
        boolean res1=false;
        boolean res2=false;
        if (target > temp){
            if (i+1<matrix.length)res1=search(matrix,target,i+1,j);
            if (j+1<matrix[0].length)res2=search(matrix,target,i,j+1);
        }else {
            if (i-1>=0)res1=search(matrix,target,i-1,j);
            if (j-1>=0)res2=search(matrix,target,i,j-1);
        }
        //matrix[i][j]=temp;
        return res1||res2;
    }

    //普通二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)return false;

        for (int i=0,j=0;i<matrix.length&&j<matrix[0].length;i++,j++){
            boolean res1=binarysearch(matrix,target,i,j,true);
            boolean res2=binarysearch(matrix,target,i,j,false);
            if (res1||res2)return true;
        }
        return false;
    }
    private boolean binarysearch(int[][] matrix,int tartget,int i,int j,boolean vertical){
        int left=i;
        int right=vertical?matrix.length-1:matrix[0].length-1;

        while(left<=right){
            int mid =left+(right-left)/2;
            if (vertical){
                if (tartget==matrix[mid][j]){
                    return true;
                }else if (tartget>matrix[mid][j]){
                    left=mid+1;
                }else if (tartget<matrix[mid][j]){
                    right=mid-1;
                }
            }else {
                if (tartget==matrix[i][mid]){
                    return true;
                }else if (tartget>matrix[i][mid]){
                    left=mid+1;
                }else if (tartget<matrix[i][mid]){
                    right=mid-1;
                }
            }

        }
        return false;
    }
}
