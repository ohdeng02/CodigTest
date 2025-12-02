import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    static int rockX, rockY, N;
    static List<Point> nodeList;
    
    static boolean BFS(int sx, int sy) {
        Queue<Point> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        queue.offer(new Point(sx, sy));
        
        while(!queue.isEmpty()) {
            Point node = queue.poll();
            if (Math.abs(rockX - node.x) + Math.abs(rockY - node.y) <= 1000) return true;
            for (int i = 0; i < N; i++) {
                int distance = Math.abs(nodeList.get(i).x - node.x) + Math.abs(nodeList.get(i).y - node.y);
                if (distance <= 1000 && !visited[i]) {
                    queue.offer(nodeList.get(i));
                    visited[i] = true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            nodeList = new ArrayList<>();
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int homeX = Integer.parseInt(st.nextToken());
            int homeY = Integer.parseInt(st.nextToken());

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int x = (Integer.parseInt(st.nextToken()));
                int y = (Integer.parseInt(st.nextToken()));
                nodeList.add(new Point(x, y));
            }
            
            st = new StringTokenizer(br.readLine());
            rockX = Integer.parseInt(st.nextToken());
            rockY = Integer.parseInt(st.nextToken());            

            System.out.println(BFS(homeX, homeY) ? "happy" : "sad");
        }
    }
}