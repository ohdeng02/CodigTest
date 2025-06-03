import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[26];
        for (int i = 0; i < N; i++) {
            int chIdx = -1;
            String s = br.readLine();
            String[] arr = s.split(" ");
            //1. 각 단어 첫글자
            int arrIdx = 0;
            for (int j = 0; j < arr.length; j++) {
                int idx = Character.toUpperCase(arr[j].charAt(0)) - 'A';
                if (dp[idx] == 0) {
                    dp[idx] = 1;
                    chIdx = arrIdx;
                    break;
                }
                arrIdx += arr[j].length() + 1;
            }

            // 2.왼쪽부터 순서대로 가능한것 확인
            if (chIdx == -1) {
                for (int j = 1; j < s.length(); j++) {
                    if (s.charAt(j) == ' ') continue;
                    int idx = Character.toUpperCase(s.charAt(j)) - 'A';
                    if (dp[idx] == 0) {
                        dp[idx] = 1;
                        chIdx = j;
                        break;
                    }
                }
            }

            // 문자열 추가
            for (int j = 0; j < s.length(); j++) {
                if (j == chIdx) {
                    sb.append("[").append(s.charAt(j)).append("]");
                } else {
                    sb.append(s.charAt(j));
                }
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}