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
        List<Integer> list = new ArrayList<>();
        List<String> dictionary = new ArrayList<>();

        for (char i='A'; i<='Z'; i++) {
            dictionary.add(String.valueOf(i));
        }

        for (int i = 0; i < msg.length(); i++) {
            // dictionary 데이터 가공용
            StringBuilder sb = new StringBuilder(String.valueOf(msg.charAt(i)));

            if (i == msg.length() - 1) {
                list.add(dictionary.indexOf(sb.toString()));
                break;
            }

            String c = String.valueOf(msg.charAt(i + 1));

            while (dictionary.contains(sb + c)) {

                sb.append(c);
                i++;

                if (i == msg.length() - 1 || c.equals("")) {
                    c = "";
                    break;
                }

                c = String.valueOf(msg.charAt(i + 1));
            }

            if (!dictionary.contains(sb + c)) {
                dictionary.add(sb + c);
            }

            int x = dictionary.indexOf(sb.toString());
            if (x != -1) {
                list.add(x);
            }

            if (i == msg.length() - 1 && !c.equals("")) {
                list.add(dictionary.indexOf(c));
            }
        }

        answer = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }
}
