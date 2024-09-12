class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        var map = new boolean[26];
        var des = words.length;

        for(var c : allowed.toCharArray()){
            map[c - 'a'] = true;
        }

        for(var word : words){
            for(var c : word.toCharArray()){
                if(!map[c-'a']) {
                    des--;
                    break;
                }
            }
        }
        return des;
        
    }
}