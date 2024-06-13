import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        
        String[] answer = {};
        int len = str_list.length;
        int idx = 0;
        
        for (int i = 0; i < len; i++) {
            if (str_list[i].equals("l")) {
                // answer = new String[i];
                // for (int j = 0; j < i; j++) {
                //     answer[idx++] = str_list[j];
                // }
                // break;
                return Arrays.copyOfRange(str_list, 0, i);
            } else if (str_list[i].equals("r")) {
                // answer = new String[len-i-1];
                // for (int j = i + 1; j < len; j++) {
                //     answer[idx++] = str_list[j];
                // }
                // break;
                return Arrays.copyOfRange(str_list, i + 1, len);
            }
        }
        
        return answer;
    }
}