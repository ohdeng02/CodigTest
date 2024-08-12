import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
         if (arr.length == 1) {
            arr[0] = -1; 
            return arr; 
        }

        int minIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[minIndex] > arr[i]) {
                minIndex = i; 
            }
        }

        int[] result = new int[arr.length - 1];

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != minIndex) {
                result[index++] = arr[i]; 
            }
        }

        return result; 
    }
}