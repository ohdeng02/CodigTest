class Solution {
    public int solution(String t, String p) {
        int len = p.length();
        int cnt = 0;
        for(int i=0; i<=t.length()-len; i++){
            long sub = Long.parseLong(t.substring(i, i+len));
            if(sub<=Long.parseLong(p)) cnt++;
        }
        return cnt;
    }
}