import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Stack<Character> stack = new Stack<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String result = "NP";
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            int size = stack.size();
            if (size >= 4) {
                StringBuilder sb = new StringBuilder();
                for (int j = 4; j > 0; j--) {
                    sb.append(stack.get(size - j));
                }
                if (sb.toString().equals("PPAP")) {
                    popChar();
                }
            }
        }

        if (stack.size() == 1 && stack.peek() == 'P') {
            result = "PPAP";
        }
        System.out.println(result);
    }

    public static void popChar() {
        for (int i = 0; i < 3; i++) {
            stack.pop();
        }
    }
}