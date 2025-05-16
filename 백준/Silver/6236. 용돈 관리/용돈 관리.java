import java.util.*;
import java.io.*;
  
public class Main {
    static int M;
    static int[] days;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        days = new int[N];
        int max = 0; // k의 최솟값
        for (int i = 0; i < N; i++) {
            days[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, days[i]);
        }
        
        int left = max;
        int right = 10000*100000;
        int result = 0;
        //이진탐색
        while (left <= right) {
            int mid = (left + right) / 2;
            if (M >= getCount(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    public static int getCount(int k) { // 현재 k값으로 몇 번 인출한지 카운트
        int cnt = 1;
        int current = k - days[0];
        for (int i = 1; i < days.length; i++) {
            if (current < days[i]) {
                cnt++;
                current = k;
            }
            current -= days[i];
        }
        return cnt;
    }
}