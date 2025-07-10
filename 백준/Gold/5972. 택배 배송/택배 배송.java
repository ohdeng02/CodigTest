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
    static int N, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, dis));
            graph[b].add(new Node(a, dis));
        }

        dijkstra();
        System.out.println(dist[N]);
    }

    static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[1] = 0;
        q.offer(new Node(1, 0));

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