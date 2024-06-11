import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        // int[] answer;
        //List<Integer> answer = new ArrayList<>();
//         int firstIdx = 0, lastIdx = 0;
//         int count = 0;
    
//         for (int i = 0; i < arr.length; i++) {
//             if (arr[i] == 2) {
//                 firstIdx = i;
//                 count++;
//                 break;
//             }
//         }

//         for (int i = arr.length-1; i >= firstIdx; i--) {
//             if (arr[i] == 2) {
//                 lastIdx = i;
//                 break;
//             }
//         }        
        
//         if (count == 0) {
//             answer = new int[] {-1};
//         } else {
//             answer = new int[lastIdx - firstIdx + 1];
//             int idx = 0;
//             for (int i = firstIdx; i <= lastIdx; i++) {
//                 answer[idx++] = arr[i];
//             }
//         }
        
//         return answer;

        int[] answer = {};
        int start = -1;
        int end = -1;

        for(int i=0;i<arr.length;i++){
            if(arr[i]==2){
                if(start==-1){
                    start = i;
                }
                end = i;
            }
        }

        if(start==-1){
            answer = new int[]{-1};
        }else{

            answer = Arrays.copyOfRange(arr,start,end+1);
        }

        return answer;
    }
}