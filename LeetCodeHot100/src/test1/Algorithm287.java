package test1;

public class Algorithm287 {
    //暴力劫遍历两次，一次计数，第二次看结果
    public int findDuplicate1(int[] nums) {
        int[] count=new int[nums.length];
        for (int num:nums){
            count[num]++;
        }
        for (int i=1;i<count.length;i++){
            if (count[i]>1){
                return i;
            }
        }
        return 0;
    }
    //快慢指针
    public int findDuplicate2(int[] nums) {
        int n=nums.length;
        if (n==0)return -1;

        //快慢指针，代表坐标，从第一个值开始跳转

        int fast=0;
        int slow=0;

        do {
            //发现循环点，若本身指标不相等，但下一跳的值是一样的，就说明数组有两个不同的位置有一样的值，提前跳出
            if (nums[fast]==nums[slow]&&fast!=slow)return nums[fast];
            fast=nums[nums[fast]];
            slow=nums[slow];
        }while (fast!=slow);
            //当快慢指针碰到一起时，说明到达了循环位置

        fast=0;
        //让快慢指针以同样的速度走，再次碰到的时候就是循环的值
        while(fast!=slow){
            fast=nums[fast];
            slow=nums[slow];
        }


        return fast;
    }

    //二分法

    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int left=1;
        int right=n-1;

        while(left<right){
            int mid=left+(right-left)/2;

            int count=0;
            for (int num:nums){
                if (num<=mid){
                    count++;
                }
            }
            if (count>mid){
                right=mid;
            }else {
                left=mid+1;
            }

        }
        return left;
    }
}
