package test1;

import org.junit.Test;

import static org.junit.Assert.*;

public class Algorithm494Test {

    @Test
    public void findTargetSumWays() {
        int[] nums=new int[]{1,1,1,1,1};
        int S=3;
        Algorithm494 test=new Algorithm494();
        System.out.println(test.findTargetSumWays(nums,3));
    }

    @Test
    public void findTargetSumWays2() {
        int[] nums=new int[]{1,1,1,1,1};
        int S=3;
        Algorithm494 test=new Algorithm494();
        test.findTargetSumWays2(nums,3);
    }
}