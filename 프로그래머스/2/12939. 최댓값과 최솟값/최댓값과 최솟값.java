import java.util.Arrays;

class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        String[] strArr = s.split(" ");
        for (String str : strArr) {
            int digit = Integer.parseInt(str);
            min = Math.min(digit, min);
            max = Math.max(digit, max);
        }
        
        String answer = min + " " + max;
        return answer;
    }
}