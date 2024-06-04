class Solution {
    public int solution(String number) {
        int sum = 0;
        int answer = 0;
        
        String[] arr = number.split("");
        for(String c : arr) {
            sum += Integer.parseInt(c);
        }
        
        answer = sum % 9;
        return answer;
    }
}