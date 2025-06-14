import java.util.*;
import java.io.*;

class Main {
    static int n, k, p, x;
    
    public static void main(String[] args) throws IOException {
        int[][] display = {{1, 1, 1, 0, 1, 1, 1}, //0
                            {0, 0, 1, 0, 0, 0, 1}, //1
                            {0, 1, 1, 1, 1, 1, 0}, //2
                            {0, 1, 1, 1, 0, 1, 1}, //3
                            {1, 0, 1, 1, 0, 0, 1}, //4
                            {1, 1, 0, 1, 0, 1, 1}, //5
                            {1, 1, 0, 1, 1, 1, 1}, //6
                            {0, 1, 1, 0, 0, 0, 1}, //7
                            {1, 1, 1, 1, 1, 1, 1}, //8
                            {1, 1, 1, 1, 0, 1, 1}}; //9

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        int answer = 0;

        int[] digits = numToDigit(x);
        for (int i = 1; i <= n; i++) {
            int count = 0;
            int[] goalDigit = numToDigit(i);
            for (int j = 0; j < k; j++) {
                if (goalDigit[j] != digits[j]) {
                    for (int l = 0; l < 7; l++) {
                        if (display[digits[j]][l] != display[goalDigit[j]][l]) count++;
                    }
                }
            }
            if (count <= p && count > 0) answer++;
        }
        
        System.out.println(answer);
    }

    static int[] numToDigit(int num) {
        int[] digits = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }
}