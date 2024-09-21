import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            int j;
            for (j = 0; j < i; j++) {
                sb.append("*");
            }
            for (j = i; j < n*2 - i; j++) {
                sb.append(" ");
            }
            for (j=j; j < n*2; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = n-1; i > 0; i--) {
            int j;
            for (j = 0; j < i; j++) {
                sb.append("*");
            }
            for (j = i; j < n*2 - i; j++) {
                sb.append(" ");
            }
            for (j=j; j < n*2; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}