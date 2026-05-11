import java.util.*;

class Node {
    int idx;
    String str;
    public Node(int idx, String str) {
        this.idx = idx;
        this.str = str;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            int cnt = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j)) cnt++;
            }
            if (cnt == 1) queue.offer(new Node(i, words[i]));
        }
        
        int index = -1;
        while (!queue.isEmpty()) {
            answer++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Node node = queue.poll();
                visited[node.idx] = true;
                if (node.str.equals(target)) {
                    index = node.idx;
                    return answer;
                }
                for (int i = 0; i < words.length; i++) {
                    int cnt = 0;
                    if (visited[i]) continue;
                    for (int j = 0; j < node.str.length(); j++) {
                        if (node.str.charAt(j) != words[i].charAt(j)) cnt++;
                    }   
                    if (cnt == 1) queue.offer(new Node(i, words[i]));
                }    
            }
            
        }
        
        if (queue.isEmpty() && index == -1) answer = 0;
        return answer;
    }
}