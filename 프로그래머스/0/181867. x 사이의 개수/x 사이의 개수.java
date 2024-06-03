import java.util.*;

class Solution {
    public int[] solution(String myString) {
        
        int[] answer = {};
        String[] arr = myString.split("x");

        int len = myString.length();
        if(myString.charAt(len-1) == 'x') {
            answer = new int[arr.length+1];
        } else {
            answer = new int[arr.length];
        }
        
        for(int i = 0; i < arr.length; i++) {
            answer[i] = arr[i].length();
        }
        
        if(answer.length > arr.length) {answer[arr.length] = 0;}
        return answer;
    }
}