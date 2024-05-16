import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek()==ch) st.pop();
            else st.push(ch);
        }
        return st.isEmpty()?1:0;
    }
}