import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        int[] days = new int[progresses.length];
        for (int i = 0; i < days.length; i++) {
            days[i] = (int)Math.ceil((100 - progresses[i]) / (float)speeds[i]); 
        }

        List<Integer> answer = new ArrayList<>();
        List<Integer> deploy = new ArrayList<>();
        answer.add(1);
        deploy.add(days[0]);
        int idx = 0;
        for (int i = 1; i < days.length; i++) {
            if (days[i] <= deploy.get(idx)) {
                answer.set(idx, answer.get(idx) + 1);
            } else {
                answer.add(1);
                deploy.add(days[i]);
                idx++;
            }
        }
        
        int[] array = new int[answer.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = answer.get(i);
        }
        return array;
    }
}