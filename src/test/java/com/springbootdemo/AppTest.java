package com.springbootdemo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        int[] nums = {9,3,2,4,8};
        int n = kthLargestElement(3, nums);
        System.out.println(n);
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        int len = nums.length;
        return kthLargestElementWithXY(k, nums, 0, len - 1);
    }

    public int kthLargestElementWithXY(int k, int[] nums, int begin, int end) {
        int pivot = begin;
        int x = pivot + 1, y = end;

        while(true) {
            while (y >= begin && nums[y] >= nums[pivot]) --y;
            if (y >= begin && nums[y] < nums[pivot]) {
                int tmp = nums[y];
                nums[y] = nums[pivot];
                nums[pivot] = tmp;
                pivot = y;
            }

            while (x <= end && nums[x] < nums[pivot]) ++x;
            if (x <= end && nums[x] >= nums[pivot]) {
                int tmp = nums[x];
                nums[x] = nums[pivot];
                nums[pivot] = tmp;
                pivot = x;
            }

            if (x >= y) break;
        }

        if (k == end - pivot + 1) return nums[pivot];
        else if (end - pivot + 1 > k) return kthLargestElementWithXY(k, nums, pivot + 1, end);
        else return kthLargestElementWithXY(k - (end - pivot + 1), nums, begin, pivot - 1);
    }
}
