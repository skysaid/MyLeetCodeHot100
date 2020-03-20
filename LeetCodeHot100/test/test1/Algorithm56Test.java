package test1;

import org.junit.Test;

import static org.junit.Assert.*;

public class Algorithm56Test {

    @Test
    public void merge() {
        int[][] nums={{1,3},{2,6},{8,10},{15,18}};
        Algorithm56 test=new Algorithm56();
        test.merge(nums);
    }
}