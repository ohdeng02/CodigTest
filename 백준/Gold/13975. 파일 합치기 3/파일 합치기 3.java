import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int j = 0; j < K; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long answer = 0;
            while (pq.size() != 1) {
                long sum = pq.poll() + pq.poll();
                answer += sum;
                pq.offer(sum);
            }
            sb.append(answer).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}