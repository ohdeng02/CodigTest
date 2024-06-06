class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] range : queries) {
            for (int i = range[0]; i <= range[1]; i++) {
                arr[i]++;
            }
        }
        
        return arr;
    }
}