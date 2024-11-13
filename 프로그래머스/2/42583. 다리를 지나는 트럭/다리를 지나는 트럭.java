import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        // 큐 생성
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++){
            bridge.offer(0);
        }
        
        // 다리 길이가 1이거나 트럭 개수가 1일 경우, return
        if (bridge_length == 1) {
            return truck_weights.length+1;
        }
        if (truck_weights.length == 1) {
            return bridge_length+1;
        }
        
        int index = 0;
        int currentWeight = 0;
        
        // 트럭의 개수만큼 반복
        while (index < truck_weights.length) {
            // 현재 다리에 존재하는 맨 앞 트럭의 무게를 빼기
            currentWeight -= bridge.poll();
            answer++;  // 새로운 트럭 넣기
            
            // 현재 다리의 트럭 무게 + 들어올 트럭 무게 와 weight 비교
            if (weight >= currentWeight + truck_weights[index]) {
                bridge.offer(truck_weights[index]);
                currentWeight += truck_weights[index++];
            } else {
                // 이외의 경우 0을 삽입
                bridge.offer(0);
            }
        }
        
        // 지금까지 건너온 answer 값에 마지막 트럭 건너는 것까지 + bridge_length
        return answer + bridge_length;
    }
}