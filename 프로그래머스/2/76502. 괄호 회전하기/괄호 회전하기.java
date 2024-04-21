import java.util.Stack;

class Solution {
    
    static Stack<String> st = new Stack<>();

    public static int solution(String s) {
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            String rot = s.substring(i,s.length())+s.substring(0,i);
            if(isCorrect(rot) == true) cnt++;
        }
        return cnt;
    }
    
    private static boolean isCorrect(String rot){
        st.clear();
        for(String s : rot.split("")){
            if(s.equals("{") || s.equals("[") || s.equals("(")){
                st.push(s);
            }else{
                switch(s){
                    case "}": check("{"); break;
                    case ")": check("("); break;
                    case "]": check("["); break;
                }
            }
        }
        return st.isEmpty();
    }
    
    private static void check(String s){
        if(!st.isEmpty() && st.peek().equals(s)){
            st.pop();
        }else st.push(s);
    }
}