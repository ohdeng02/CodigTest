class Solution {
    public int solution(int chicken) {
        int service = chicken / 10;
        int coupon = service + (chicken % 10);
        
        while (coupon >= 10) {
            service +=  coupon / 10;
            coupon = coupon / 10 + coupon % 10;
        }
        
        return service;
    }
}