class Solution {
    public long pickGifts(int[] gifts, int k) {
        long count = 0;
        for(int i=0;i<k;i++){
            Arrays.sort(gifts);
            gifts[gifts.length-1] = (int) Math.sqrt(gifts[gifts.length-1]);
        }
        for(int gift : gifts){
            count += gift;
        }
        return count;
        
    }
}