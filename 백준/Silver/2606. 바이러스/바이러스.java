import java.util.*;
import java.io.*;

class Node {
    int value;
    int nextNode;
    public Node(int value, int nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }
}

class Main {
    static int N, M;
    static int count = 0;
    static boolean[][] connect;
    static boolean[] visited;
    
    static void DFS(int node) {
        visited[node] = true;
        count++;
        for (int i = 1; i <= N; i++) {
            if (connect[node][i] == true && !visited[i]) {
                DFS(i);
            }
        }        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        connect = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connect[a][b] = connect[b][a] = true;
        }

        DFS(1);
        System.out.println(count - 1);
    }
}