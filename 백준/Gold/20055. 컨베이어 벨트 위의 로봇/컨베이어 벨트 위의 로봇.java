import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] belt = new int[2 * N];
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] robot = new boolean[N];

        int kcount = 0;
        int answer = 0;
        while (kcount < K) {
            answer++;
            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            int temp = belt[0];
            for (int i = 0; i < 2 * N - 1; i++) {
                int tmp = temp;
                temp = belt[i + 1];
                belt[i + 1] = tmp;
            }
            belt[0] = temp;
            boolean temp2 = robot[0];
            for (int i = 0; i < N - 1; i++) {
                boolean tmp = temp2;
                temp2 = robot[i + 1];
                robot[i + 1] = tmp;
            }
            robot[0] = false;
            if (robot[N - 1]) robot[N - 1] = false;
            
            // 2.가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
            for (int i = N - 2; i >= 0; i--) {
                if (robot[i] && !robot[i + 1] && belt[i + 1] >= 1) {
                    belt[i + 1]--;
                    if (belt[i + 1] == 0) kcount++;
                    robot[i] = false;
                    robot[i + 1] = true;
                }
            }
            if (robot[N - 1]) robot[N - 1] = false;
            
            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if (belt[0] != 0) {
                belt[0]--;
                if (belt[0] == 0) kcount++;
                robot[0] = true;                
            }
        }
        System.out.println(answer);
    }
}