import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N  = Integer.parseInt(st.nextToken());
        int L  = Integer.parseInt(st.nextToken());

        int time = 0;
        int preD = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int D  = Integer.parseInt(st.nextToken());
            int R  = Integer.parseInt(st.nextToken());
            int G  = Integer.parseInt(st.nextToken());

            if (i == 0) time += D;
            else time += D - preD;
            preD = D;
            int interval = time % (R + G);
            if (interval < R) {
                time += R - interval;
            }
        }
        time += L - preD;
        System.out.println(time);
    }
}