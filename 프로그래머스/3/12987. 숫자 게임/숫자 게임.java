import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int score = 0;
        int length = A.length;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int Bindex = length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (B[Bindex] > A[i]) {
                score++;
                Bindex--;
            }
        }
        
        return score;
    }
}