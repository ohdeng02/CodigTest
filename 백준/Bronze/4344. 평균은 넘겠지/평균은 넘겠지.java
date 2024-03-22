import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int C = Integer.parseInt(br.readLine());
        
        for(int i=0; i<C; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] nums = new int[N];
            int sum = 0;
    
            for(int j=0; j<N; j++){
                nums[j] = Integer.parseInt(st.nextToken()); 
                sum += nums[j];           
            }
            double students = 0;
            for(int n : nums){
                if(n > sum/N) students ++;
            }
            sb.append(String.format("%.3f", students/N*100) + "%\n");
        }
        System.out.println(sb.toString());
    }
}