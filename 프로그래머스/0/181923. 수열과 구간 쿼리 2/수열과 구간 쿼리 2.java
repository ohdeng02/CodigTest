class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        int[] answer = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            int s = query[0], e = query[1], k = query[2];
            int min = 1000000;
            for (int i = s; i <= e; i++) {
                if (arr[i] > k) {
                    min = Math.min(min, arr[i]);
                }
            }
            answer[idx++] = min == 1000000 ? -1 : min;
        }
        
        return answer;
    }
}