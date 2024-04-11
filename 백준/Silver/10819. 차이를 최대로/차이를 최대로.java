import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] nums;
    static boolean[] visited;
    static int[] selected;
    static int max = 0;

    public static int getTotal() {
        int sum = 0;
        for(int i=0; i<N-1; i++){
            sum += Math.abs(selected[i] - selected[i+1]);
        }
        return sum;
    }

    public static void dfs(int count){
        if(count == N){
            max = Math.max(max, getTotal());
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[count] = nums[i];
                dfs(count+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        visited = new boolean[N];
        selected = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(max);
    }
}