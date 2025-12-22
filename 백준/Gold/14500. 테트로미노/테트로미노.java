import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] paper;
    static boolean[][] visited;
    static int maxSum = 0;

    static void solve(int row, int col, int sum, int count) {
        if (count == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int mx = col + dx[i];
            int my = row + dy[i];

            if (mx >= 0 && mx < M && my >= 0 && my < N && !visited[my][mx]) {
                if (count == 2) {
                    visited[my][mx] = true;
                    solve(row, col, sum + paper[my][mx], count + 1);
                    visited[my][mx] = false;
                }
                visited[my][mx] = true;
                solve(my, mx, sum + paper[my][mx], count + 1);
                visited[my][mx] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                solve(i, j, paper[i][j], 1);
                visited[i][j] = false;
            }
        }
        
        System.out.println(maxSum);
    }
}