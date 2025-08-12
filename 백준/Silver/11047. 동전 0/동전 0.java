import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (K == 0) break;
            int value = arr.get(i);
            answer += K / value;
            K = K % value;
        }

        System.out.println(answer);
    }
}