import java.util.*;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 10);
            n /= 10;
        }
        char[] arr = sb.toString().toCharArray();
        Arrays.sort(arr);
        return Long.parseLong(new StringBuilder(new String(arr)).reverse().toString());
    }
}