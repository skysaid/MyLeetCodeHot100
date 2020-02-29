package test1;

import java.util.Stack;

public class Algorithm32 {
    /**
     * 暴力法超出时间
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        int max=0;
        String sb=null;
        if(s.equals("")||s.length()==0)return max;
        for (int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j+=2){
                if (j+1>s.length()-1){
                    sb=s.substring(i);
                }else{
                    sb=s.substring(i,j+1);
                }
                    if(isValid(sb)){
                        max=Math.max(max,j-i+1);
                    }

            }
        }
        return max;
    }
    public boolean isValid(String s){
        if (s.length()%2==1)return false;
        if (s.charAt(0)==')')return false;
        Stack<Character> stack=new Stack<>();
        stack.add(s.charAt(0));
        for (int i=1;i<s.length();i++){
            char next=s.charAt(i);
            if(stack.size()>(s.length()/2)+1)return false;
            if(next=='('){
                stack.add('(');
            }else {
                if(stack.isEmpty()&&i!=s.length()-1){
                    return false;
                }
                stack.pop();
            }

        }
        return stack.isEmpty();
    }
    public int longestValidParentheses(String s) {
        int max=0;
        if (s.length()==0||s.equals(""))return max;
        Stack<Integer> stack=new Stack<>();
        stack.add(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.add(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                max=Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s="abcd";
        System.out.println(s.substring(0,1));
    }
}
