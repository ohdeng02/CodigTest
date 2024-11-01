import java.util.*;
import java.lang.*;
import java.io.*;

class Main {     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> result = new Stack<>();
        int length = bomb.length();
        for (int i = 0; i < str.length(); i++) {
            result.push(str.charAt(i));
            if (result.size() >= length) {
                boolean flag = true;
                for (int j = 0; j < length; j++) {
                    if (bomb.charAt(j) != result.get(result.size() - length + j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < length; j++) result.pop();
                }
            }
        }

        if (result.size() == 0) {
             System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Character ch : result) {
                sb.append(ch);
            }
            System.out.println(sb);    
        }
    }
}