class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int size = intervals[0][1]-intervals[0][0] + intervals[1][1] - intervals[1][0] + 2;
        int[] answer = new int[size];
        
        int idx = 0;
        for(int i = 0; i < intervals.length; i++) {
            for(int j = intervals[i][0]; j <= intervals[i][1]; j++) {
                answer[idx++] = arr[j];
            }
        }
        return answer;
    }
}