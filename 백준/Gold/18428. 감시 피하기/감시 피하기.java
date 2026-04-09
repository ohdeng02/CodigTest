import java.util.*;
import java.lang.*;
import java.io.*;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    static int N;
    static char[][] hall;
    static List<Point> teacher;
    static int[] dx = {1, 0, -1, 0}; //동남서북
    static int[] dy = {0, 1, 0, -1};

    static void recurse(int objCnt) {
        if(objCnt == 3) {
            // 모든 학생 숨겨지는지 확인
            for (Point p : teacher) {
                for (int i = 0; i < 4; i++) { // 동서남북 확인
                    int mx = p.x + dx[i];
                    int my = p.y + dy[i];
                    Queue<Character> queue = new LinkedList<>();
                    while (mx >= 0 && mx < N && my >= 0 && my < N) { // 이동위치가 범위 내 
                        if (hall[my][mx] == 'O' || hall[my][mx] == 'S') queue.offer(hall[my][mx]);
                        mx += dx[i];
                        my += dy[i];
                    }
                    if(!queue.isEmpty() && queue.poll() == 'S') return;
                }
            }
            System.out.println("YES");
            System.exit(0);
        }
        
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (hall[i][j] == 'X') {
                    hall[i][j] = 'O';
                    recurse(objCnt + 1);
                    hall[i][j] = 'X';
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        hall = new char[N][N];
        teacher = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                hall[i][j] = st.nextToken().charAt(0);
                if (hall[i][j] == 'T') teacher.add(new Point(j, i));
            }
        }

        recurse(0);
        System.out.println("NO");
    }
}