import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int L = Integer.parseInt(st.nextToken()); 

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        // 행 기준
        boolean[][] check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            boolean flag = true; 
            for (int j = 0; j < N - 1; j++) {
                int diff = map[i][j] - map[i][j + 1];

                if (Math.abs(diff) > 1) {
                    flag = false;
                    break; // 차이가 1이상 나는 경우
                }
                else if (diff == -1) { // diff가 -1 (올라가는 경사)
                    for (int k = 0; k < L; k++) {
                        if (j - k < 0 || map[i][j - k] != map[i][j] || check[i][j - k]) {
                            flag = false;
                            break;
                        }
                        check[i][j - k] = true;
                    }   
                }
                else if (diff == 1) { // diff가 +1 (내려가는 경사)
                    for (int k = 1; k <= L; k++) {
                        if (j + k >= N || map[i][j + k] != map[i][j] - 1|| check[i][j + k]) {
                            flag = false;
                            break;
                        }
                        check[i][j + k] = true;
                    } 
                }
                if (!flag) break;
            }
            if (flag) {
                answer++;
            }
        }
        // 열 기준
        check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            boolean flag = true; 
            for (int j = 0; j < N - 1; j++) {
                int diff = map[j][i] - map[j + 1][i];

                if (Math.abs(diff) > 1) {
                    flag = false;
                    break; // 차이가 1이상 나는 경우
                }
                else if (diff == -1) { // diff가 -1 (올라가는 경사)
                    for (int k = 0; k < L; k++) {
                        if (j - k < 0 || map[j - k][i] != map[j][i] || check[j - k][i]) {
                            flag = false;
                            break;
                        }
                        check[j - k][i] = true;
                    }   
                }
                else if (diff == 1) { // diff가 +1 (내려가는 경사)
                    for (int k = 1; k <= L; k++) {
                        if (j + k >= N || map[j + k][i] != map[j][i] - 1|| check[j + k][i]) {
                            flag = false;
                            break;
                        }
                        check[j + k][i] = true;
                    } 
                }
                if (!flag) break;
            }
            if (flag) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}