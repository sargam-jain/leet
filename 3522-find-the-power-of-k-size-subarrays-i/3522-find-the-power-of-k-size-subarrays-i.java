class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
       int j;
        int[] results = new int[n-k+1];
        
        for(int i=0;i<=nums.length-k;i++){
            for(j=i;j<i+k-1;j++){
                if((nums[j] >= nums[j+1]) || (nums[j] + 1 != nums[j+1])){
                    results[i] = -1;
                    break;
                  
                    
                }
                
            }

            
            if(results[i] != -1){
            results[i] = nums[j];
            }
            
            
        
            
               
                
            
        }
        return results;
    }
}