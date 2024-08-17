class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        
        // DP array to store the maximum points for each column in the previous row
        long[] dp = new long[n];
        
        // Initialize dp with the first row's values
        for (int c = 0; c < n; c++) {
            dp[c] = points[0][c];
        }
        
        // Process each row
        for (int r = 1; r < m; r++) {
            long[] leftMax = new long[n];
            long[] rightMax = new long[n];
            long[] newDp = new long[n];
            
            // Fill leftMax array
            leftMax[0] = dp[0];
            for (int c = 1; c < n; c++) {
                leftMax[c] = Math.max(leftMax[c - 1], dp[c] + c);
            }
            
            // Fill rightMax array
            rightMax[n - 1] = dp[n - 1] - (n - 1);
            for (int c = n - 2; c >= 0; c--) {
                rightMax[c] = Math.max(rightMax[c + 1], dp[c] - c);
            }
            
            // Calculate the new dp values for the current row
            for (int c = 0; c < n; c++) {
                newDp[c] = points[r][c] + Math.max(leftMax[c] - c, rightMax[c] + c);
            }
            
            dp = newDp;  // Update dp to the new dp
        }
        
        // The result is the maximum value in the last dp array
        long result = 0;
        for (long val : dp) {
            result = Math.max(result, val);
        }
        
        return result;
    }
}
