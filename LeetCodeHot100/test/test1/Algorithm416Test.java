package test1;

import org.junit.Test;

import static org.junit.Assert.*;

public class Algorithm416Test {

    @Test
    public void canPartition() {
        int[] nums= new int[]{1,5,11,5};
        Algorithm416 test=new Algorithm416();
        System.out.println(test.canPartition(nums));
    }
}