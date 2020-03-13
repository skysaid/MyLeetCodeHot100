package test1;

import java.util.Stack;

public class Algorithm739 {
    //暴力解
    public int[] dailyTemperatures1(int[] T) {
        int[] res=new int[T.length];
        for (int i=0;i<res.length;i++){
            for (int j=i;j<res.length;j++){
                if (T[j]>T[i]){
                    res[i]=j-i;
                    break;
                }
            }
        }
        return res;
    }

    //使用栈（递减栈：只记录现在栈顶小的值）
    public int[] dailyTemperatures(int[] T) {
        int[] res=new int[T.length];
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<res.length;i++){
            while(!stack.isEmpty()&&T[i]>T[stack.peek()]){
                int temp=stack.pop();
                res[temp]=i-temp;
            }
            stack.push(i);
        }
        return res;
    }

}
