import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int strLen = String.valueOf(N).length();
        int numberLen = 0;
        
        for (int i = 1; i < strLen; i++) {
            numberLen += i * 9 * Math.pow(10, i - 1);
        }
        numberLen += strLen * (N - Math.pow(10, strLen-1) + 1);
            
        System.out.println(numberLen);
    }
}