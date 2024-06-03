import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        int len = delete_list.length;
        
        for(int i = 0; i < arr.length; i++) {
            int j;
            for(j = 0;j < len; j++) {
                if(arr[i] == delete_list[j]) {
                    break;
                }
            }
            if(j == len) {
                list.add(arr[i]);
            }
        }
        // list.stream()
        //         .mapToInt(i -> i)
        //         .toArray();
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}