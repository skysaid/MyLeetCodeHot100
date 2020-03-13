package test1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Algorithm621 {
    //贪心算法
    public int leastInterval1(char[] tasks, int n) {
        int time=0;
        int[] map= new int[26];
        //计数，计算每种任务的数量
        for (char c: tasks){
            map[c-'A']++;
        }
        //把数量最多的放在最后
        Arrays.sort(map);

        //排列任务，以n+1为周期，第一个放数量最多的任务
        while(map[25]>0){
            int i=0;
            while(i<=n){
                //数量最多的任务也分配完了，则退出
                if (map[25]==0)break;
                //分配任务
                if (i<26&&map[25-i]>0){
                    map[25-i]--;
                }
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }
    //桶思想
    public int leastInterval(char[] tasks, int n) {
        int[] map=new int[26];
        int max=0;
        //统计出现最多的任务的次数
        for (char c:tasks){
            map[c-'A']++;
            max=Math.max(max,map[c-'A']);
        }
        //统计出现次数和最多次数一样的任务的数量
        int count=0;
        for (int num:map){
            if (num==max)count++;
        }
        return Math.max((max-1)*(n+1)+count,tasks.length);
    }
}
