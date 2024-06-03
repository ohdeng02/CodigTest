class Solution {
    public String solution(String myString) {
        char[] charArr = myString.replace("a", "A").toCharArray();
        for(int i = 0; i < charArr.length; i++) {
            if(charArr[i] != 'A' && Character.isUpperCase(charArr[i])) {
                charArr[i] = Character.toLowerCase(charArr[i]);
            }
        }
        return String.valueOf(charArr);
    }
}