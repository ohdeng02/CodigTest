import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int answer = -1;
    static boolean[][] connect;
    static boolean[] visited;
    
    static void DFS(int a, int b, int count) {
        if (a == b) {
            answer = count;
            return;
        }
        
        visited[a] = true;        
        for (int i = 1; i <= N; i++) {
            if (connect[a][i] == true && !visited[i]) {
                DFS(i, b, count + 1);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        M = Integer.parseInt(br.readLine());
        connect = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            connect[x][y] = connect[y][x] = true;
        }

        DFS(a, b, 0);
        System.out.println(answer);
    }
}