import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] survivors;
        
        if (n - r == 0) sb.append("*");
        else {
            survivors = new int[r];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < r; i++) {
                survivors[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(survivors);

            int index = 0;
            for (int i = 1; i <= n; i++) {
                if (index >= r) {
                    sb.append(i + " ");
                    continue;
                }
                while (survivors[index] != i) {
                    sb.append(i++ + " ");
                }
                index++;
            }
        }

        System.out.println(sb);
    }
}