import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());       
        int answer = 0;
        
        int[][] rooms = new int[6][2]; //1~6, 남/여
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken()) - 1;
            rooms[grade][gender]++;
        }

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] > 0) {
                    answer += (rooms[i][j] - 1) / K + 1;
                }
            }
        }
        
        System.out.println(answer);
    }
}