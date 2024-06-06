class Solution {
    public String solution(String myString, String pat) {
        int idx = 0;
        int patLen = pat.length();
        int strLen = myString.length();
        
        for (int i = 0; i <= strLen - patLen; i++) {
            if (myString.substring(i, i + patLen).equals(pat)) {
                idx = i + patLen;
            }
        }
        
        return myString.substring(0, idx);
    }
}