import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            arr[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(1).append(" ");
        for (int i = 1; i < N; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (A[i] > A[j]) {
                    arr[i] += arr[j];
                    arr[i] %= 998244353;
                }
            }
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}