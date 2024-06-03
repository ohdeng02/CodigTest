class Solution {
    public String solution(String my_string, String alp) {
        char[] charArray = my_string.toCharArray();
        
        for(int i = 0; i < charArray.length; i++) {
            if(charArray[i] == alp.charAt(0)) {
                charArray[i] = alp.toUpperCase().charAt(0);
            }
        }
        return String.valueOf(charArray);
    }
}