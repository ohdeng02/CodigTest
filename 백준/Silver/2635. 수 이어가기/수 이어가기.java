import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    private static List<Integer> numbers = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();
    
    public static void addNumbers() {
        int sub = numbers.get(0)-numbers.get(1);
        int j = 3;
        while (sub >= 0) {
            numbers.add(sub);
            sub = numbers.get(j-2)-numbers.get(j-1);
            j++;
        }
    }

    public static void printNumbers() {
        sb.setLength(0);
        sb.append(numbers.size()).append("\n");
        for (int number : numbers) { 
            sb.append(number).append(" ");
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int maxSize = 0;

        int limit = (2 * N) / 3;
        for (int i = 1; i <= N; i++) {
            numbers.add(N);
            numbers.add(i);

            addNumbers();
            if (numbers.size() > maxSize) {
                maxSize = numbers.size();
                printNumbers();
            }
            numbers.clear();
        }
        
        System.out.println(sb);
    }
}