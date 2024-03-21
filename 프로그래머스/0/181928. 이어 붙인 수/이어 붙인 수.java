class Solution {
    public int solution(int[] num_list) {
        int odd = 0;
        int even = 0;
        for(int i : num_list){
            if(i%2 == 0) even = even*10+i;
            else odd = odd*10+i;
        }
        return odd+even;
    }
}