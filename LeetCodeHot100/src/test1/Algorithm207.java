package test1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Algorithm207 {
    //使用入度表
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[] indegree =new int[numCourses];
        //建立邻接表
        List<List<Integer>> ad=new ArrayList<>();
        for (int i=0;i<numCourses;i++){
            ad.add(new ArrayList<>());
        }

        for (int[] nums:prerequisites){
            int start=nums[0];
            int end=nums[1];
            ad.get(start).add(end);
            indegree[end]++;
        }
        Queue<Integer> queue =new LinkedList<>();

        for (int i=0;i<indegree.length;i++){
            if (indegree[i]==0)queue.add(i);
        }

        while(!queue.isEmpty()){
            numCourses--;
            List<Integer> temp= ad.get(queue.poll());
            for (int i=0;i<temp.size();i++){
                if (--indegree[temp.get(i)]==0){
                    queue.add(temp.get(i));
                }
            }
        }
        return numCourses==0;
    }
    //使用深度优先搜索
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //建立邻接表
        List<List<Integer>> ad=new ArrayList<>();
        for (int i=0;i<numCourses;i++){
            ad.add(new ArrayList<>());
        }
        for (int[] nums:prerequisites){
            int start=nums[0];
            int end=nums[1];
            ad.get(start).add(end);
        }
        int[] flag=new int[numCourses];
        for (int i=0;i<numCourses;i++){
            if (!dfs(ad,flag,i))return false;
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> ad, int[] flag,int i){
        if (flag[i]==1)return false;
        if (flag[i]==-1)return true;

        flag[i]=1;
        for (int end: ad.get(i)){
            if (!dfs(ad,flag,end))return false;
        }
        flag[i]=-1;
        return true;
    }
}
