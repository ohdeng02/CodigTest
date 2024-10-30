import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //입력받는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력값 분리 StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //입력값 저장
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] input = new int[N+1][2];
        
        // dp배열 선언
        int[][] dp = new int[N+1][T+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // dp배열에 정보 저장
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= T; j++){
                //i번째 단원의 모든 내용을 학습할 수 있는 경우
                if (j >= input[i][0]){
                    //이전 최대값과 현재 최대값을 비교하여 최대값 갱신
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-input[i][0]] + input[i][1]);
                } else {
                    // 값을 그대로 저장
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        System.out.println(String.valueOf(dp[N][T])); // 결과 출력
    }
}