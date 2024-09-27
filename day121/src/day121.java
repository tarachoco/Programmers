import java.util.HashMap;
import java.util.Map;

public class day121 {
    /*
        숫자 문자열과 영단어
        https://school.programmers.co.kr/learn/courses/30/lessons/81301
     */
    public static void main(String[] args) {
        System.out.printf(""+solution("23four5six7"));
    }

    public static int solution(String s) {
        int answer = 0;

        Map<String, String> map = new HashMap<>();

        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        for (String key : map.keySet()) {
            if (s.contains(key)) {
                s = s.replace(key, map.get(key));
            }
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}
