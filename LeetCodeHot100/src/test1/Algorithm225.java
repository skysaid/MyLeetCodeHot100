package test1;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Algorithm225 {
    class MyStack {
        Queue<Integer> queue;
        private int size;
        /** Initialize your data structure here. */
        public MyStack() {
            this.queue=new LinkedList<>();
            size=0;
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
            size++;
            for (int i=1;i<size;i++){
                int temp=queue.poll();
                queue.add(temp);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            size--;
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
