class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n  = A.length;
        int common=0;
        int res[] = new int[n];
        int[] freq = new int[n+1];
        for(int i=0;i<n;i++){
            if(++freq[A[i]] == 2) common++;
            if(++freq[B[i]]==2) common++;
            res[i]  = common;
        }
        return res;
    }
}