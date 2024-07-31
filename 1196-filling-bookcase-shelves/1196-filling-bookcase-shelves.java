class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1]; // dp[i] represents the minimum height to place the first i books.
        dp[0] = 0; // Base case: no books, no height.

        for (int i = 1; i <= n; i++) {
            int width = 0;
            int height = 0;
            dp[i] = Integer.MAX_VALUE;
            
            // Try placing books[j-1] to books[i-1] on the same shelf.
            for (int j = i; j > 0; j--) {
                width += books[j - 1][0]; // Total width of books from j-1 to i-1.
                if (width > shelfWidth) {
                    break; // Can't place more books on this shelf if width exceeds shelfWidth.
                }
                height = Math.max(height, books[j - 1][1]); // Maximum height of the current shelf.
                dp[i] = Math.min(dp[i], dp[j - 1] + height); // Update dp[i] with the minimum height.
            }
        }

        return dp[n]; // Minimum height to place all n books.
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] books1 = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int shelfWidth1 = 4;
        System.out.println(sol.minHeightShelves(books1, shelfWidth1)); // Output: 6
        
        int[][] books2 = {{1, 3}, {2, 4}, {3, 2}};
        int shelfWidth2 = 6;
        System.out.println(sol.minHeightShelves(books2, shelfWidth2)); // Output: 4
    }
}
