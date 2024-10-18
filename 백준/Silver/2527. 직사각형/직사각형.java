import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            if (x1 <= p2 && x2 <= p1 && y1 <= q2 && y2 <= q1) { //직사각형 겹치는 경우
                if (x1 == p2 || x2 == p1 || y1 == q2 || y2 == q1) {
                    if ((x1 == p2 && q1 == y2) || (x1 == p2 && y1 == q2) || 
                       (x2 == p1 && y2 == q1) || (x2 == p1 && y1 == q2)) {
                        sb.append("c\n");
                    } else {
                        sb.append("b\n");
                    }
                } else {
                    sb.append("a\n");
                }
            } else { 
                sb.append("d\n");
            }
        }
        System.out.println(sb);
    }
}