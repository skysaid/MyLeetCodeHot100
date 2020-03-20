package test1;

public class Algorithm152 {
    //暴力解
    public int maxProduct1(int[] nums) {
        if (nums.length==0)return 0;
        int max=Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            int sum=1;
            for (int j=i;j<nums.length;j++){
                sum*=nums[j];
                max=Math.max(sum,max);
            }
        }
        return max;
    }
    public int maxProduct(int[] nums) {
        if (nums.length==0)return 0;
        int max=Integer.MIN_VALUE,curmax=1,curmin=1;

        for (int i=0;i<nums.length;i++){
            if (nums[i]<0){
                int temp=curmax;
                curmax=curmin;
                curmin=temp;
            }else if (nums[i]==0){
                curmax=1;
                curmin=1;
                continue;
            }
                curmax=Math.max(nums[i],curmax*nums[i]);
                curmin=Math.min(nums[i],curmin*nums[i]);
                max=Math.max(max,curmax);
        }
        return max;
    }
}
