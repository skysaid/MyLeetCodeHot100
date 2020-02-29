package test1;

public class Algorithm461 {
    public int hammingDistance(int x, int y) {
        int temp=x^y;
        int res=0;
        while(temp>0){
            if (temp%2==1)res++;
            temp=temp>>1;
        }

        return res;
    }
}
