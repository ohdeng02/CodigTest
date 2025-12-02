import java.util.*;
import java.io.*;

class Main {
    static int F, S, G, U, D;
    
    static int BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[F + 1];
        int L = 0;
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                if (x == G) return L;
                // visited[x] = true;
                if (x + U <= F && !visited[x + U]) {
                    queue.offer(x + U);
                    visited[x + U] = true;
                }
                if (x - D > 0 && !visited[x - D]) {
                    queue.offer(x - D);
                    visited[x - D] = true;
                }
            }
            L++;
        }

        return -1;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); 
        S = Integer.parseInt(st.nextToken()); 
        G = Integer.parseInt(st.nextToken()); 
        U = Integer.parseInt(st.nextToken()); 
        D = Integer.parseInt(st.nextToken()); 
        
        int count = BFS(S);
        System.out.println(count == -1 ? "use the stairs" : count);
    }
}