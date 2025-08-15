import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int answer = -1;
        int cnt = 1;
        while (A != B) {
            if (A > B) break;
            if (B % 10 == 1) {
                B /= 10;
                cnt++;
            }
            else if (B % 2 == 0) {
                B /= 2;
                cnt++;
            }
            else break;
        }

        if (A == B) answer = cnt;
        System.out.println(answer);
    }
}