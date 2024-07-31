class Solution {
    public long solution(long n) {
        long answer = -1;
        //int pow = (int)Math.pow(n, 0.5);
        // for (int i = 1; i <= pow; i++) {
        //     if (i * i == n) {
        //         answer = (long)Math.pow(i + 1, 2);
        //         break;
        //     }
        // }
        long pow = (long)Math.pow(n, 0.5);
        if (pow*pow == n) {
            answer = (long)Math.pow(pow + 1, 2);
        }
        return answer;
    }
}