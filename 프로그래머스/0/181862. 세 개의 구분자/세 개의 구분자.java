import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String myStr) {
//         String[] answer = {};
//         myStr = myStr.replace("a", " "); 
//         myStr = myStr.replace("b", " "); 
//         myStr = myStr.replace("c", " "); 
//         answer = myStr.split(" ");
        
//         List<String> list = new ArrayList<>();
//         for(String s : answer) {
//             if (!s.equals(" ") && !s.equals("")) {
//                 list.add(s);   
//             }
//         }
//         if (list.isEmpty()) list.add("EMPTY");
        
//         return list.toArray(String[]::new);
        String[] answer = {};
        StringTokenizer st = new StringTokenizer(myStr,"abc");
        if(st.countTokens() != 0){
            answer = new String[st.countTokens()];
            for(int i=0; i<answer.length; i++){
                answer[i] = st.nextToken();
            }
        }else{
            answer = new String[1];
            answer[0] = "EMPTY";
        }

        return answer;
    }
    
}