package test1;

public class Algorithm05 {
    public String longestPalindrome1(String s) {
            if(s.equals(""))return "";
            StringBuffer sb=new StringBuffer();
            sb.append(s);
            String reverse=sb.reverse().toString();
            int len=s.length();
            int[][] index= new int[len][len];
            int MaxLen=0;
            int end=0;

            for(int i=0;i<len;i++){
                for(int j=0;j<len;j++){
                    if(s.charAt(i)==reverse.charAt(j)){
                        if(i==0||j==0){
                            index[i][j]=1;
                        }else{
                            index[i][j]=index[i-1][j-1]+1;
                        }
                    }
                    if(index[i][j]>=MaxLen){
                        int preEnd=len-1-j;
                        if(i==preEnd+index[i][j]-1){
                            MaxLen=index[i][j];
                            end=i;
                        }
                    }
                }
            }
        return s.substring(end-MaxLen+1,end+1);
    }
    public String longestPalindrome(String s) {
        if(s.equals(""))return "";
        int len=s.length();
        int size=0,Max=0,start=0;
        for(int i=0;i<len;i++){
            int odd=helper(s,i,i);
            int even=helper(s,i,i+1);
            int res=Math.max(odd,even);
            if (res>Max){
                Max=res;
                start=i;
            }
        }
return  s.substring(start-(Max-1)/2,start+(Max)/2);
    }
    private int helper(String s,int l,int r){
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
    public static void main(String[] args) {
        String s="abacdec";
        StringBuffer sb=new StringBuffer();
        sb.append(s);
        System.out.println(sb.reverse().toString());

    }
}
