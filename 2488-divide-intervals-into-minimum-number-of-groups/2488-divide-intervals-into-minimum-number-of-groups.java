class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];
        for(int i=0;i<n;i++){
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int end_pt = 0;
        int count = 0;

        for(int start : startTimes ){
            if(start>endTimes[end_pt]){
                end_pt++;
            }else{
                count++;
            }
        }
        return count;
    }
}