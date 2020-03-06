package test1;

public class Algorithm238 {
     //左右乘积，但是其中一个数组用一个变量代替
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        //记录左边乘积[0，i)
        int[] res=new int[n];
        res[0]=1;
        for (int i=1;i<n;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        int r=nums[n-1];
        for (int j=n-2;j>-1;j--){
            res[j]*=r;
            r*=nums[j];
        }
        return res;


    }
    //左右乘积
    public int[] productExceptSelf2(int[] nums) {
        int n=nums.length;
        //记录左边乘积[0，i)
        int[] l=new int[n];
        l[0]=1;
        //记录右边乘积(i,n-1]
        int[] r=new int[n];
        r[n-1]=1;
        for (int i=1;i<n;i++){
            l[i]=l[i-1]*nums[i-1];
        }
        for (int j=n-2;j>-1;j--){
            r[j]=r[j+1]*nums[j+1];
        }
        for (int k=0;k<n;k++){
            nums[k]=l[k]*r[k];
        }
        return nums;

    }


    //时间度为O(n^2)可以通过
    public int[] productExceptSelf1(int[] nums) {
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int temp=1;
            for (int j=0;j<nums.length;j++){
                if (j==i)continue;
                temp*=nums[j];
            }
            res[i]=temp;
        }
        return res;
    }
}
