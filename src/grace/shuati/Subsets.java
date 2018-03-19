package grace.shuati;
import java.util.*;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 */

/**
 * Solution idea: add the ith element in the array to all previous list
 * take [1, 2, 3] as an example:
 * first round: []
 * second round: [], [1]
 * third round: [], [1], [2], [1, 2]
 * fourth round: [], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        for (int n: nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> list: res) {
                List<Integer> a = new ArrayList<>(list); // copy all the existing arraylist over
                a.add(n); // adding the next item to the copied arraylist
                tmp.add(a); // add the new arraylist to the temporary list
            }
            res.addAll(tmp);
        }
        return res;
    }
}
