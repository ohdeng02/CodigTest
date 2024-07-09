class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long cost = 0;
        for (int i = 1; i <= count; i++) {
            cost += price * i;
        }
        
        answer = cost - money;
        return answer <= 0 ? 0 : answer;
    }
}