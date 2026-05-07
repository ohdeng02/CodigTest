import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        List<String> str1Set = new ArrayList<>();
        List<String> str2Set = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String s = str1.toLowerCase().substring(i, i + 2).replaceAll("[^a-z]", "");
            if (s.length() < 2) continue;
            str1Set.add(s);
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String s = str2.toLowerCase().substring(i, i + 2).replaceAll("[^a-z]", "");
            if (s.length() < 2) continue;
            str2Set.add(s);            
        }
        
        if (str1Set.isEmpty() && str2Set.isEmpty()) {
            return 65536;
        }
        
        int interCnt = 0;
        int unionCnt = 0;
        for (String str : str1Set) {
            if (str2Set.remove(str)) interCnt++;
            unionCnt++;
        }
        unionCnt += str2Set.size();        
        answer = (int)((double)interCnt / (double)unionCnt * 65536);
        return answer;
    }
}