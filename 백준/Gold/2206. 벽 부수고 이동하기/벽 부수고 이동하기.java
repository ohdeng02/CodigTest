import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;
    boolean flag;

    public Node(int x, int y, boolean flag) {
        this.x = x;
        this.y = y;
        this.flag = flag;
    }
}

class Main {
    static int[][] map;
    static int[] dx = {1, 0, -1, 0}; 
    static int[] dy = {0, 1, 0, -1};
    static int N, M;

    static int BFS(Node node) {
        int L = 1;
        boolean[][][] visited = new boolean[N + 1][M + 1][2];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node value = queue.poll();
                if (value.x == M && value.y == N) return L;
                for (int j = 0; j < 4; j++) {
                    int nx = value.x + dx[j];
                    int ny = value.y + dy[j];
                    if (nx <= 0 || nx > M || ny <= 0 || ny > N) continue;
                    
                    if (map[ny][nx] == 0) {
                        if (!value.flag && !visited[ny][nx][0]) {
                            queue.offer(new Node(nx, ny, false));
                            visited[ny][nx][0] = true;
                        } else if (value.flag && !visited[ny][nx][1]) {
                            queue.offer(new Node(nx, ny, true));
                            visited[ny][nx][1] = true;
                        }
                    } else {
                        if (!value.flag) {
                            queue.offer(new Node(nx, ny, true));
                            visited[ny][nx][1] = true;
                        }
                    }
                }
            }
            L++;
        }
        return -1;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j - 1) - '0';
            }
        }
        
        int answer = BFS(new Node(1, 1, false));
        System.out.println(answer);
    }
}