package test1;

public class Algorithm75 {
    //两次遍历，计数
    public void sortColors1(int[] nums) {
        int len =nums.length;
        if(len==0)return;
        int red=0,white=0,blue=0;
        for (int i: nums){
            if (i==0)red++;
            if (i==1)white++;
            if (i==2)blue++;
        }
        for (int i=0;i<len;i++){
            if (red!=0){
                nums[i]=0;
                red--;
            }else if (white!=0){
                nums[i]=1;
                white--;
            }else {
                nums[i]=2;
            }
        }

    }
    public void sortColors(int[] nums) {
        int len =nums.length;
        if(len==0)return;
        int left=0,right=len-1,cur=0,temp=0;

        while(left<right&&cur<=right){
            temp=0;
            if (nums[cur]==2){
                temp=nums[cur];
                nums[cur]=nums[right];
                nums[right--]=temp;
            }else
            if (nums[cur]==0){
                temp=nums[cur];
                nums[cur]=nums[left];
                nums[left++]=temp;
                cur++;
            }else {
                cur++;
            }

        }
    }


}
