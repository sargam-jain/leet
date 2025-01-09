class Solution {
    public int prefixCount(String[] words, String pref) {
        int count=0;
        int n=pref.length();
        for(String str : words){
            if(str.length()>=n && str.startsWith(pref)){
                count++;
            }
        }
        return count;
    }
}