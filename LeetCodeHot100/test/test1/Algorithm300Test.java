package test1;

import org.junit.Test;

import static org.junit.Assert.*;

public class Algorithm300Test {

    @Test
    public void lengthOfLIS() {
        int[] nums={10,9,2,5,3,7,101,18};
        Algorithm300 test=new Algorithm300();
        test.lengthOfLIS(nums);
    }
    @Test
    public void lengthOfLIS2() {
        int[] nums={10,9,2,5,3,7,101,18};
        Algorithm300 test=new Algorithm300();
        System.out.println(test.lengthOfLIS2(nums));
    }
}