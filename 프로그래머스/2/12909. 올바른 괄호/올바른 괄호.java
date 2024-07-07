import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(') st.push(ch);
            else {
                if(!st.isEmpty() && st.peek().equals('(')) st.pop();
                else return false;
            }
        }
        return st.isEmpty()?true:false;
    }
}