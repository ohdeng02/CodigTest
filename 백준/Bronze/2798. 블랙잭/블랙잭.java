import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 0; i < N - 2; i++) {
            int sum = 0;
            sum += cards[i];
            for (int j = i + 1; j < N - 1; j++) {
                sum += cards[j];
                for (int k = j + 1; k < N; k++) {
                    sum += cards[k];
                    if (sum <= M && sum > result) result = sum;
                    sum -= cards[k];
                }
                sum -= cards[j];
            }
        }
        System.out.println(result);
    }
}