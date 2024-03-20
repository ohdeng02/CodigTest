import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String result = "";
        
        char[] charArr = a.toCharArray();
        for(int i=0; i<charArr.length; i++){
            if(Character.isUpperCase(charArr[i])){
                result += (char)(charArr[i] + 32);
            }else{
                result += (char)(charArr[i] - 32);
            }
        }
        System.out.println(result);
    }
}