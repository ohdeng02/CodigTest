class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        int[] result = new int[len+1];
        for(int i=0; i<len; i++) 
            result[i] = num_list[i];
        
        int end = num_list[len-1];
        int end_f = num_list[len-2];
        result[len] = end > end_f ? end-end_f : 2*end;
        
        return result;
    }
}