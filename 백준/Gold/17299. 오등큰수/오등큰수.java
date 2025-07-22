import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N + 1];
        int[] count = new int[1000001];
        int[] answer = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            count[nums[i]]++;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            while (!stack.empty() && count[nums[i]] > count[nums[stack.peek()]]) {
                answer[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            answer[stack.pop()] = -1;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}