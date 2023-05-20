package Programmers;

import java.util.Arrays;

public class test_2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        int index = Arrays.binarySearch(arr,0,1,2);
        System.out.println(index);

    }
}
