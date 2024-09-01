class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // Check if the total number of elements is equal to m * n
        if (original.length != m * n) {
            return new int[0][0];  // Return an empty 2D array if conversion is not possible
        }

        // Create the 2D array with m rows and n columns
        int[][] result = new int[m][n];

        // Fill the 2D array with elements from the original array
        for (int i = 0; i < original.length; i++) {
            // Calculate the row and column indices
            int row = i / n;
            int col = i % n;
            result[row][col] = original[i];
        }

        return result;
    }
}
