class Solution {
    public boolean isCircularSentence(String sentence) {
       
        String[] sent = sentence.split(" ");
         if(sent.length == 1){
            if(sent[0].charAt(0) != sent[0].charAt(sent[0].length()-1)){
                return false;
            
            }
        }
        for(int i=0;i<sent.length-1;i++){
            
                if(sent[i].charAt(sent[i].length()-1) != sent[i+1].charAt(0)){
                    return false;
                }
            }
            if(sent[0].charAt(0) != sent[sent.length-1].charAt(sent[sent.length-1].length()-1)){
                return false;
            }
            return true;
        
    }
}