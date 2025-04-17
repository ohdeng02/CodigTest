import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[N];
        int maxLen = -1;
        for (int i = 0; i < N; i++) {
            arr[i] = 1;
            for (int j = i - 1; j >= 0 ; j--) {
                if (A[i] < A[j] && arr[i] < arr[j] + 1) {
                    arr[i] = arr[j] + 1;
                }
            }
            maxLen = Math.max(maxLen, arr[i]);
        }
        
        System.out.println(maxLen);
    }
}