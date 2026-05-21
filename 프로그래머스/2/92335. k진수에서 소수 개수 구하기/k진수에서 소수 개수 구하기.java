import java.util.*;

class Solution {
    static int answer = 0;
    static String trans;
    static Queue<Character> queue;
    static boolean isPrime(long digit) {
        // 소수조건: 약수가 1과 자신
        if (digit == 1) return false;
        for (int i = 2; i <= Math.sqrt(digit); i++) {
            if (digit % i == 0) return false;
        }
        return true;
    }
    
    static void isCorrect(int idx) {
        String s = "";
        while (!queue.isEmpty()) {
            s += queue.poll();
        }
        if (idx - s.length() == 0 && !s.equals("")) { //P0
            answer = isPrime(Long.parseLong(s)) ? answer + 1 : answer;
        } else if (trans.charAt(idx - s.length() - 1) == '0' && !s.equals("")) { //0P0
            answer = isPrime(Long.parseLong(s)) ? answer + 1 : answer;
        }
    }
    
    public int solution(int n, int k) {
        trans = Integer.toString(n, k); // 진수변환
    
        queue = new LinkedList<>();
        for (int i = 0; i < trans.length(); i++) {
            char ch = trans.charAt(i);
            if (ch == '0') {
                isCorrect(i);
                continue;
            }
            queue.offer(ch);
        }
        
        // queue에 값이 남아있는 경우
        String s = "";
        while (!queue.isEmpty()) {
            s += queue.poll();
        }
        if (!s.equals("") && isPrime(Long.parseLong(s))) answer++;
        return answer;
    }
}