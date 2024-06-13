import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        int[] answer;
        List<Integer> list = new ArrayList<>();
        int len = arr.length;
        int i = 0;
        
        while (i < len) {
            if (list.isEmpty()) {
                list.add(arr[i]);
            } else if (!list.isEmpty() && list.get(list.size()-1) == arr[i]) {
                list.remove(list.size()-1);
            } else {
                list.add(arr[i]);
            }
            i++;
        }
        
        int size = list.size();
        if (size == 0) {
            answer = new int[] {-1};
        } else {
            answer = new int[size];
            for (int j = 0; j < size; j++) {
                answer[j] = list.get(j);
            }   
        }
        
        return answer;
    }
}