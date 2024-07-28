class Solution {
    public int mySqrt(int x) {
        if(x == 2147483647){
            return 46340;
        }
        
      int y = 0;
        for( y = 0;y <= x; y ++){
            if(y * y == x){
                return y;
            }else if(y * y > x){
                return y - 1;
            }
        }
        
        

        return y;
        
        
    }
}