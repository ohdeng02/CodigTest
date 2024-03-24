import java.io.*;
 
public class Main {
     public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
 
        int cnt = 0;
        char c = s.charAt(0);
 
        for(int i = 1; i < s.length(); i++) {
             if(c != s.charAt(i)) {
                 c = s.charAt(i);
                 cnt ++;
             }
        }
 
        System.out.println((cnt/2) + cnt%2);
    }
}