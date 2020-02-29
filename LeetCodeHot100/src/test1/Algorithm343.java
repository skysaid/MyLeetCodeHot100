package test1;

import java.util.HashMap;
import java.util.Map;

public class Algorithm343 {
    public int integerBreak(int n) {
        map.put(1,1);
        int res=-1;
        for (int i=2;i<n;i++){
            for(int j=1;j<i;j++){
                res=Math.max(j*(i-j),res);
                res=Math.max(res,j*map.get(i-j));
                map.put(i,res);
            }
        }
        return map.get(n);

    }
    Map<Integer,Integer> map=new HashMap<>();
    private int helper(int n){
        if(n==1)return 1;
        int res=-1;
        if(map.containsKey(n))return map.get(n);
        for (int i=1;i<n;i++){
            res=Math.max(i*(n-i),res);
            res=Math.max(res,i*helper(n-i));
        }
        map.put(n,res);
        return res;
    }
}
