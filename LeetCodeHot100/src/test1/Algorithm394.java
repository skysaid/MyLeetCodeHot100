package test1;



import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Algorithm394 {
    public String decodeString1(String s) {
        if (s.length()==0||s.equals(""))return null;
        int multi=0;
        StringBuilder res=new StringBuilder();
        Stack<Integer> stack_multi=new Stack<>();
        Stack<String> stack_res=new Stack<>();
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c=='['){
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi=0;
                res=new StringBuilder();
            }else if (c==']'){
                StringBuilder temp=new StringBuilder();
                int curmulti=stack_multi.pop();
                for (int j=0;j<curmulti;j++)temp.append(res);
                res=new StringBuilder(stack_res.pop()+temp);

            }else if (c>='0'&&c<='9'){
                multi=multi * 10 + Integer.parseInt(c + "");
            }
            else {
                res.append(c);
            }

        }
        return res.toString();
    }
    //dfs
    public String decodeString(String s) {
        return dfs(s,0)[0];
    }
    private String[] dfs(String s,int i){
        StringBuilder res = new StringBuilder();
        int curmulti=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if (c>='0'&&c<='9')curmulti=curmulti*10+Integer.parseInt(String.valueOf(c));
            else if (c=='['){
                String[] temp= dfs(s,i+1);
                i=Integer.parseInt(temp[0]);
                while(curmulti>0){
                    res.append(temp[1]);
                    curmulti--;
                }
            }else if (c==']'){
                return new String[]{String.valueOf(i),res.toString()};
            }else {
                res.append(c);
            }
            i++;
        }

        return new String[]{res.toString()};
    }

    public static void main(String[] args) {
        //substring 左闭右开区间
        String s="abc".substring(0,1);
        System.out.println(s);
        String a="23";
        int i=Integer.valueOf('8');
        System.out.println(Integer.valueOf(a));
        System.out.println(Integer.parseInt(String.valueOf(a.charAt(0))));
        System.out.println(i);
    }
}
