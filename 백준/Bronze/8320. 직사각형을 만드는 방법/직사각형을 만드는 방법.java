import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 1; i <= N; i++) {
             for (int j = 1; j <= Math.sqrt(i); j++) {
                 if (i % j == 0) {
                     sum++;
                 }
             }
        }
        System.out.println(sum);
    }
}