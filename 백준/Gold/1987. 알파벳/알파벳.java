import java.util.*;
import java.io.*;

class Main {
    static int R, C, max = 1;
    static Character[][] board;
    static int[] dx = {1, 0, -1, 0}; //동남서북
    static int[] dy = {0, 1, 0, -1};
    static boolean[] alphabet = new boolean[26];
    static boolean[][] visited;

    static void DFS(int x, int y, int count) {
        visited[y][x] = true;
        alphabet[board[y][x] - 'A'] = true;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx >= 0 && mx < C && my >= 0 && my < R && !visited[my][mx] && !alphabet[board[my][mx]- 'A']) {
                DFS(mx, my, count + 1);
            }
        }
        max = Math.max(max, count);
        visited[y][x] = false;
        alphabet[board[y][x] - 'A'] = false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new Character[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        DFS(0, 0, 1);
        System.out.println(max);
    }
}