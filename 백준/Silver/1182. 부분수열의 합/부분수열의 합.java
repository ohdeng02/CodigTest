import java.io.*;
import java.util.*;

public class Main {
    static int N, S, result = 0;
    static int[] subsequence;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 정수의 개수
        S = Integer.parseInt(st.nextToken()); // 타깃 넘버
        subsequence = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            subsequence[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);


        if (S == 0) {
            result--;
        }
        System.out.println(result);


        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                result++;
            }
            return;
        }
        dfs(depth + 1, sum + subsequence[depth]);
        dfs(depth + 1, sum);
    }
}