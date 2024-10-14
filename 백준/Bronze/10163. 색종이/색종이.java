import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] location = new int[1001][1001];

        for (int i = 1; i <= N; i++) {
            int[] paper = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                paper[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < paper[2]; j++) { 
                for (int k = 0; k < paper[3]; k++) { 
                    location[paper[1] + k][paper[0] + j] = i;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 1; k <= N; k++) {
            int count = 0;
            sb = new StringBuilder();
            for (int i = 0; i < 1001; i++) {
                for (int j = 0; j < 1001; j++) {
                    if (location[i][j] == k) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}