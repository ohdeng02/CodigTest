class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCount = 0, yCount = 0;
        for (String str : s.toUpperCase().split("")) {
            if (str.equals("P")) pCount++;
            if (str.equals("Y")) yCount++;
        }

        return pCount == yCount;
    }
}