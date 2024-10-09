class Solution {
    public int minAddToMakeValid(String s) {
        int size = 0;
        int balance = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                size++;
            }else if(ch ==')'){
                if(size>0){
                size--;
                }else{
                    balance ++;
                }
            }
        }
        return size + balance;
    }
}