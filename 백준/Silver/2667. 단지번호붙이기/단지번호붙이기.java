import java.io.*;
import java.util.*;

public class Main {
    
    private static int dx[] = {0,0,1,-1};
    private static int dy[] = {1,-1,0,0};
    private static ArrayList<Integer> arr = new ArrayList<>();
    private static int N, count;
    private static int apartNum = 0; 
    private static boolean[][] visited = new boolean[25][25]; 
    private static int[][] map = new int[25][25]; 

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                count = 0;
                if(map[i][j] == 1 && !visited[i][j]){
                    apartNum++;
                    dfs(i,j);
                    arr.add(count);
                }
            }
        }

        Collections.sort(arr);
        System.out.println(apartNum);

        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) != 0){           
                System.out.println(arr.get(i));
            }
        }
    }
}