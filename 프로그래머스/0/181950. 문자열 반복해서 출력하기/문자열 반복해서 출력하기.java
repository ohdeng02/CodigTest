import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int num = Integer.parseInt(st.nextToken());
        
        String result = "";
        
        for(int i=0; i<num; i++){
            result += s;
        }
        System.out.println(result);
    }
}