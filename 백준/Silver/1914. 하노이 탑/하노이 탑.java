import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void hanoi(int n, int from, int tmp, int to){ //1->2->3
        if(n == 1){
            sb.append(from + " " + to + "\n");
            return;
        }
        hanoi(n-1, from, to, tmp); //1->3->2
        sb.append(from + " " + to + "\n");
        hanoi(n-1, tmp, from, to); //2->1->3
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger bigInt = new BigInteger("2");
        sb.append(bigInt.pow(N).subtract(new BigInteger("1")) + "\n");
        if(N <= 20){
            hanoi(N, 1, 2, 3);
        }
        
        System.out.println(sb.toString());
        br.close();
    }
}