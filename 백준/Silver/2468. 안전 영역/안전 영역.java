import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0}; //동남서북
    static int[] dy = {0, 1, 0, -1};

    static void DFS(int x, int y, int limit) {
        visited[y][x] = true;
        
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx >= 0 && mx < N && my >= 0 && my < N && board[my][mx] > limit && !visited[my][mx]) {
                DFS(mx, my, limit);
            }
        }
    }

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        int min = 100;
        int max = 1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, board[i][j]);
                max = Math.max(max, board[i][j]);
            }
        }

        int answer = 1;
        for (int i = min; i <= max; i++) {
            int count = 0;
            visited = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (board[j][k] > i && !visited[j][k]) {
                        DFS(k, j, i);
                        count++;  
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        
        System.out.println(answer);
    }
}