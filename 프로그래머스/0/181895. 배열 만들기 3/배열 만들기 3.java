import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int a1 = intervals[0][0], b1 = intervals[0][1], a2 = intervals[1][0], b2 = intervals[1][1];
        int size = b1 - a1 + b2 - a2 + 2;
        int idx = 0;
        int[] answer = new int[size];
        
        for(int i = a1; i <= b1; i++) {
            answer[idx++] = arr[i];
        }
        
        for(int i = a2; i <= b2; i++) {
            answer[idx++] = arr[i];
        }
        return answer;
    }
}