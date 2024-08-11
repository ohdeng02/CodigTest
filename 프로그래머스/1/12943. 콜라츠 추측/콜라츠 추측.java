class Solution {
    public int solution(int num) {
        long nums = num;
        int count = 0;
        while (nums != 1) {
            if (count >= 500) {
                return -1;
            } else if (nums % 2 == 0) {
                nums /= 2;
            } else {
                nums = nums * 3 + 1;
            }
            count++;
        }
        return count;
    }
}