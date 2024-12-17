class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder sb = new StringBuilder();
       char[] chars = s.toCharArray();
       Arrays.sort(chars);
       int freq = 1;
       int pointer = chars.length-1;
       for(int i=chars.length-1;i>=0;i--){
        if(sb.length() > 0 && sb.charAt(sb.length()-1) == chars[i]){
            if (freq < repeatLimit){
                sb.append(chars[i]);
                freq++;
            } else {
                while(pointer >= 0 && (chars[pointer] ==chars[i] || pointer > i )){
                    pointer --;
                }
                if(pointer >= 0){
                    sb.append(chars[pointer]);
                    char temp = chars[i];
                    chars[i] = chars[pointer];
                    chars[pointer] = temp;
                    freq = 1;
                }else{
                    break;

                }
                }
            }else{
                sb.append(chars[i]);
                freq = 1;
            }
        }
        return sb.toString();
       
        

        
    }
}