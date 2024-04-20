class Solution {
    public int[] solution(int n, String[] words) {
        int[] result = {0,0};
        for(int i=0; i<words.length; i++){
            int len = i==0? 0 : words[i-1].length();
            int turn = (i+1)%n==0?n:(i+1)%n;
            int times = i/n+1; 
            if(i!=0 && words[i-1].charAt(len-1)!=words[i].charAt(0)) {
                result[0]=turn; result[1]=times;
                return result; 
            } 
            for(int j=0; j<i; j++){
                if(words[j].equals(words[i])) {
                    result[0]=turn; result[1]=times;
                    return result;
                }
            }
        }
        return result;
    }
}