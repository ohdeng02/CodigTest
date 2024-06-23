class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        for (int i = 1; i < dots.length; i++) {
            if (dots[0][0] != dots[i][0] && dots[0][1] != dots[i][1]) {
                answer = Math.abs((dots[i][1] - dots[0][1]) * (dots[i][0] - dots[0][0]));
            }
        }
        
        return answer;
    }
}