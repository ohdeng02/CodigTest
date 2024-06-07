class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int patLen = pat.length();
        int strLen = myString.length();
        
        for (int i = 0; i <= strLen - patLen; i++) {
            if (myString.substring(i, i + patLen).equals(pat)) {
                answer++;
            }
        }
        return answer;
    }
}