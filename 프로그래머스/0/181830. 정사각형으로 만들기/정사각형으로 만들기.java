class Solution {
    public int[][] solution(int[][] arr) {
        int rowLen = arr.length;
        int colLen = arr[0].length;
        int[][] answer = {};
        
        if (rowLen > colLen) {
            answer = new int[rowLen][rowLen];
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < rowLen; j++) {
                    answer[i][j] = j < colLen ? arr[i][j] : 0;
                }
            }
        } else {
            answer = new int[colLen][colLen];
            for (int i = 0; i < colLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    answer[i][j] = i < rowLen ? arr[i][j] : 0;
                }
            }
        }
        
        return answer;
    }
}