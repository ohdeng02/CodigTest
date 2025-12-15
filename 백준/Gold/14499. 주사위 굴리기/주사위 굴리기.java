import java.util.*;
import java.io.*;

class Main {
    static int[] dx = {1, -1, 0, 0}; // 동서북남
    static int[] dy = {0, 0, -1, 1};
    static int[] dice = new int[6]; // 아, 동, 남, 서, 북, 위
    static void move(int dir) { // 1동 2서 3북 4남
        int[] newDice = new int[6];
        if (dir == 1) { // 동
            newDice[0] = dice[1];
            newDice[1] = dice[5];
            newDice[2] = dice[2];
            newDice[3] = dice[0];
            newDice[4] = dice[4];
            newDice[5] = dice[3];
        } else if (dir == 2) { // 서
            newDice[0] = dice[3];
            newDice[1] = dice[0];
            newDice[2] = dice[2];
            newDice[3] = dice[5];
            newDice[4] = dice[4];
            newDice[5] = dice[1];
        } else if (dir == 3) { // 북
            newDice[0] = dice[4];
            newDice[1] = dice[1];
            newDice[2] = dice[0];
            newDice[3] = dice[3];
            newDice[4] = dice[5];
            newDice[5] = dice[2];
        } else { // 남
            newDice[0] = dice[2];
            newDice[1] = dice[1];
            newDice[2] = dice[5];
            newDice[3] = dice[3];
            newDice[4] = dice[0];
            newDice[5] = dice[4];
        }
        dice = newDice;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int order = Integer.parseInt(st.nextToken());
            int mx = x + dx[order - 1];
            int my = y + dy[order - 1];
            if (mx < 0 || mx >= M || my < 0 || my >= N) continue;
            
            move(order);
            x = mx;
            y = my;
            if (map[y][x] == 0) map[y][x] = dice[0];
            else {
                dice[0] = map[y][x];
                map[y][x] = 0;
            }
            
            sb.append(dice[5]).append("\n");
        }

        System.out.println(sb);
    }
}