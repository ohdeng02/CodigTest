import java.util.*;
import java.io.*;

class Tomato {
    int x;
    int y;
    int z;

    public Tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Main {
    static int N, M, H;
    static int[][][] box;
    static int[][][] dis;
    static int[] dx = {1, 0, -1, 0, 0, 0}; //동남서북위아래
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Tomato> queue;
    static int count = 0;
    
    static void BFS() {
        while(!queue.isEmpty()) {
                Tomato node = queue.poll();
                for (int j = 0; j < 6; j++) {
                    int mx = node.x + dx[j];
                    int my = node.y + dy[j];
                    int mz = node.z + dz[j];
                    if (mx >= 0 && mx < M && my >= 0 && my < N && mz >= 0 && mz < H && box[mz][my][mx] == 0) {
                        box[mz][my][mx] = 1;
                        queue.offer(new Tomato(mx, my, mz));
                        dis[mz][my][mx] = dis[node.z][node.y][node.x] + 1;
                        count = Math.max(count, dis[mz][my][mx]);
                    }
                }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행
        H = Integer.parseInt(st.nextToken()); // 높이
        
        box = new int[H][N][M];
        dis = new int[H][N][M];
        queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) queue.offer(new Tomato(k, j, i));
                }
            }
        }

        BFS();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0 ; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        count = -1;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}