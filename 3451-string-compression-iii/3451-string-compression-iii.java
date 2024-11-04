class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int count = 1;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
                
                // If count reaches 9, reset to handle long sequences
                if (count == 9) {
                    comp.append(count);
                    comp.append(word.charAt(i - 1));
                    count = 0;  // Reset to 1 for next sequence
                }
            } else {
                if(count > 0){
                comp.append(count);
                comp.append(word.charAt(i - 1));
                  // Reset for new character sequence
                }
                count = 1;
            }
        }

        // Append the last group after the loop ends
        if(count > 0){
        comp.append(count);
        comp.append(word.charAt(word.length() - 1));
        }

        return comp.toString();
        
    }
}
