import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] answer = {};
        StringTokenizer st = new StringTokenizer(myStr,"abc");
        int n = st.countTokens();
        
        if (n != 0) {
            answer = new String[n];
            for(int i = 0; i < n; i++) {
                answer[i] = st.nextToken();
            }
        } else {
            answer = new String[1];
            answer[0] = "EMPTY";
        }

        return answer;
    }
}