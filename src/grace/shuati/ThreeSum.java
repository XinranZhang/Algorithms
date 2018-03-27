package grace.shuati;
import java.util.*;
/**
 * Given an array S of n integers, are there elements a, b, c in S
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 */


public class ThreeSum {
    public List<List<Integer>> threeSum(int[] numbers) {
        // find all a, b pairs such that a+b = -c
        // iterate through the array for c
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            List<Integer> ans = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            if (map.containsKey(numbers[i])) {
                map.put(numbers[i], map.get(numbers[i]) + 1);
            } else {
                map.put(numbers[i], 1);
            }
        }

        return res;
    }
}
