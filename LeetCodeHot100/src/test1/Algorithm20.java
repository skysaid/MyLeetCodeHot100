package test1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Algorithm20 {
    Map<Character,Character> map =new HashMap(){
        {
            put(')','(');
            put(']','[');
            put('}','{');
        }
    };
    public boolean isValid(String s) {
        if(s.length()==0)return true;
        if(s.length()%2==1||s.charAt(0)==']'||s.charAt(0)=='}'||s.charAt(0)==')')return false;
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (stack.size()>s.length()/2)break;
            char temp= s.charAt(i);

            if(map.containsKey(temp)){
                char top=stack.isEmpty()?'*':stack.pop();
                if(top!=map.get(temp)){
                    return false;
                }
            }else {
                stack.add(temp);
            }
        }
        return  stack.isEmpty();

    }
}
