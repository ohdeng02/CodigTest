import java.util.*;

class Solution {
    static int N;
    static int[][] computerList;
    static int answer = 0;
    static boolean[] visited;
    static void DFS(int idx) {
        visited[idx] = true;
        for (int j = 0; j < N; j++) {
            if (j != idx && computerList[idx][j] == 1 && visited[j] == false) {
                DFS(j);
            }
        }
    }
        
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        N = n;
        computerList = computers;
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                answer++;
                DFS(i);
            }
        }
        
        return answer;
    }
}