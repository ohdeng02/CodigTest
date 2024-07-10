class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if (s.length() != 4 && s.length() != 6) answer = false;
        for (char ch : s.toCharArray()) {
            if ('0' > ch || '9' < ch) {
                answer = false;
            } 
        }
        
        return answer;
    }
}