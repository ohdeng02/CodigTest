import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int v;
    int cost;

    public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
    }

    @Override
    public int compareTo(Node n) {
        return this.cost - n.cost;
    }
}
class Main {
    
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    static int V, E;
    static final int INF = 200000000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        for (int i = 1; i <= V; i++) { 
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, dis));
            graph[b].add(new Node(a, dis));
        }

        st = new StringTokenizer(br.readLine());
        int ma = Integer.parseInt(st.nextToken());
        int mb = Integer.parseInt(st.nextToken());
        int answer = -1;

        // case1) 1 -> v1 -> v2 -> V
        int result1 = daijkstra(1, ma);
        result1 += daijkstra(ma, mb);
        result1 += daijkstra(mb, V);

        // case2) 1 -> v2 -> v1 -> V
        int result2 = daijkstra(1, mb);
        result2 += daijkstra(mb, ma);
        result2 += daijkstra(ma, V);

        if (result1 >= INF && result2 >= INF) answer = -1;
        else answer = Math.min(result1, result2);
        System.out.println(answer);
    }

    static int daijkstra(int v1, int v2) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        Arrays.fill(dist, INF);
        q.offer(new Node(v1, 0));
        visited = new boolean[V + 1];
        dist[v1] = 0;

        while (!q.isEmpty()) {
            Node current = q.poll();
            if (!visited[current.v]) {
                visited[current.v] = true;
                for (int i = 0; i < graph[current.v].size(); i++) {
                    Node next = graph[current.v].get(i);
                    if (dist[next.v] > dist[current.v] + next.cost) {
                        dist[next.v] = dist[current.v] + next.cost;
                        q.offer(new Node(next.v, dist[next.v]));
                    }
                }
            }
        }
        
        return dist[v2];
    }
}