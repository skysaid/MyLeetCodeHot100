package test1;

public class Algorithm48 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;

        for (int i=0;i<(n+1)/2;i++){
            for (int j=i;j<n-i-1;j++){
                //matrix[j][n-1-i]是第二个值
                int temp1=matrix[j][n-1-i];

                //将第一个数的值赋给第二个
                matrix[j][n-1-i]=matrix[i][j];

                //保存第三个的值
                int temp2=matrix[n-1-i][n-1-j];

                //将第二个的值给低三个
                matrix[n-1-i][n-1-j]=temp1;

                //保存第四个的值
                temp1=matrix[n-1-j][i];

                //将第三个赋给第四个
                matrix[n-1-j][i]=temp2;

                //将第四个赋给第一个
                matrix[i][j]=temp1;


                //与以上等价
//                int temp=matrix[n-1-j][i];
//                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
//                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
//                matrix[j][n-1-i]=matrix[i][j];
//                matrix[i][j]=temp;
            }

        }
    }
}
