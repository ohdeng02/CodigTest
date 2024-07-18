import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int answer = 0;

            String substr = s.substring(l - 1, r);
            int length = r-l+1;
            for (int j = 0; j < length; j++) {
                int score = 0;
                int jump = 1;
                for (int k = j+1; k < length; k++) {
                    if (k - jump < 0) break;
                    if (substr.charAt(k) == substr.charAt(k-jump)) {
                        score++;
                    }
                    jump += 2;
                }
                answer = Math.max(answer, score);
            }
            sb.append(answer + "\n");
        }

        System.out.print(sb);
    }
}