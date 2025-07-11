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
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        int start = Integer.parseInt(br.readLine());   
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, dis));
        }

        dijkstra(start);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));
        dist[start] = 0;

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
    }
}