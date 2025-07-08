import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] buildings = new int[N + 1];
        int[] cnt = new int[N + 1];
        int[] near = new int[N + 1];
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
            near[i] = -100001;
        }

        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty()) {
                if (buildings[stack.peek()] <= buildings[i]) stack.pop();
                else break;
            }
            cnt[i] = stack.size();
            if (stack.size() > 0) near[i] = stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();
        for (int i = N; i > 0; i--) {
            while (!stack.isEmpty()) {
                if (buildings[stack.peek()] <= buildings[i]) stack.pop();
                else break;
            }
            cnt[i] += stack.size();
            if (stack.size() > 0 && i - near[i] > stack.peek() - i) near[i] = stack.peek();
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(cnt[i]);
            if (cnt[i] > 0) {
                sb.append(" ").append(near[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}