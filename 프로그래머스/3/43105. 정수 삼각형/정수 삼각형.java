class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int left = 0, right = 0;
                if (j - 1 >= 0) left = triangle[i - 1][j - 1];
                if (j < triangle[i - 1].length) right = triangle[i - 1][j];
                    
                triangle[i][j] += Math.max(left, right);
                answer = Math.max(triangle[i][j], answer);
            }
        }
        return answer;
    }
}