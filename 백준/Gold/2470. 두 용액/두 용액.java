import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        int start = 0, end = N - 1;
        int startRes = 0, endRes = 0;
        int min = Integer.MAX_VALUE;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                startRes = numbers[start];
                endRes = numbers[end];
                if (sum == 0) break;
            }
            if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(startRes + " " + endRes);
    }
}