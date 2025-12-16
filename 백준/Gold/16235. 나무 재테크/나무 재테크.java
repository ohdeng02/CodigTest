import java.util.*;
import java.io.*;

class Main {
    static int[] dx = {0,0,-1,1,1,1,-1,-1}; // 근접지역
    static int[] dy = {1,-1,0,0,-1,1,-1,1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] nutrient = new int[N + 1][N + 1];
        List<Integer>[][] map = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                nutrient[i][j] = 5;
                map[i][j] = new ArrayList<>();
            }
        }
        
        int[][] A = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()); // 행
            int x = Integer.parseInt(st.nextToken()); // 열
            int z = Integer.parseInt(st.nextToken()); // 나이
            map[y][x].add(z);
        }

        for (int i = 0; i < K; i++) {
            // 봄, 여름
            for (int j = 1; j <= N; j++) {
                for (int l = 1; l <= N; l++) {
                    int size = map[j][l].size();
                    if (size > 0) {
                        Collections.sort(map[j][l]);
                        int index = 0;
                        boolean flag = false;
                        while (index < size) {
                            if (nutrient[j][l] - map[j][l].get(index) < 0) {
                                flag = true;
                                break;
                            }
                            nutrient[j][l] -= map[j][l].get(index);
                            map[j][l].set(index, map[j][l].get(index) + 1);
                            index++;
                        }
                        if (flag) { // 죽은 나무 존재시, 여름작업 시행
                            while (map[j][l].size() - index > 0) {
                                nutrient[j][l] += map[j][l].get(index) / 2;
                                map[j][l].remove(index);
                            }
                        }
                    }
                    
                }
            }

            //가을, 겨울
            for (int j = 1; j <= N; j++) {
                for (int l = 1; l <= N; l++) {
                    int size = map[j][l].size();
                    for (int m = 0; m < size; m++) {
                        if (map[j][l].get(m) % 5 == 0) { // 5의 배수 나무 존재시
                            for (int k = 0; k < 8; k++) {
                                int mx = l + dx[k];
                                int my = j + dy[k];
                                if (mx > 0 && mx <= N && my > 0 && my <= N) {
                                    map[my][mx].add(1); // 새로운 나무 번식
                                }
                            }
                        }
                    }
                    nutrient[j][l] += A[j][l];
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int size = map[i][j].size();
                count += size;
            }
        }
        System.out.println(count);
    }
}