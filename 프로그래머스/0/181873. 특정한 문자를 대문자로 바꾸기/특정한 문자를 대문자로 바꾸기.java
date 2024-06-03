class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder sb = new StringBuilder();
        String[] arr = my_string.split("");
        
        for(String s : arr) {
            if(s.equals(alp)) {
                sb.append(s.toUpperCase());
            } else {
                sb.append(s);
            }
        }
        
        return sb.toString();
    }
}