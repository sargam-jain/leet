

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        // Sort both arrays
        Arrays.sort(target);
        Arrays.sort(arr);
        
        // Compare the sorted arrays
        return Arrays.equals(target, arr);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] target = {1, 2, 3, 4};
        int[] arr = {2, 4, 1, 3};
        System.out.println("Can be made equal: " + solution.canBeEqual(target, arr)); // Output: true
    }
}
