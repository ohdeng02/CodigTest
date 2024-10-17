import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[][] dp = new int[3][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0][0] = Integer.parseInt(st.nextToken());
        dp[1][0] = 1;
        dp[2][0] = 1;
        int maxLength = 1;
        for (int i = 1; i < N; i++) {
            dp[0][i] = Integer.parseInt(st.nextToken());
            if (dp[0][i] >= dp[0][i - 1]) {
                dp[1][i] = dp[1][i - 1] + 1;
            } else {
                dp[1][i] = 1;
            }
            if (dp[0][i] <= dp[0][i - 1]) {
                dp[2][i] = dp[2][i - 1] + 1;
            } else {
                dp[2][i] = 1;
            }
            maxLength = Math.max(maxLength, Math.max(dp[1][i], dp[2][i]));
        }

        System.out.println(maxLength);
    }
}