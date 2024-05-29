class Solution {
    public String[] solution(String[] strArr) {
        String tempArr = ""        ;
        for (String s : strArr) {
            if (s.contains("ad")) {
                continue;
            } else {
                tempArr += s + ",";
            }
        }
        return tempArr.split(",");
    }
}