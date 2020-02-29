package test1;

public class Algorithm416 {
    //memo[i,c]表示使用索引为[0,i]的元素，是否可以填充c
    //0为未计算，-1为false，1为true
    int[][] memo;
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int e:nums){
            sum+=e;
        }
        if(sum%2==1)return false;
        int target=sum>>1;
        int n=nums.length;
        boolean[] dp=new boolean[target+1];
        for(int i=0;i<=target;i++){
            dp[i]=(nums[0]==i);
        }
        for (int i=1;i<n;i++){
            for (int j=target;j>=nums[i];j--){
                dp[j]=dp[j]||dp[j-nums[i]];
            }
        }

        return dp[target];
    }
    public boolean canPartition2(int[] nums) {
        int sum=0;
        for (int e:nums){
            sum+=e;
        }
        if(sum%2==1)return false;
        int target=sum>>1;
        memo=new int[nums.length][target+1];

        return tyrPartition(memo,nums,nums.length-1,target);
    }
    //尝试在[0,index]中填充target

    private boolean tyrPartition(int[][] memo, int[] nums,int index, int target){
        if(target==0)return true;
        if(index<0||target<0)return false;
        if(memo[index][target]!=0)return memo[index][target]==1;
        boolean left=tyrPartition(memo,nums,index-1,target);
        boolean right=tyrPartition(memo,nums,index-1,target-nums[index]);
        if(left||right){
            memo[index][target]=1;
            return true;
        }else {
            memo[index][target]=-1;
            return false;
        }
    }

    public static void main(String[] args) {
        boolean[] i=new boolean[1];
        System.out.println(i[0]);
    }
}
