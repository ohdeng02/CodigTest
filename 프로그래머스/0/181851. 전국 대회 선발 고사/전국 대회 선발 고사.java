import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer;
        int[][] arr = new int[rank.length][2];
        
        for (int i = 0; i < rank.length; i++) {
            arr[i][0] = i;
            arr[i][1] = rank[i];
        }
        Arrays.sort(arr, (int[] e1, int[] e2) -> {
            return e1[1] - e2[1];
        });
        
        int idx = 0;
        int[] temp = new int[3];
        for (int i = 0; i < arr.length; i++) {
            if (attendance[arr[i][0]] == true) {
                temp[idx++] = arr[i][0];
            }
            if (idx == 3) break;
        }
        
        answer = 10000*temp[0] + 100*temp[1] + temp[2];
        return answer;
    }
}