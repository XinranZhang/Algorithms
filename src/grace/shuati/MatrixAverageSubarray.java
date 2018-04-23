package grace.shuati;
import java.util.*;

/**
 * Given an array with positive and negative numbers,
 * find the maximum average subarray which length should be greater or equal to given length k.
 */

public class MatrixAverageSubarray {
    public double maxAverage(int[] nums, int k) {
        int maxSum = 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }
}
