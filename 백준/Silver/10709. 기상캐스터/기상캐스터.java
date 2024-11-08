import java.util.*;
import java.lang.*;
import java.io.*;

class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[][] cloud = new char[H][W];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            char[] charArr = br.readLine().toCharArray();
            int index = -1;
            for (int j = 0; j < W; j++) {
                if (charArr[j] == 'c') {
                    sb.append(0);
                    index = j;
                } else if (index == -1) {
                    sb.append(-1);
                } else {
                    sb.append(j - index);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}