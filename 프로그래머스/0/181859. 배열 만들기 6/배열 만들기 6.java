import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stk.isEmpty()) {
                stk.push(arr[i]);
            } else if (stk.peek() == arr[i]) {
                stk.pop();
            } else {
                stk.push(arr[i]);
            }
        }
        if (stk.isEmpty()) stk.push(-1);
        
        int size = stk.size();
        int[] answer = new int[size];
        for (int j = 0; j < size; j++) {
            answer[j] = stk.get(j);
        }
        return answer;
    }
}