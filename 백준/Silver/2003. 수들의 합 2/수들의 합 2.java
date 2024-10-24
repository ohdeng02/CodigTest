import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        int count = 0;
        int start = 0, end = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        while (true) {
            if (sum >= M) {
                sum -= numbers[start++];
            } else if (end == N) {
                break;
            } else {
                sum += numbers[end++];
            }
            if (sum == M) {
                count++;
            }
        }
        System.out.println(count);
    }
}