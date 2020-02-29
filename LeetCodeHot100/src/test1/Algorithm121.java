package test1;

public class Algorithm121 {
    //暴力解法：遍历数组，对于每个位置都向后遍历取最大的差值
    //时间是n2，花的时间很长455ms
    public int maxProfit1(int[] prices) {
        int n=prices.length;
        int res=0;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if (prices[j]>prices[i]){
                    res=Math.max(prices[j]-prices[i],res);
                }
            }
        }
        return res;
    }
    //动态规划，状态：在[0,i]天卖出能获得的最大利润，状态转移f(i)=max(f(i-1),prices[i]-min)
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int res=0;
        if (n==0)return res;
        int min=prices[0];

        for (int i:prices){
            res=Math.max(res,i-min);
            min=Math.min(min,i);
        }
        return res;
    }
}
