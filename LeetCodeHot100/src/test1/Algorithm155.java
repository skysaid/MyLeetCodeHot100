package test1;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class Algorithm155 {
    class MinStack{
        /** 使用动态数组的实现 */
        private ArrayList<Integer> data;
        private int size;
        private int min;
        public MinStack() {
            this.data=new ArrayList<>();
            size=0;
            min=Integer.MAX_VALUE;
        }

        public void push(int x) {
            min=Math.min(x,min);
            data.add(x);
            size=data.size();
        }

        public void pop() {
            data.remove(this.size-1);
            size=data.size();
            min=Integer.MAX_VALUE;
            for (int i=0;i<size;i++){
                min=Math.min(min,data.get(i));
            }
        }

        public int top() {
            return data.get(size-1);
        }

        public int getMin() {
            return this.min;
        }
    }


}
