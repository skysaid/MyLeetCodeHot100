package test1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Alogirthm198Test {
    int[] nums={1,2,3,4};
    Alogirthm198 test=new Alogirthm198();

    @Test
    public void rob() {
        System.out.println( test.rob(nums));
        int[] now=test.getMemo();
        for (int i=0;i<now.length;i++){
            System.out.print(now[i]);
        }

    }

    @Test
    public void rob2() {
        System.out.println( test.rob2(nums));
    }
    @Test
    public void rob3(){
        System.out.println( test.rob3(nums));
    }

    public static void main(String[] args) {

    }

}