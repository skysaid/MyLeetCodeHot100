package test1;

public class Alogirthm198 {
    //memo[i] 表示考虑抢nums[i,n-1]所能得到的最大值
    private int[] memo;

    public int[] getMemo() {
        return memo;
    }

    /**
     * 状态为搜索[0,x]
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n= nums.length;
        if(n==0)return 0;

        memo =new int[nums.length];
        memo[0]=nums[0];
        for (int i=0;i<n;i++){
            for (int j=i;j>=0;j--){
                int temp=(j-2)>=0?memo[j-2]:0;
                memo[i]=Math.max(memo[i],nums[j]+temp);
            }
        }
        return memo[n-1];
    }

    /**
     * 状态为搜索[x,n-1]最大获取
     * @param nums
     * @return
     */
    public int rob3(int[] nums) {
        int n= nums.length;
        if(n==0)return 0;

        memo =new int[n];
        memo[n-1]=nums[n-1];
        for (int i=n-2;i>=0;i--){
            for (int j=i;j<n;j++){
                memo[i]= Math.max(memo[i],(nums[j]+(j+2)<n?memo[j+2]:0));
            }
        }

        return memo[0];
    }
    //超出时间限制
    public int rob2(int[] nums) {
        memo =new int[nums.length];
        tryRob(nums,0);
            return memo[0];
    }

    /**
     * 考虑抢劫nums[index,nums.length-1]范围
     * @param nums
     * @param index
     * @return
     */
   private int tryRob(int[] nums,int index){
        if (index>nums.length-1)return 0;
        if(memo[index]>0)return memo[index];
        int res=0;
        for (int i=index;i<nums.length;i++){
                res=Math.max(res,nums[i]+tryRob(nums,i+2));
            }
        memo[index]=res;
        return res;
    }
}
