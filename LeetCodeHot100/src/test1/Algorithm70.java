package test1;

import java.util.HashMap;
import java.util.Map;

public class Algorithm70 {
    private Map<Integer,Integer> map=new HashMap<>();
    public int climbStairs2(int n) {
        if(n==0||n==1){
             return 1;
        }
        if(map.containsKey(n))return map.get(n);
        map.put(n,climbStairs(n-1)+climbStairs(n-2));
        return map.get(n);

    }
    public int climbStairs(int n) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,1);
        map.put(0,1);
        for (int i = 2; i <= n; i++) {
            map.put(i,map.get(i-1)+map.get(i-2));
        }
        return map.get(n);

    }

}
