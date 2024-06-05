import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        
        char[] charArr = my_string.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(indices);
        int idx = 0;
        int len = indices.length;
        
        for(int i = 0; i < my_string.length(); i++) {
            if(i != indices[idx]) {
                sb.append(charArr[i]);
            } else {
                idx = idx < len-1 ? idx + 1 : idx;
            }
        }
        
        return sb.toString();
    }
}