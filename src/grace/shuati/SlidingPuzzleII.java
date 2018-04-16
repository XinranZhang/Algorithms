package grace.shuati;
import java.util.*;

public class SlidingPuzzleII {

    public int minMoveStep(int[][] init_state, int[][] final_state) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited =  new HashSet<>();
        if (init_state == null || init_state.length == 0 || init_state[0].length == 0) {
            return -1;
        }
        String beginState = matrixToString(init_state);
        String finalState = matrixToString(final_state);
        queue.offer(beginState);
        visited.add(beginState);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (str.equals(finalState)) {
                    return count;
                }
                for (String s: getNext(str)) {
                    if (visited.contains(s)) {
                        continue;
                    }
                    queue.offer(s);
                    visited.add(s);
                }
            }
            count++;
        }
        return -1;
    }

    private String matrixToString(int[][] puzzle) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result.append(puzzle[i][j]);
            }
        }
        return result.toString();
    }

//    private List<String> getNextState(String beginState) {
//        List<String> states = new ArrayList<>();
//        int zeroIndex = beginState.indexOf('0');
//        if (zeroIndex + 1 <= 8) {
//            states.add(swap(beginState, zeroIndex, zeroIndex + 1));
//        }
//        if (zeroIndex - 1 >= 0) {
//            states.add(swap(beginState, zeroIndex, zeroIndex - 1));
//        }
//        if (zeroIndex - 3 >= 0) {
//            states.add(swap(beginState, zeroIndex, zeroIndex - 3));
//        }
//        if (zeroIndex + 3 <= 8) {
//            states.add(swap(beginState, zeroIndex, zeroIndex + 3));
//        }
//        return states;
//    }
//
//    private String swap(String beginState, int zeroIndex, int nextIndex) {
//        int first = 0, second = 0;
//        if (zeroIndex > nextIndex) {
//            first = nextIndex;
//            second = zeroIndex;
//        } else {
//            first = zeroIndex;
//            second = nextIndex;
//        }
//        String res = beginState.substring(0, first) + beginState.charAt(second) +
//                beginState.substring(first + 1, second) + beginState.charAt(first)
//                + beginState.substring((second + 1));
//        return res;
//    }

    public List<String> getNext(String state) {
        List<String> states = new ArrayList<>();
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        int zeroIndex = state.indexOf('0');
        int x = zeroIndex / 3;
        int y = zeroIndex % 3;

        for (int i = 0; i < 4; i++) {
            int x_ = x + dx[i];
            int y_ = y + dy[i];
            if (x_ < 0 || x_ >= 3 || y_ < 0 || y_ >= 3) {
                continue;
            }

            char[] chars = state.toCharArray();
            chars[x * 3 + y] = chars[x_ * 3 + y_];
            chars[x_ * 3 + y_] = '0';
            states.add(new String(chars));
        }

        return states;
    }
}
