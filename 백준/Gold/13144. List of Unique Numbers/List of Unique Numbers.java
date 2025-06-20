import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long count = 0;
        int[] digit = new int[100001];
        int left = 0;
        int right = 0;
        while(left < N) {
            while(right + 1 <= N && digit[nums[right]] == 0) {
                digit[nums[right++]]++;
            }
            count += right - left;
            digit[nums[left++]]--;
        }

        System.out.println(count);
    }
}