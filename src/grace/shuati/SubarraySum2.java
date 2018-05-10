package grace.shuati;

public class SubarraySum2 {
    public int subarraySumII(int[] A, int start, int end) {
        int count = 0;
        int[][] matrix = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            matrix[i][i] = A[i];
            if (matrix[i][i] >= start && matrix[i][i] <= end) {
                count++;
            }
        }

        // calculate the sum of all subarrays and put them to matrix
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                matrix[i][j] = matrix[i][j - 1] + A[j];
                if (matrix[i][j] >= start && matrix[i][j] <= end) {
                    count++;
                }
            }
        }

        return count;
    }
}
