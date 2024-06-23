import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d};
        int[] temp = new int[4];
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i] == arr[j]) {
                    temp[i]++;
                }
            }
        }
        
        int high = Arrays.stream(temp).max().getAsInt();
        int low = Arrays.stream(temp).min().getAsInt();
        int p = 0, q = 0, answer;
        
        if (high == 4) {
            answer = 1111 * a;
        } else if (high == 3) {
            for (int i = 0; i < 4; i++) {
                if (temp[i] == 3) {
                    p = arr[i];
                }
                if (temp[i] == 1) {
                    q = arr[i];
                }
            }
            answer = (int)Math.pow(10 * p + q, 2);
        } else if (high == 2) {
            if (low == 1) {
                answer = 1;
                for (int i = 0; i < 4; i++) {
                    if (temp[i] != 2) {
                        answer *= arr[i];
                    }
                }
            } else {
                for (int i = 1; i < 4; i++) {
                    if (arr[i] != arr[0]) {
                        q = arr[i];
                    }
                }
                p = arr[0];
                answer = (p + q) * Math.abs(p - q);   
            }
        } else {
            answer = Arrays.stream(arr).min().getAsInt();
        }
        
        return answer;
    }
}