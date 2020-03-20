package test1;

import java.util.Arrays;

public class Algorithm34 {
    //最差的情况退化为o（n） 超出时间
    public int[] searchRange1(int[] nums, int target) {
         int left=0,right=nums.length;
         int[] res=new int[2];
         Arrays.fill(res,-1);
         if (right==0)return res;

         while(left<right){
             int mid =left+(right-left)/2;
             if (target<nums[mid]){
                 right=mid;
             }else {
                 left=mid;
             }
         }

         while(left>=0&&right<nums.length){
             if (nums[left]==target||nums[right]==target){
             if (nums[left]==target){
                 res[0]=left;
                 if (left>0)left--;
             }
             if (nums[right]==target){
                 res[1]=right;
                 if (right<nums.length)right++;
             }
             }else break;
         }
         return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        Arrays.fill(res,-1);
        if (nums.length==0)return res;
        res[0]=findleft(nums,target);
        res[1]=findlright(nums,target);
        return res;
    }
    private int findleft(int[] nums, int target){
        int left=0,right=nums.length;
        while (left<right){
            int mid =left+(right-left)/2;
            if (target<nums[mid]){
                right=mid;
            }else if (target==nums[mid]){
                right=mid;
            }else if (target>nums[mid]){
                left=mid+1;
            }
        }
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }
    private int findlright(int[] nums, int target){
        int left=0,right=nums.length;
        while (left<right){
            int mid =left+(right-left)/2;
            if (target<nums[mid]){
                right=mid;
            }else if (target==nums[mid]){
                left=mid+1;
            }else if (target>nums[mid]){
                left=mid+1;
            }
        }
        if (right-1 < 0 || nums[right-1] != target)
            return -1;
        return right-1;
    }
}
