import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] paper = new int[101][101];
        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    paper[j][i] = 1;
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int result = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (paper[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int x = j + dx[k];
                        int y = i + dy[k];

                        if(inRange(x, y) && paper[y][x] == 0)
                            result++;
                        else if(!inRange(x, y))
                            result++;
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static boolean inRange(int x, int y) {
        return x >= 1 && x <= 100 && y >= 1 && y <= 100;
    }
}