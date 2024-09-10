import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int[] stack;
    public static int size = 0;

    public static void push(int x) {
        stack[size++] = x;
    }

    public static int pop() {
        if (size == 0) {
            return -1;
        } else {
            int value = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return value;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int top() {
        if (size == 0) {
            return -1;
        } else {
            return stack[size - 1];
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        stack = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                    
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                    
                case "size":
                   sb.append(size()).append("\n");
                    break;
                    
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}