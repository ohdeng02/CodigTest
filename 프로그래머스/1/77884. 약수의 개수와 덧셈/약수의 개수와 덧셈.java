class Solution {
    
    private int divisorCount(int n) {
        int count = 0;
        for (int i = 0; i * i <= n; i++) {
            if (i * i == n) count += 1;
            else count += 2;
        }
        return count;
    }
    
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (divisorCount(i) % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }
}