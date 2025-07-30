import java.util.*;
import java.io.*;

class Pair {
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Main {
    static List<Pair> pairs;
    static Set<String> set;
    static boolean[] check;
    static String s;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        StringBuilder sb = new StringBuilder();
        pairs = new ArrayList<>();
        set = new TreeSet<>();
        Stack<Integer> stack = new Stack<>();

        // pairs 리스트에 짝꿍 괄호들 저장
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                pairs.add(new Pair(stack.pop(), i));
            }
        }

        check = new boolean[s.length()];
        makeString(0);

        // 출력
        set.remove(s);
        for (String str : set) {
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }

    static void makeString(int idx) {
        if (idx == pairs.size()) {
            // 탐색이 끝났기 때문에 문자열 형태로 변환해야 함.
            StringBuilder sbm = new StringBuilder();
            for (int i = 0; i < check.length; i++) {
                if (check[i]) continue;
                sbm.append(s.charAt(i));
            }
            set.add(sbm.toString());
            return;
        }
        
        Pair pair = pairs.get(idx);   

        // 괄호 제거한 경우
        check[pair.start] = true;
        check[pair.end] = true;
        makeString(idx + 1);
        
        // 괄호 제거 안 한 경우
        check[pair.start] = false;
        check[pair.end] = false;
        makeString(idx + 1);
    }
}