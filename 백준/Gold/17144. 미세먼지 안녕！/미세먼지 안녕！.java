import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    private static int[] dx = {1, -1, 0, 0}; 
    private static int[] dy = {0, 0, 1, -1}; 
    private static int[][] dustArea;
    private static int[][] diffused;
    private static int r, c, t;
    static int[] over = {0, 3, 1, 2}; 
    static int[] under = {0, 2, 1, 3};
    
    public static void diffusion(int i, int j) {
        int dust = dustArea[i][j] / 5;
        for (int k = 0; k < 4; k++) {
            int x = j + dx[k];
            int y = i + dy[k];
            if (x >= 0 && x < c && y >= 0 && y < r && dustArea[y][x] != -1) {
                diffused[y][x] += dust;
                dustArea[i][j] -= dust;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        dustArea = new int[r][c];
        int aY = 0;
        int answer = 0;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                dustArea[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < t; k++) {
            diffused = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (dustArea[i][j] > 0) {
                        diffusion(i, j);
                    } else if (dustArea[i][j] == -1) {
                        aY = i;
                    }
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    dustArea[i][j] += diffused[i][j];
                    if (dustArea[i][j] != -1 && k == 0) {
                        answer += dustArea[i][j];
                    }
                }
            }    
        
            int i = aY-1, j = 1;
            int pre = dustArea[i][1];
            int after;
            int seq = 0;
            
            while (true) {
                if (i+dy[over[seq]] < 0 || j+dx[over[seq]] < 0 || j+dx[over[seq]] >= c) {
                    seq++;
                } else {
                    i += dy[over[seq]];
                    j += dx[over[seq]];
                    if (dustArea[i][j] == -1) break;
                    after = dustArea[i][j];
                    dustArea[i][j] = pre;
                    pre = after;
                }
            }
            dustArea[aY-1][1] = 0;
            answer -= pre;
    
            i = aY; j = 1;
            pre = dustArea[i][1];
            seq = 0;
            while (true) {
                if (i+dy[under[seq]] >= r || j+dx[under[seq]] < 0 || j+dx[under[seq]] >= c) {
                    seq++;
                } else {
                    i += dy[under[seq]];
                    j += dx[under[seq]];
                    if (dustArea[i][j] == -1) break;
                    after = dustArea[i][j];
                    dustArea[i][j] = pre;
                    pre = after;
                }
            }
            dustArea[aY][1] = 0;
            answer -= pre;
        }
        System.out.println(answer);
    }
}