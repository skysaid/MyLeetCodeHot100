package test1;

import java.util.*;

public class Algorithm347 {
    private class Freq implements  Comparable<Freq>{
    int e,freq;
    public Freq(int e, int freq){
        this.e=e;
        this.freq=freq;
    }
//频率越大，优先级越高
    @Override
    public int compareTo(Freq another) {
        if (this.freq<another.freq)return -1;
        else if (this.freq>another.freq)return 1;
        return 0;
    }
}
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map =new HashMap<>();
        //遍历统计每个数字的频次
        for (int num:nums){
//           if (map.containsKey(num)){
//               map.put(num,map.get(num)+1);
//           }else map.put(num,1);
        //上面的等价写法
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //优先队列由最小堆实现
        PriorityQueue<Freq> pq=new PriorityQueue<>();

        //将最高频次的数目放入优先队列中
        for (int key:map.keySet()){
            if (pq.size()<k){
                pq.add(new Freq(key,map.get(key)));
            }else if (map.get(key)>pq.peek().freq){
                pq.poll();
                pq.add(new Freq(key,map.get(key)));
            }
        }

        List<Integer> res=new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll().e);
        }
        Collections.reverse(res);
        return res;
    }
}
