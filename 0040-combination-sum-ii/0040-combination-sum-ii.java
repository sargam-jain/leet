
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        // Sort the array to handle duplicates and make it easier to find combinations
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }
    
    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> results) {
        if (target == 0) {
            // Found a valid combination
            results.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            // If the current candidate exceeds the target, no need to continue
            if (candidates[i] > target) break;
            // Include the candidate in the current combination
            current.add(candidates[i]);
            // Move to the next candidate, ensuring not to reuse the same element
            backtrack(candidates, target - candidates[i], i + 1, current, results);
            // Backtrack, remove the candidate from the current combination
            current.remove(current.size() - 1);
        }
    }
}
