import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String myString) {
//         String[] answer = myString.split("x");
//         List<String> list = new ArrayList<>();
        
//         for(int i = 0; i < answer.length; i++) {
//             if(!answer[i].equals("")) {
//                 list.add(answer[i]);
//             }
//         }
        
//         Collections.sort(list);
//         return list.toArray(String[]::new);
         // return Arrays.stream(myString.split("x")).filter(s -> !s.isEmpty()).sorted().toArray(String[]::new);
        StringTokenizer st = new StringTokenizer(myString, "x");
        int idx = 0, N = st.countTokens();
        String[] result = new String[N];
        for (int n = 0;n < N;n++)
            result[idx++] = st.nextToken();
        Arrays.sort(result);
        return result;
    }
}