import java.util.Arrays;

public class day32 {
    /*
        문자열 내 마음대로 정렬하기
        https://school.programmers.co.kr/learn/courses/30/lessons/12915/solution_groups?language=java
        Comparator 구현하는 것도...
     */
    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        String[] results = solution(strings, 1);

        Arrays.stream(results).forEach(System.out::println);
    }

    public static String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        String[] sortArray = new String[strings.length];

        for (int i=0; i<strings.length; i++) {
            sortArray[i] = strings[i].charAt(n) + strings[i];
        }

        Arrays.sort(sortArray);

        for (int i=0; i<sortArray.length; i++) {
            answer[i] = sortArray[i].substring(1);
        }

        return answer;
    }
}
