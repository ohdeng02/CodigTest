class Solution {
    public int solution(String number) {
        int sum = 0;
        int answer = 0;
        
        char[] arr = number.toCharArray();
        for(char c : arr) {
            sum += c - '0';
        }
        
        answer = sum % 9;
        return answer;
    }
}