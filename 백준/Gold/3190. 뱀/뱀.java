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

class Rotation {
    int x;
    char c;
    public Rotation(int x, char c) {
        this.x = x;
        this.c = c; // L: 왼쪽, D: 오른쪽
    }
}

class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int dir = 0; // 초기방향 오른쪽

    static void changeDir(Rotation rotate) {
        if (rotate.c == 'L') dir = (dir + 3) % 4;
        else dir = (dir + 1) % 4;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] board = new int[N + 1][N + 1]; // 사과:1, 뱀:2, 빈값:0
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row][col] = 1; 
        }

        int L = Integer.parseInt(br.readLine());
        Queue<Rotation> queue = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            queue.offer(new Rotation(x, c));
        }

        int time = 0;
        List<Point> snake = new ArrayList<>();
        snake.add(new Point(1, 1));
        board[1][1] = 2;   
        
        while(true) {
            time++;
            Point head = snake.get(snake.size() - 1);
            int mx = head.x + dx[dir];
            int my = head.y + dy[dir];
            if (mx <= 0 || mx > N || my <= 0 || my > N || board[my][mx] == 2) break; // 벽 or 자기자신 부딪힐 경우
            if (board[my][mx] == 0) {
                Point tail = snake.remove(0);
                board[tail.y][tail.x] = 0;
            }
            board[my][mx] = 2;
            snake.add(new Point(mx, my));

            if (!queue.isEmpty() && queue.peek().x == time) changeDir(queue.poll());
        }

        System.out.println(time);
    }
}