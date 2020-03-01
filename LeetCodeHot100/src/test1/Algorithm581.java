package test1;

import java.util.Arrays;

public class Algorithm581 {
    //复制数组，排序后与原本的数组进行比较，找出不一样的左右边界
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        if (n==0)return 0;

        int start=0;
        int end=0;
        int[] copy= Arrays.copyOf(nums,n);
        Arrays.sort(copy);
        for (int i=0;i<n-1;i++){
            if (copy[i]!=nums[i]){
                start=i;
                break;
            }
        }
        for (int j=n-1;j>0;j--){
            if (copy[j]!=nums[j]){
                end=j;
                break;
            }
        }
        if (start==end)return 0;
        return end-start+1;
    }
}
