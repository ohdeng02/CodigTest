import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        if (arr1.length == arr2.length) {
            //int sum1 = 0, sum2 = 0;
            // for (int i = 0; i < arr1.length; i++) {
            //     sum1 += arr1[i];
            //     sum2 += arr2[i];
            // }
            int sum1 = Arrays.stream(arr1).sum();
            int sum2 = Arrays.stream(arr2).sum();
            
            if (sum1 != sum2) {
                answer = sum1 > sum2 ? 1 : -1;
            }
        } else {
            answer = arr1.length > arr2.length ? 1 : -1;
        }
        return answer;
    }
}