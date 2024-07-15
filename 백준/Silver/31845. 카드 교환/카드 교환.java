import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Integer[] scores = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scores, Collections.reverseOrder());
        int range = (int)Math.round(n/2.0);
        int maxScore = 0;
        for (int i = 0; i < range; i++) {
            if (i + 1 > m || scores[i] <= 0) {
                break;
            }
            maxScore += scores[i];
        }

        System.out.println(maxScore);
    }
}