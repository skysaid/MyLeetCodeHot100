package test1;

public class Algorithm33 {
    public int search(int[] nums, int target) {
        if (nums.length==0)return -1;

        int change=findchange(nums);
        int res=-1;
        if (target>nums[nums.length-1]){
            res=find(nums,0,change-1,target);
        }else if (target<nums[nums.length-1]){
            res=find(nums,change,nums.length-1,target);
        }else {
            return nums.length-1;
        }
        return res;
    }
    //找到旋转点的索引
    private int findchange(int[] nums){
        int left=0,right=nums.length-1;
        if (nums[left]<nums[right])return 0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]>=nums[left]){
                if (nums[mid+1]<nums[mid])return mid+1;
                left=mid+1;
            }else if (nums[mid]<=nums[right]){
                if (nums[mid-1]>nums[mid])return mid;
                right=mid-1;
            }
        }
            return left-1;
    }
    //找到值
    private int find(int[] nums,int left,int right,int target){
        while(left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]>target){
                right=mid-1;
            }else if (nums[mid]==target){
                return mid;
            }else if (nums[mid]<target){
                left=mid+1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Algorithm33 test=new Algorithm33();
        int[] nums1={7,0,1,2,3};
        int[] nums2={4,5,6,7,8,13,0,1,2,3};
        System.out.println(test.search(nums1,0));
        System.out.println(test.search(nums2,13));
    }
}
