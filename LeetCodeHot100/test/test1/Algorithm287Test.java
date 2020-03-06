package test1;

import org.junit.Test;

import static org.junit.Assert.*;

public class Algorithm287Test {

    @Test
    public void findDuplicate() {
        Algorithm287 test= new Algorithm287();
        int[] nums ={1,3,4,2,2};
        System.out.println(test.findDuplicate(nums));
    }
}