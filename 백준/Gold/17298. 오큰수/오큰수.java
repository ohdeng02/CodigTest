import java.util.*;
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

        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            int size = stack.size();
            while (!stack.isEmpty()) {
                if (numbers[i] >= numbers[stack.peek()]) {
                    stack.pop();
                } else {
                    result[i] = numbers[stack.peek()];
                    break;
                }
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            }
            stack.push(i);
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : result) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
}