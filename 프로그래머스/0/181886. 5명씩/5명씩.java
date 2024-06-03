import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        
        int len = names.length;
        String[] answer = new String[(len-1)/5 + 1];
        for(int i = 0; i < len; i += 5) {
            answer[i/5] = names[i];
        }
        return answer;
    }
}