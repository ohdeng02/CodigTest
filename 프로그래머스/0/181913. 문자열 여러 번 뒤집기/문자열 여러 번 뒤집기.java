class Solution {
    public String solution(String my_string, int[][] queries) {
        for (int[] query : queries) {
            int s = query[0], e = query[1];
            StringBuilder temp = new StringBuilder();
            StringBuilder reverse = new StringBuilder();
            
            temp.append(my_string.substring(0, s));
            temp.append(reverse.append(my_string.substring(s, e + 1)).reverse());
            temp.append(my_string.substring(e + 1));
            my_string = temp.toString();
        }
        
        return my_string;
    }
}