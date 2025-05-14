import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] ranking = new int[N];
        if (N != 0) st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ranking[i] = Integer.parseInt(st.nextToken());
        }

        int rank = -1;
        if (N != P || ranking[N - 1] < newScore) {
            rank = 1;
            for (int i = 0; i < N; i++) {
                if (newScore < ranking[i]) {
                     rank++;   
                } else {
                    break;
                }
            }            
        }          

        System.out.println(rank);
    }
}