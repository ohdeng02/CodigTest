import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        
        int len = names.length;
        //String[] answer = new String[len/5 + 1];
        List<String> list = new ArrayList<>();
        for(int i = 0; i < len; i += 5) {
            //answer[i/5] = names[i];
            list.add(names[i]);
        }
        return list.toArray(String[]::new);
    }
}