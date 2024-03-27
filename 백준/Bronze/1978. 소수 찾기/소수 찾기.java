import java.io.*;
import java.util.*;

public class Main {

    public static boolean isPrime(int n){
        for(int k=2; k<n; k++){
            if(n%k == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int count = 0;

        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            if(n == 1) continue;
            else if(isPrime(n)) count++;
        }
        System.out.println(count);
    }
}