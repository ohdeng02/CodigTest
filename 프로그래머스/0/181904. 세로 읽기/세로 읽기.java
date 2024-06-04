class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = my_string.toCharArray();
        
        int limit = my_string.length() / m;
        for(int i = 0; i < limit; i++) {
            sb.append(charArr[i*m + c-1]);
        }
        return sb.toString();
    }
}