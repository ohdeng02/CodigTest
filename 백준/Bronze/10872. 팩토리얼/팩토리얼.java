import java.io.*;
import java.util.*;

public class Main {
    public static int factorial(int n){
        if(n == 1) return n;
        return n * factorial(n-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
            
        System.out.println(N == 0 ? 1 : factorial(N));
    }
}