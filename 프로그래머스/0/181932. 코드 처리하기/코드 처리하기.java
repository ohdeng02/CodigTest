class Solution {
    public String solution(String code) {
        String ret = "";
        int mode = 0;
        for(int i=0; i<code.length(); i++){
            if(code.charAt(i) == '1')
                mode = (mode == 0 ? 1 : 0);
            else
                if(i%2 == mode) ret += code.charAt(i);
        }
        return ret.isBlank() ? "EMPTY" : ret;
        //`isEmpty()`는 문자열의 길이가 0인지 확인합니다. - `isBlank()`는 문자열이 비어 있거나 공백 문자만 포함되어 있는지 확인
    }
}