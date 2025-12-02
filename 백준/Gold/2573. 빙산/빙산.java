import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    static int N, M;
    static int[] dx = {1, 0, -1, 0}; //동남서북
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static boolean[][] visited;

    static int seperateNum() {
        visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0 && !visited[i][j]) {
                    DFS(j, i);
                    count++;
                }
            }
        }

        return count;
    }

    static void DFS(int x, int y) {
        visited[y][x] = true;
        
        for (int j = 0; j < 4; j++) {
            int mx = x + dx[j];
            int my = y + dy[j];
            if (mx >= 0 && mx < M && my >= 0 && my < N && board[my][mx] != 0 && !visited[my][mx]) {
                DFS(mx, my);
            }
        }
    }
    
    static void melt() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) {
                    queue.offer(new Point(j, i));
                    check[i][j] = true;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            Point node = queue.poll();
            int count = 0;
            for (int j = 0; j < 4; j++) {
                int mx = node.x + dx[j];
                int my = node.y + dy[j];
                if (mx >= 0 && mx < M && my >= 0 && my < N && !check[my][mx] && board[my][mx] == 0) {
                    count++;
                }
            }
            board[node.y][node.x] = board[node.y][node.x] - count > 0 ? board[node.y][node.x] - count : 0;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            int island = seperateNum();
            if (island == 0) {
                year = 0;
                break;
            }
            else if (island >= 2) break;

            melt();
            year++;
        }
        
        System.out.println(year);
    }
}