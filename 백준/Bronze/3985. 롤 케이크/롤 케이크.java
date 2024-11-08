import java.util.*;
import java.lang.*;
import java.io.*;

class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int predictMax = Integer.MIN_VALUE;
        int actualMax = Integer.MIN_VALUE;
        int predictNum = 0, actualNum = 0;
        int[] pieces = new int[L];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            if (K - P > predictMax) {
                predictMax = K - P;
                predictNum = i;
            }

            int cnt = 0;
            for (int j = P - 1; j < K; j++) {
                if (pieces[j] == 0) {
                    pieces[j] = i + 1;
                    cnt++;
                }
            }
            if (cnt > actualMax) {
                actualMax = cnt;
                actualNum = i;
            }
        }

        System.out.println(predictNum + 1);
        System.out.println(actualNum + 1);
    }
}