import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] score = {0, 0, 0};
        for(int i = 0; i < answers.length; i++){
            if(p1[i%5] == answers[i]) score[0]++;
            if(p2[i%8] == answers[i]) score[1]++;
            if(p3[i%10] == answers[i]) score[2]++; 
        }
        int maxScore = 0;
        for(int s : score){
            maxScore = Math.max(maxScore, s);
        }
        for(int i = 0; i < 3; i++) {
            if(maxScore == score[i]) answer.add(i+1);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}