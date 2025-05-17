import java.util.*;
import java.io.*;
  
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(nums);
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;
            while (start < end) {
                if (start == i || end == i) {
                    if (start == i) start++;
                    else end--;
                } else {
                    long now = nums[start] + nums[end];
                    if (now == nums[i]) {
                        answer++;
                        break;
                    } else if (now < nums[i]) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}