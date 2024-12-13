class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new int[] {nums[i],i});
        }
        Collections.sort(list,(a,b)->Integer.compare(a[0], b[0]));
        long score = 0;
        for(int i =0;i<n;i++){
            int num = list.get(i)[0];
            int idx = list.get(i)[1];

            if(nums[idx] != -1){
                score += num;
                nums[idx] = -1;
                if(idx > 0){
                    nums[idx - 1] = -1;
                }
                if(idx < n-1){
                    nums[idx+1] = -1;
                }
            }
        }
        return score;
    }
}