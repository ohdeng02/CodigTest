import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String result = "";
        String[] arr = s.split(" ");
        int[] list = new int[arr.length];
        for(int i=0; i<arr.length; i++) list[i]=Integer.parseInt(arr[i]);
        result += Arrays.stream(list).min().getAsInt();
        result += " ";
        result += Arrays.stream(list).max().getAsInt();
        return result;
    }
}