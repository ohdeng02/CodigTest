class Solution {
    public String[] solution(String[] picture, int k) {
        
        String[] answer = new String[picture.length * k];
        int idx = 0;
        for (String s : picture) {
            StringBuilder sb = new StringBuilder();
            for (String str : s.split("")) {
                sb.append(str.repeat(k));
            }            
            for (int i = idx; i < idx + k; i++) {
                answer[i] = sb.toString();
            }
            idx += k;
        }
        
        return answer;
    }
}