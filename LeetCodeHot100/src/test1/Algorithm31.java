package test1;

import java.util.Arrays;

public class Algorithm31 {
    public void nextPermutation2(int[] nums) {
        int index=-1;

        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                index=i-1;
                break;
            }
        }
        if (index==-1){
            Arrays.sort(nums);
            return;
        }
        int[] n=Arrays.copyOfRange(nums,index+1,nums.length);
        Arrays.sort(n);
        for(int e=0;e<n.length;e++){
            if(nums[index]<n[e]){
                int newint=n[e];
                n[e]=nums[index];
                nums[index]=newint;
                break;
            }
        }
        Arrays.sort(n);
        int k=0;
        for(int j=index+1;j<nums.length;j++){
            nums[j]=n[k++];
        }
    }
    public void nextPermutation(int[] nums) {
        int index=-1;

        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                index=i-1;
                break;
            }
        }
        if (index==-1){
            Arrays.sort(nums);
            return;
        }
        if(nums.length-1==index+1){
            int newint=nums[nums.length-1];
            nums[nums.length-1]=nums[index];
            nums[index]=newint;
            return;
        }else {
            for(int p=index+1;p<nums.length;p++){
                if(nums[index]>nums[p]){
                    int newint=nums[p-1];
                    nums[p-1]=nums[index];
                    nums[index]=newint;
                    break;
                }
            }
        }

        int[] n=Arrays.copyOfRange(nums,index+1,nums.length);
        Arrays.sort(n);
        int k=0;
        for(int j=index+1;j<nums.length;j++){
            nums[j]=n[k++];
        }
    }

    public static void main(String[] args) {
        int[] a={0,1,2,3,4,5,6};

        for (int i:Arrays.copyOf(a,2))
            System.out.print(i);

        System.out.println();
        for (int i:Arrays.copyOfRange(a,3,a.length)){
            System.out.print(i);
        }

    }
}
