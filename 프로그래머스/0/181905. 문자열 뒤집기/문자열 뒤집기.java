class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        for (int i = s; i <= e; i++) {
            sb1.append(my_string.charAt(i));
        }
        
        for (int i = 0; i < s; i++) {
            sb2.append(my_string.charAt(i));
        }
        sb2.append(sb1.reverse().toString());
        for (int i = e + 1; i < my_string.length(); i++) {
            sb2.append(my_string.charAt(i));
        }
        
        return sb2.toString();
    }
}