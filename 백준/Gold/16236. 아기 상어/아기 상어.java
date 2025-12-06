import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int x;
    int y;
    int distance;
    
    public Point(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
    
    @Override
    public int compareTo(Point p) {
        if (this.distance != p.distance) return this.distance - p.distance;
        else {
            if (this.y == p.y) return this.x - p.x;
            else return this.y - p.y;
        }
    }
}

class Main {
    static int N;
    static Point position;
    static int[][] space;
    static PriorityQueue<Point> queue;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;
    static int size = 2;

    static int BFS() {
        queue = new PriorityQueue<>();
        queue.offer(position);
        boolean[][] visited = new boolean[N][N];
        visited[position.y][position.x] = true;

        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            if (space[curr.y][curr.x] > 0 && space[curr.y][curr.x] < size) {
                space[curr.y][curr.x] = 0;
                position = new Point(curr.x, curr.y, 0);
                return curr.distance;
            }
            
            for (int j = 0; j < 4; j++) {
                int mx = curr.x + dx[j];
                int my = curr.y + dy[j];
                if (mx >= 0 && mx < N && my >= 0 && my < N && !visited[my][mx] && space[my][mx] <= size) {
                    visited[my][mx] = true;
                    queue.offer(new Point(mx, my, curr.distance + 1));
                }
            }
        }
        return -1;
    }
        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        space = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 9) position = new Point(j, i, 0);
            }
        }

        int time = 0;
        space[position.y][position.x] = 0;
        while(true) {   
            position.distance = 0;
            int L = BFS();
            if (L == -1) break;
            time += L;

            count++;
            if (size == count) {
                size++;
                count = 0;
            }
        }

        System.out.println(time);
    }
}