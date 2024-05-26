class Solution {
    public int[] solution(int[] num_list, int n) {
        
        int[] answer = new int[num_list.length];
        int len = answer.length;
        for(int i = 0; i < n; i++) {
            answer[i+len-n] = num_list[i];
        }
        for(int i = n; i < len; i++){
            answer[i-n] = num_list[i];
        }
        return answer;
    }
}