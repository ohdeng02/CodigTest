import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] liquid = new long[N];
        for (int i = 0; i < N; i++) {
            liquid[i] = Long.parseLong(st.nextToken());
        }
        
        int x1 = 0;
        int x2 = 0;

        long min = 1000000000 * 2;
        int left = 0;
        int right = N - 1;
        while (left < right) {
            long sum = liquid[left] + liquid[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                x1 = left;
                x2 = right;
            }
            if (sum >= 0) {
                right--;
            } else {
                left++;
            }
        }
        
        System.out.println(liquid[x1] + " " + liquid[x2]);
    }
}