import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀 개수
            int k = Integer.parseInt(st.nextToken()); // 문제 개수
            int t = Integer.parseInt(st.nextToken()); // 본인 팀ID
            int m = Integer.parseInt(st.nextToken()); // 로그 개수

            int[][] teams = new int[n + 1][k + 1]; 
            int[][] count = new int[n + 1][2];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                //팀, 문제, 점수
                int id = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                teams[id][q] = Math.max(s, teams[id][q]); // 기존 저장된 점수와 새로 입력받은 점수 최댓값 저장
                count[id][0]++;
                count[id][1] = j;
            }

            int[] score = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                for (int l = 1; l <= k; l++) {
                    score[j] += teams[j][l];
                }
            }

            int rank = 1;
            for (int j = 1; j <= n; j++) {
                if (score[t] < score[j]) {
                    rank++;
                } else if (score[t] == score[j] && t != j) {
                    if (count[t][0] == count[j][0]) {
                        rank = count[t][1] > count[j][1] ? rank + 1 : rank;
                    } else if (count[t][0] > count[j][0]){
                        rank++;
                    }
                }
            }
            sb.append(rank).append("\n");
        }
        System.out.println(sb);
    }
}