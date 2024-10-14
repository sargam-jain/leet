class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long count = 0;
        for(int num : nums){
            maxHeap.offer(num);
        }
        for(int i=0;i<k;i++){
            int largest = maxHeap.poll();
            count += largest;
            int reduced = largest / 3 +(largest % 3 == 0?0:1);
            maxHeap.offer(reduced);

        }
        return count;
    }
}