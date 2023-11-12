import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day46 {
    /*
        압축
        https://school.programmers.co.kr/learn/courses/30/lessons/17684
        LZW 압축
     */
    public static void main(String[] args) {
        System.out.println(solution("KAKAO"));
    }

    public static int[] solution(String msg) {
        int[] answer = null;
        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> indexList = new ArrayList<>();

        // 사전 초기화
        int cnt=0;
        for (char i='A'; i<='Z'; i++) {
            dictionary.put(String.valueOf(i), ++cnt);
        }

        int i=0;

        while (i<msg.length()) {
            int offset = msg.length();
            boolean isIndexed = true;

            String str = msg.substring(i, offset);
            while (!dictionary.containsKey(str)) {
                offset--;
                str = msg.substring(i, offset);

                if (i+1 == offset) {
                    isIndexed = false;
                }
            }

            if (isIndexed) {
                dictionary.put(msg.substring(i,i+2), dictionary.size()+1);
                dictionary.put(msg.substring(i, offset), dictionary.size()+1);
            }

            indexList.add(dictionary.get(msg.substring(i, offset)));
            i+=offset;
        }

        return answer;
    }
}
