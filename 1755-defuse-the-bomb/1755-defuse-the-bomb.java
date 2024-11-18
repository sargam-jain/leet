class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] arr1 = new int[code.length];
        
            if(k==0){
                return arr1;
            }
            for(int i=0;i<code.length;i++){
            if(k>0){
                for(int j=1;j<=k;j++){
                    arr1[i] += code[(i+j) % code.length];
                }
            }else if(k<0){
                for(int j=1;j<=-k;j++){
                    arr1[i] += code[(i-j + code.length) % code.length];
                }
            }
            }
            return arr1;
            
           
    }
}