package test1;

public class Algorithm647 {
    //暴力解
    public int countSubstrings1(String s) {
        if (s.length()==0||s.equals(""))return 0;
        int res=0;
        for (int i=0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
                if (check(s,i,j))res++;
            }
        }
        return res;
    }
    private boolean check(String s,int start,int end){
        for (int i=start,k=end;i<=k;i++,k--){
            if (s.charAt(i)!=s.charAt(k))return false;
        }
        return true;
    }

    //-----------------------------
    //由于有单中心和双中心两种可能，需要分别求出
    public int countSubstrings(String s) {
        int len =s.length();
        if (len==0||s.equals(""))return 0;
        int res=0;
        for (int i=0;i<len;i++){
            for (int j=0;i-j>=0&&i+j<len;j++){
                if (s.charAt(i+j)==s.charAt(i-j)){
                    res++;

                }  else {
                    break;
                }
            }
        }
        for (int i=0;i<len;i++){
            for (int j=0;i-j>=0&&i+j+1<len;j++){

                if (s.charAt(i - j) == s.charAt(i + j + 1)) {
                        res++;
                    }
                else {
                    break;
                }
            }
        }
        return res;
    }


}
