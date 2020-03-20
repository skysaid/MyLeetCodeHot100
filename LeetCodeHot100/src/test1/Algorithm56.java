package test1;



import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;



public class Algorithm56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length==0)return new int[0][2];
        Arrays.sort(intervals,(a,b)->{return a[0]-b[0];});
        Deque<int[]> queue =new LinkedList<>();
        queue.addLast(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] temp=intervals[i].clone();
            int end =queue.peekLast()[1];
            if (end>=intervals[i][0]){
                if (end>=intervals[i][1]){
                    continue;
                }else {
                    temp[0]=queue.pollLast()[0];
                }
            }
            queue.addLast(temp);
        }
        int[][] res=new int[queue.size()][2];

        for (int i = 0; !queue.isEmpty(); i++) {
            res[i]=queue.poll();
        }
        return res;
    }
}
