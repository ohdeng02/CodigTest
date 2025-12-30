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
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxCount = 0;

    static void seek(int i, int cnt) {
        if (cnt == 3) {
            BFS();
            return;
        }
        
        for (int l = i; l < N; l++) {
            for (int m = 0; m < M; m++) {
                if (map[l][m] == 0 && !check[l][m]) {
                    map[l][m] = 1;
                    check[l][m] = true;
                    seek(l, cnt + 1);
                    map[l][m] = 0;
                    check[l][m] = false;
                }
            }
        }
    }

    static void BFS() {
        int[][] temp = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) { // map복사
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
                if (map[i][j] == 2) {
                    queue.offer(new Point(j, i));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int mx = point.x + dx[i];
                int my = point.y + dy[i];
                if (mx >= 0 && mx < M && my >=0 && my < N && temp[my][mx] == 0) { //&& visited[my][mx] == false
                    queue.offer(new Point(mx, my));
                    // visited[my][mx] = true;
                    temp[my][mx] = 2;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) cnt++;
            }
        }

        maxCount = Math.max(maxCount, cnt);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        seek(0, 0);
        System.out.println(maxCount);
    }
}