import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] answer = {};
        myStr = myStr.replace("a", " "); 
        myStr = myStr.replace("b", " "); 
        myStr = myStr.replace("c", " "); 
        answer = myStr.split(" ");
        
        List<String> list = new ArrayList<>();
        for(String s : answer) {
            if (!s.equals(" ") && !s.equals("")) {
                list.add(s);   
            }
        }
        if (list.isEmpty()) list.add("EMPTY");
        
        return list.toArray(String[]::new);
    }
}