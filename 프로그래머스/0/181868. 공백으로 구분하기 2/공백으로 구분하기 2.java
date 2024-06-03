import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] answer = {};
        answer = my_string.split(" ");

        List<String> list = new ArrayList<>();
        for (String s : answer) {
            if(!s.equals("")) {
                list.add(s);
            }
        }
        return list.toArray(String[]::new);
    }
}