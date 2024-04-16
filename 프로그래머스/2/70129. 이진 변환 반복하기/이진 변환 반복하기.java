import java.lang.Integer;

class Solution {
    public int[] solution(String s) {
        int cntZ = 0;
        int cntN = 0;
        while(true){
            if(s.equals("1")) break;
            int len = s.length();
            s = s.replaceAll("0","");
            cntZ += len-s.length();
            s = Integer.toBinaryString(s.length());
            cntN++;
        }
        int[] arr = {cntN, cntZ};
        return arr;
    }
}