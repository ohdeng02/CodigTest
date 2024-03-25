import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean prevStr = false;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && !prevStr) {
                count++;
                prevStr = true;
            } else if (s.charAt(i) == ' '){
                prevStr = false;
            }
        }
        System.out.println(count);
    }
}