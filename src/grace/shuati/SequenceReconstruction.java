package grace.shuati;
import java.util.*;

// topological sorting
// for each sequence in seqs, calculate the in-degree of each element
// put the element with 0 in-degree in a queue, then realize BFS
// need size to track each level -> if at each level there is only 1 element in the queue, return true
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> numSeq = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < org.length; i++) {
            numSeq.put(org[i], new ArrayList<>());
        }

        for (int[] sub: seqs) {
            int n = sub.length;
            // add all the following nums to sub[i]
            for (int i = n - 1; i >= 0; i--) {
                if (map.containsKey(sub[i])) {
                    map.put(sub[i], map.get(sub[i]) + i);
                } else {
                    map.put(sub[i], i);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    numSeq.get(sub[i]).add(sub[j]);
                }
            }
        }

        if (map.size() != org.length) return false;

        // add 0 in-degree element to the queue
        for (int n: map.keySet()) {
            if (map.get(n) == 0) {
                queue.offer(n);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 1) return false;
            int num = queue.poll();
            for (int j = 0; j < numSeq.get(num).size(); j++) {
                int element = (int)numSeq.get(num).get(j);
                map.put(element, map.get(element) - 1);
                if (map.get(element) == 0) {
                    queue.offer(element);
                }
            }
        }

        return true;
    }
}
