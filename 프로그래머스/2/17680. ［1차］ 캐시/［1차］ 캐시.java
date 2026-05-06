import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) answer = 5 * cities.length;
        else {
            List<String> list = new LinkedList<>();
            for (int i = 0; i < cities.length; i++) {
                String str = cities[i].toLowerCase();

                // 캐시 미스
                if (!list.contains(str)) {
                    if(list.size() >= cacheSize) list.remove(0);
                    list.add(str);
                    answer += 5;
                } else { // 캐시 히트
                    list.remove(str);
                    list.add(str);
                    answer += 1;
                }
            }
        }
        
        return answer;
    }
}