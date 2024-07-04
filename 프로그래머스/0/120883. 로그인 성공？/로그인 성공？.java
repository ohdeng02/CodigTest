class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        for (String[] str : db) {
            if (str[0].equals(id_pw[0])) {
                if (str[1].equals(id_pw[1])) {
                    answer = "login";
                } else {
                    answer = "wrong pw";
                }
                break;
            }
        }
        
        return answer;
    }
}