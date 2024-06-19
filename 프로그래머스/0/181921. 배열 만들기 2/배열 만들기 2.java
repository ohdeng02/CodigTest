import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        int[] answer;
        List<Integer> temp = new ArrayList<>();
        
        for (int i = l; i <= r; i++) {
            String s = String.valueOf(i);
            if (s.replace("5", "").replace("0", "").equals("")) {
                temp.add(i);
            }
        }
        
        if (temp.isEmpty()) answer = new int[] {-1};
        else {
            answer = new int[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                answer[i] = temp.get(i);
            }
        }
        
        return answer;
    }
}