import java.util.*;
import java.lang.*;
import java.io.*;

class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] location = new int[100][100];
        int extent = 0;
        
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1 - 1; j < y2 - 1; j++) {
                for (int k = x1 - 1; k < x2 - 1; k++) {
                    location[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (location[i][j] == 1) {
                    extent++;
                }
            }
        }
        System.out.println(extent);
    }
}