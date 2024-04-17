import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        
        while((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int mod = 0;
            int i = 0;
            while(true) {
                i++;
                mod = (mod * 10 + 1) % n;
                if(mod == 0) {
                    sb.append(i + "\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}