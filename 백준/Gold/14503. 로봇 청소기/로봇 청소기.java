import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] state = new int[n][m];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                state[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            if (state[r][c] == 0) {
                answer++;
                state[r][c] = 2;
            }
            if (state[r+dy[0]][c+dx[0]] != 0 && state[r+dy[1]][c+dx[1]] != 0 
                && state[r+dy[2]][c+dx[2]] != 0 && state[r+dy[3]][c+dx[3]] != 0) {
                int backLoc = (d + 2) % 4;
                int backX = dx[backLoc];
                int backY = dy[backLoc];
                if (state[r + backY][c + backX] == 1) {
                    break;
                } else {
                    r += backY; 
                    c += backX;
                }
            } else {
                d = d-1 < 0 ? 3 : d-1;
                if (state[r + dy[d]][c + dx[d]] == 0) {
                    r += dy[d]; 
                    c += dx[d];
                }
            }
        }
        System.out.println(answer);
    }
}