import java.util.*;

class Solution {
    public int solution(String[] strArr) {        
        int[] arr = new int[31];
        for (String s : strArr) {
            arr[s.length()]++;
        }
        
        Arrays.sort(arr);
        int answer = arr[arr.length-1];
        
        return answer;
    }
}