import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        int[][] loc = new int[r][c];

        int[] dc = {0, 1, 0, -1}; //남동북서
        int[] dr = {1, 0, -1, 0};
        int x = 1;
        int y = 1;

        if (k > r * c) {
            System.out.println(0);
        } else {
            int dir = 0;
            loc[0][0] = 1;
            for (int i = 2; i <= k; i++) {
                y += dr[dir];
                x += dc[dir];
                loc[y - 1][x - 1] = 1;
                if ((y == r && x == 1) || (y == r && x == c) || (y == 1 && x == c) || loc[y + dr[dir] - 1][x + dc[dir] - 1] == 1) {
                    dir = (dir + 1)  % 4;
                }  
            }
            System.out.println(x + " " + y);
        }
    }
}