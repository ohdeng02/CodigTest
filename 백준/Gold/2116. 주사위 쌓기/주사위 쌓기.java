import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] dice = new int[N][6];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        int[] pair = {5, 3, 4, 1, 2, 0};
        for (int i = 0; i < 6; i++) {
            int over = dice[0][i];
            int under = dice[0][pair[i]];

            int max = 0;
            int sum = 0;
            for (int j = 0; j < 6; j++) {
                if (j != i && j != pair[i]) {
                    max = Math.max(max, dice[0][j]);
                }
            }
            sum += max;

            // 나머지 주사위들 최대값 구하기
            for (int j = 1; j < N; j++) {
                max = 0;
                under = over;
                int index = 0;
                while (dice[j][index] != under) {
                    index++;
                }
                over = dice[j][pair[index]];

                for (int k = 0; k < 6; k++) {
                    if (k != index && k != pair[index]) {
                        max = Math.max(max, dice[j][k]);
                    }
                }
                sum += max;
            }
            result = Math.max(result, sum);
        }

        System.out.println(result);
    }
}