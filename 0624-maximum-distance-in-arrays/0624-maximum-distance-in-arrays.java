
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // Initialize the minimum and maximum values with the first array's bounds.
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        
        // This will store the maximum distance found.
        int maxDistance = 0;

        // Iterate through the remaining arrays.
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int currentMin = array.get(0);
            int currentMax = array.get(array.size() - 1);
            
            // Calculate the distance by comparing current array's min with previous max, and vice versa.
            maxDistance = Math.max(maxDistance, Math.abs(currentMax - minVal));
            maxDistance = Math.max(maxDistance, Math.abs(maxVal - currentMin));
            
            // Update the global minimum and maximum values.
            minVal = Math.min(minVal, currentMin);
            maxVal = Math.max(maxVal, currentMax);
        }

        return maxDistance;
    }
}
