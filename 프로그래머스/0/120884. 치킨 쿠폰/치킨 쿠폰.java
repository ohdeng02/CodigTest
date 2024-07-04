class Solution {
    public int solution(int chicken) {
        int portion = chicken / 10;
        int remainder = chicken % 10;
        int answer = portion;
        
        while (portion > 0) {
            remainder += portion % 10;
            portion /= 10;
            answer += portion;
        }
                
        int re = 0;
        while (remainder > 0) {
            re += remainder % 10;
            remainder /= 10;
            answer += remainder;
        }
        answer += re/10;
        
        return answer;
    }
}