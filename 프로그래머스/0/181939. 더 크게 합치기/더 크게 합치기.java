class Solution {
    public int solution(int a, int b) {
        int s1 = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int s2 = Integer.parseInt(String.valueOf(b) + String.valueOf(a));

        return s1>=s2 ? s1 : s2;
    }
}