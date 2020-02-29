package test1;

import org.junit.Test;

import static org.junit.Assert.*;

public class Algorithm322Test {

    @Test
    public void coinChange() {
        int[] coins=new int[]{1,2,5};
        int amount=11;
        Algorithm322 test=new Algorithm322();
        System.out.println(test.coinChange(coins,amount));
    }
}