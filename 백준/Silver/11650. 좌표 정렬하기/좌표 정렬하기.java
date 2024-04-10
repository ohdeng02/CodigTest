import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st; 
        
        int N = Integer.parseInt(br.readLine());
        int[][] numbers = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            numbers[i][0] = Integer.parseInt(st.nextToken());
            numbers[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // Arrays.sort(numbers, new Comparator<int[]>() {
        //     public int compare(int[] e1, int[] e2) {
        //         if(e1[0] == e2[0]) { // 첫번째 원소가 같다면 두 번째 원소끼리 비교
        //             return e1[1] - e2[1]; //기본값이 오름차순임
        //         } else {
        //             return e1[0] - e2[0];
        //         }
        //     }            
        // });

        Arrays.sort(numbers, (int[] e1, int[] e2) -> {
            if(e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        for(int i=0; i<N; i++){
            sb.append(numbers[i][0] + " " + numbers[i][1] + "\n");
        }
        System.out.println(sb);
    }
}