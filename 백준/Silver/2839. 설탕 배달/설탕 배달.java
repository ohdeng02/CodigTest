import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = -1;
        
        for (int i = n/5; i >= 0; i--) {
            if ((n - i * 5) % 3 == 0) {
                answer = i + (n - i * 5) / 3;
                break;
            }
        }

        System.out.println(answer);
    }
}