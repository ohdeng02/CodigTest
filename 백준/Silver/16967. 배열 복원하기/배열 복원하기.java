import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] arrA = new int[h][w];
        int[][] arrB = new int[h+x][w+y];
        
        for (int i = 0; i < arrB.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arrB[0].length; j++) {
                arrB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i >= x && j >= y) {
                    arrA[i][j] = arrB[i][j] - arrA[i-x][j-y];
                } else {
                    arrA[i][j] = arrB[i][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(arrA[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}