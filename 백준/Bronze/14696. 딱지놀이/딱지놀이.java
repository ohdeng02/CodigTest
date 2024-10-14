import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            int[][] temp = new int[2][4];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                temp[0][Integer.parseInt(st.nextToken()) - 1]++;
            }
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                temp[1][Integer.parseInt(st.nextToken()) - 1]++;
            }

            for (int j = 3; j >= 0; j--) {
                if (temp[0][j] > temp[1][j]) {
                    sb.append("A");
                    break;
                } else if (temp[0][j] < temp[1][j]) {
                    sb.append("B");
                    break;
                } 
                if (j == 0) {
                    sb.append("D");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}