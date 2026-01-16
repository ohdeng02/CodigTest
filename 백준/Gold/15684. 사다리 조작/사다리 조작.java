import java.util.*;
import java.io.*;

class Main {
    static int[][] ladder;
    static int N, M, H;
    static int answer = 4;
    
    static boolean play() {
        for (int i = 1; i <= N; i++) {
            int x = i;
            int y = 1;
            while(y <= H) {
                if (ladder[y][x] == 1) x++;
                else if (ladder[y][x - 1] == 1) x--;
                y++;
            }

            // System.out.println(i + " " + x);
            if (i != x) return false;
        }
        return true;
    }

    static void search(int count, int i, int j) {
        if (count == 3) {
            return;
        }
        
        while (i <= H) {
            while (j < N) {
                if (ladder[i][j] != 1 && ladder[i][j - 1] != 1) {
                    if (j + 1 < N && ladder[i][j + 1] == 1) {
                        j++; 
                        continue;
                    }
                    
                    ladder[i][j] = 1;
                    // System.out.println("추가설치: " + i + " " + j);
                    if (play()) {
                        answer = Math.min(answer, count + 1);
                        // System.out.println("갯수: " + answer);
                    }
                    // System.out.println(answer);
                    search(count + 1, i, j);
                    ladder[i][j] = 0;
                }
                j++;
            }
            j = 1;
            i++;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = 1;   
        }

        if (play()) answer = 0;
        search(0, 1, 1);
        if (answer > 3) answer = -1;
        System.out.println(answer);
    }
}