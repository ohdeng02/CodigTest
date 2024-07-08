class Solution {
    public String solution(int n) {
        String answer = "";
        String s = "수박";
        if (n % 2 == 0) {
            answer = s.repeat(n/2);
        } else {
            answer = s.repeat(n/2) + s.charAt(0);
        }
        
        return answer;
    }
}