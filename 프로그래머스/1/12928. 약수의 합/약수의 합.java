class Solution {
    public int solution(int n) {
        int sum = 0;
        for(int i=1; i<=n; i++){
            if(n%i==0) sum+=i;
        }
        return sum;
        //for문을 n의 제곱근까지만 돌리면 효율성 업!
    }
}