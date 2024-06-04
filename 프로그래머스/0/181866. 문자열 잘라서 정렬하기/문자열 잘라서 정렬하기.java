import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.split("x");
        List<String> list = new ArrayList<>();
        //List<String> list = new ArrayList<>(Arrays.asList(answer));
        // for(int i = 0; i < list.size(); i++) {
        //     if(list.get(i).equals("")) {
        //         list.remove(i);
        //     }
        // }
        //list.remove("");
        for(int i = 0; i < answer.length; i++) {
            if(!answer[i].equals("")) {
                list.add(answer[i]);
            }
        }
        
        Collections.sort(list);
        return list.toArray(String[]::new);
    }
}