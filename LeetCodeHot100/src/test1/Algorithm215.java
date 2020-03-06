package test1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Algorithm215 {
    //排序
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        if (k==nums.length)return nums[0];
        if (k==1)return nums[nums.length-1];

        int i=nums.length-1;
        for (;k>1;i--){
                k--;
                  }
        return nums[i];
    }
    //使用最小堆
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        int count=1;
        for (int num:nums){
            if (count>k){
                if (num>minheap.peek()){
                    minheap.poll();
                    minheap.add(num);
                }
            }else {
                minheap.add(num);
                count++;
            }
        }

        return minheap.poll();
    }

    //使用快排
    public int findKthLargest(int[] nums, int k) {
        partition(nums,0,nums.length-1,k);
        int i=nums.length-1;
        for (;k>1;i--){
            k--;
        }
        return nums[i];

    }

    private void partition(int[] nums, int low,int high,int k){
        int i,j,temp;
        i=low;
        j=high;
        if (low<high){
            temp=nums[low];
            while(i!=j){
                while(nums[j]>temp&&j>i){
                    j--;
                }
                if (j>i){
                    nums[i]=nums[j];
                    i++;
                }
                while(nums[i]<temp&&j>i){
                    i++;
                }
                if(j>i){
                    nums[j]=nums[i];
                    j--;
                }
            }
        nums[i]=temp;

                partition(nums,i+1,high,k);

                partition(nums,low,i-1,k);

        }
    }
}
