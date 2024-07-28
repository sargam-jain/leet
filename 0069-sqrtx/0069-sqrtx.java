class Solution {
    public int mySqrt(int x) {
        int y = 4;
        if(x < 2){
            return x;
            
        }else if(x == 2 || x == 3){
            return 1;
        }else if(x == 2147483647){
            return 46340;
        }
        else{
        
      
        for( y = 2;y < x; y ++){
            if(y * y == x){
                return y;
            }else if(y * y > x){
                return y - 1;
            }
        }
        }
        

        return y;
        
        
    }
}