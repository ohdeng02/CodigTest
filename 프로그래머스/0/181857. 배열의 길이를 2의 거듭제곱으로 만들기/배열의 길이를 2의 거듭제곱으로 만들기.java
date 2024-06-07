import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
//         int idx = 0, square = 0;
//         int length = arr.length;
        
//         for(int i = 0; i <= 10; i++) {
            
//             square = (int)Math.pow(2, i);
//             if(length < square) {
//                 idx = i;
//                 break;
//             } else if (length == square) {
//                 return arr;
//             }
//         }
        
//         int[] answer = new int[square];
//         for(int i = 0; i < length; i++) {
//             answer[i] = arr[i];
//         }
        int length = 1;
        
        while(length < arr.length) {
            length *= 2;
        }
        
        //return answer;
        return Arrays.copyOf(arr, length);
    }
}