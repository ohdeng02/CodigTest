import java.util.*;
import java.lang.*;
import java.io.*;

class Main {     
    public static String processWord(String word) { // 단어를 일정 규칙대로 변환
        StringBuilder sb = new StringBuilder(); // 처리한 단어를 새로 저장하기 위해 선언
        int length = word.length(); // 단어 길이 저장
        sb.append(word.charAt(0)); // 단어 첫 글자 저장
        
        if (length >= 2) { // 단어가 2글자 이상인 경우
            sb.append(word.charAt(length - 1)); // 단어의 마지막 글자 저장
            if (length >= 3) { // 단어가 3글자 이상인 경우
                char[] arr = word.substring(1, length - 1).toCharArray();
                Arrays.sort(arr);
                sb.append(arr); // 중간 글자들 정렬하여 저장
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> words = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String precessedWord = processWord(br.readLine());

            if (words.containsKey(precessedWord)) { // 해당 단어가 이미 map에 있는 경우
                words.put(precessedWord, words.get(precessedWord) + 1); // 단어 개수 증가
            } else { // 아닌 경우
                words.put(precessedWord, 1); // map에 단어 새로 저장
            }
        }

        int M = Integer.parseInt(br.readLine()); 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = 1;
            while (st.hasMoreTokens()) { // 문장의 단어가 없을 떄까지
                String word = processWord(st.nextToken()); // 처리한 단어 저장
                count *= words.getOrDefault(word, 0); // map에서 해당 단어 개수 조회하여 곱셈
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}