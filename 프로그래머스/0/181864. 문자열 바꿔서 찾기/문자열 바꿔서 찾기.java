class Solution {
    public int solution(String myString, String pat) {
        char[] charArr = myString.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == 'A') {
                charArr[i] = 'B';
            } else {
                charArr[i] = 'A';
            }
        }
        
        if (String.valueOf(charArr).contains(pat)) {
            return 1;
        }
        return 0;
    }
}