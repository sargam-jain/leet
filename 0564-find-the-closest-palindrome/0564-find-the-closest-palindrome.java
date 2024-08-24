class Solution {
    public String nearestPalindromic(String n) {
        int length = n.length();
        long num = Long.parseLong(n);
        
        // Edge case for small numbers
        if (num <= 10 || (num % 10 == 0 && num == Math.pow(10, length - 1))) {
            return Long.toString(num - 1);
        }
        if (num == 11) {
            return "9";
        }
        
        // Generate candidates
        Set<Long> candidates = new HashSet<>();
        candidates.add((long) Math.pow(10, length - 1) - 1);  // lower bound like 999..999
        candidates.add((long) Math.pow(10, length) + 1);      // upper bound like 1000..001
        
        // Get the prefix and generate palindromes by mirroring
        long prefix = Long.parseLong(n.substring(0, (length + 1) / 2));
        for (long i = -1; i <= 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(Long.toString(prefix + i));
            String candidateStr = sb.toString() + new StringBuilder(sb.reverse().substring(length % 2)).toString();
            candidates.add(Long.parseLong(candidateStr));
        }
        
        // Remove the number itself
        candidates.remove(num);
        
        // Find the closest palindrome
        long minDiff = Long.MAX_VALUE;
        long closest = 0;
        for (long candidate : candidates) {
            long diff = Math.abs(candidate - num);
            if (diff < minDiff || (diff == minDiff && candidate < closest)) {
                minDiff = diff;
                closest = candidate;
            }
        }
        
        return Long.toString(closest);
    }
}
