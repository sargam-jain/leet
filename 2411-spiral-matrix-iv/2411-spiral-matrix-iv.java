

class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        
        // Initialize the matrix with -1 (default fill value)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }
        
        // Define the boundaries of the spiral
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        
        ListNode current = head;
        
        // Start filling the matrix in spiral order
        while (top <= bottom && left <= right && current != null) {
            // Traverse from left to right along the top row
            for (int j = left; j <= right && current != null; j++) {
                matrix[top][j] = current.val;
                current = current.next;
            }
            top++; // Move the top boundary down
            
            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom && current != null; i++) {
                matrix[i][right] = current.val;
                current = current.next;
            }
            right--; // Move the right boundary left
            
            // Traverse from right to left along the bottom row
            for (int j = right; j >= left && current != null; j--) {
                matrix[bottom][j] = current.val;
                current = current.next;
            }
            bottom--; // Move the bottom boundary up
            
            // Traverse from bottom to top along the left column
            for (int i = bottom; i >= top && current != null; i--) {
                matrix[i][left] = current.val;
                current = current.next;
            }
            left++; // Move the left boundary right
        }
        
        return matrix;
    }
}
