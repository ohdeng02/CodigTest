import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            String s = br.readLine();
            int sum = 0, num = 0;
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j) == 'O'){
                    num += 1;
                    sum += num;
                } else {
                    num = 0;
                }
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb.toString());
    }
}