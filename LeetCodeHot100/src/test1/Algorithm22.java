package test1;

import java.util.ArrayList;
import java.util.List;

public class Algorithm22 {
    public List<String> generateParenthesis(int n) {
        List<String> list =new ArrayList<>();
        if(n==0){
            list.add("");
        }else {
            for(int c=0;c<n;c++){
                for(String left:generateParenthesis(c))
                    for (String right:generateParenthesis(n-c-1))
                        list.add("("+left+")"+right);
            }
        }
        return list;
    }
    private void helper(List<String> list,String sb, int open, int close, int max){
        if(open==close&&sb.length()==2*max){
            list.add(sb);
            return;
        }
        if(open<max){
            helper(list,sb+"(",open+1,close,max);
        }
        if(close<open){
            helper(list,sb+")",open,close+1,max);
        }
    }
    public List<String> generateParenthesis2(int n) {
        List<String> list =new ArrayList<>();
        helper(list,"",0,0,n);
        return list;
    }
}
