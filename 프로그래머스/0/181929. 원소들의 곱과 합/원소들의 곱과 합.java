class Solution {
    public int solution(int[] num_list) {
        int multi = 1;
        int sum = 0;
        for(int i : num_list){
            multi*=i;
            sum+=i;
        }
        
        return multi > sum*sum ? 0 : 1;
    }
}