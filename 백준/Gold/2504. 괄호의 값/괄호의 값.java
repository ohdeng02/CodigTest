import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int cnt = 1;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                cnt *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                cnt *= 3;
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    flag=false;
                    break;
				} 
                if (s.charAt(i - 1) == '(') {
                    answer += cnt;
                }
                stack.pop();
                cnt /= 2;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    flag=false;
                    break;
                }
                if (s.charAt(i - 1) == '[') {
                    answer += cnt;
                }
                stack.pop();
                cnt /= 3;
            }
        }
        
        if (!flag || !stack.isEmpty()) answer = 0;
        System.out.println(answer);
    }
}