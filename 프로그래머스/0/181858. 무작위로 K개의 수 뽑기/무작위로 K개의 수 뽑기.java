import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        
        int[] answer = new int[k];
        List<Integer> list = new ArrayList<>();
        
        for (int i : arr) {
            if (!list.contains(i)) {
                list.add(i);
            }
            //if (list.size() == k) break;
        }
        
        for (int i = 0; i < k; i++) {
            if (list.size() - 1 < i) {
                answer[i] = -1;
            } else {
                answer[i] = list.get(i);   
            }            
        }
        return answer;
    }
}