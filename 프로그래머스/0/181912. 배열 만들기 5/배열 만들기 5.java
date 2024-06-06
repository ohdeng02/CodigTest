import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> result = new ArrayList<>();
        
        //substring이 시간차지를 많이 하는 것 같은데, 이걸 for loop로 하는게 나은가?
        for (String str : intStrs) {
            int num = Integer.parseInt(str.substring(s, s + l));
            if (num > k) {
                result.add(num);
            }
        }
        
        int length = result.size();
        int[] answer = new int[length];
        for(int i = 0; i < length; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}