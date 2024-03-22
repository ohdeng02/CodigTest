import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            if(n < X) sb.append(n+" ");
        }
        System.out.println(sb.toString());
    }
}