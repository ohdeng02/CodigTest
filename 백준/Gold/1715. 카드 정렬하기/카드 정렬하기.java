import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        long answer = 0;
        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            answer += a + b;
            pq.offer(a + b);
        }
        System.out.println(answer);
    }
}