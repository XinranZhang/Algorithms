package grace.shuati;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given k sorted integer arrays, merge them into one sorted array.
 */

public class MergeKSortedArrays {
    public int[] mergekSortedArrays(int[][] arrays) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int[] array: arrays) {
            for (int num: array) {
                pq.offer(num);
            }
        }
        int[] results = new int[pq.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = pq.poll();
        }
        return results;
    }
}
