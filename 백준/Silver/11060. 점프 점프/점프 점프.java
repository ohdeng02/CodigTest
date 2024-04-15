import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] miro = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            miro[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1001;
        }
        
        dp[0] = 0;
        for(int i = 0; i < N; i++){
            for(int j = 1; j <= miro[i]; j++){
                if(i+j >= N) break;
                dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }
        System.out.println(dp[N-1] == 1001 ? -1 : dp[N-1]);
    }
}