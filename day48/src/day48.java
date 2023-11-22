import java.util.Arrays;
import java.util.HashMap;

public class day48 {
    /*
        성격 유형 검사하기
        https://school.programmers.co.kr/learn/courses/30/lessons/118666
     */
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(solution(survey, choices));
    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();

        int m = 4;

        for (int i=0; i<survey.length; i++) {

            if (choices[i] == m) {
            } else if (choices[i] > m) {
                map.put(survey[i].charAt(1), map.getOrDefault(survey[i].charAt(1),0)+choices[i]-m);
            } else {
                map.put(survey[i].charAt(0), map.getOrDefault(survey[i].charAt(0),0)+m-choices[i]);
            }

        }

        StringBuilder sb = new StringBuilder();
        sb.append(map.getOrDefault('R',0) >= map.getOrDefault('T',0) ? "R" : "T");
        sb.append(map.getOrDefault('C',0) >= map.getOrDefault('F',0) ? "C" : "F");
        sb.append(map.getOrDefault('J',0) >= map.getOrDefault('M',0) ? "J" : "M");
        sb.append(map.getOrDefault('A',0) >= map.getOrDefault('N',0) ? "A" : "N");

        answer = sb.toString();

        return answer;
    }

    public static int getScore(char s) {
        switch (s) {
            case 'R':
            case 'T':
                return 0;
            case 'C':
            case 'F':
                return 1;
            case 'J':
            case 'M':
                return 2;
            case 'A':
            case 'N':
                return 3;
            default:
                break;
        }
        return -1;
    }
}
