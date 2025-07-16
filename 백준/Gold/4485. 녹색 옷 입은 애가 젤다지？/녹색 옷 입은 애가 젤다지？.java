import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int row;
    int col;
    int cost;

    public Node(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node n) {
        return this.cost - n.cost;
    }
}

class Main {
    static int N;
    static int[][] dist;
    static boolean[][] visited;
    static int[][] cave;
    static int INF = Integer.MAX_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            
            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = INF;
                }
            }
            
            cave = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            daijkstra();
            sb.append("Problem ").append(count).append(": ").append(dist[N-1][N-1]).append("\n");            
            count++;
        }

        System.out.println(sb);
    }

    static void daijkstra() {
        visited = new boolean[N][N];
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(0, 0, cave[0][0]));
        dist[0][0] = cave[0][0];

        while (!q.isEmpty()) {
            Node current = q.poll();
            if (!visited[current.row][current.col]) {
                visited[current.row][current.col] = true;
                for (int i = 0; i < 4; i++) {
                    int mx = current.col + dx[i];
                    int my = current.row + dy[i];
                    if (mx >= 0 && mx < N && my >= 0 && my < N && !visited[my][mx]) {
                        if (dist[my][mx] > dist[current.row][current.col] + cave[my][mx]) {
                            dist[my][mx] = dist[current.row][current.col] + cave[my][mx];
                            q.offer(new Node(my, mx, dist[my][mx]));
                        }
                    }
                }   
            }
        }

    }
}