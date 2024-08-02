class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // Step 1: Count the total number of 1s in the array
        int countOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                countOnes++;
            }
        }

        // If there are no 1s or all are 1s, no swaps needed
        if (countOnes == 0 || countOnes == n) {
            return 0;
        }

        // Step 2: Use a sliding window approach
        int minSwaps = Integer.MAX_VALUE;
        int currentZeros = 0;

        // Initial count of 0s in the first window
        for (int i = 0; i < countOnes; i++) {
            if (nums[i] == 0) {
                currentZeros++;
            }
        }

        // Consider the array as circular by examining the window in the extended array
        minSwaps = currentZeros;
        for (int i = 1; i < n; i++) {
            // Slide the window one position to the right
            // Remove the element going out of the window
            if (nums[i - 1] == 0) {
                currentZeros--;
            }
            // Add the new element coming into the window
            if (nums[(i + countOnes - 1) % n] == 0) {
                currentZeros++;
            }

            // Update the minimum swaps
            minSwaps = Math.min(minSwaps, currentZeros);
        }

        return minSwaps;
    }
}