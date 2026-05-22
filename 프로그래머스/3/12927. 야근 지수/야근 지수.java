import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        // 피로도 = sum(남은 일 **2)
        // 남은 작업량이 균일하게 모두 작은게 좋음
        // 큰 수부터 처리하기
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        });
        
        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        
        while (n > 0) {
            if (pq.isEmpty()) break;
            int value = pq.poll();
            n--;
            value--;
            if (value > 0) pq.add(value);
        }
        
        long answer = 0;
        for (Integer i : pq) {
            answer += i * i;
        }
        
        return answer;
    }
}