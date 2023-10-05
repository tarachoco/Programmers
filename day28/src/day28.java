import java.util.Arrays;

public class day28 {
    /*
        가장 가까운 같은 글자
        https://school.programmers.co.kr/learn/courses/30/lessons/142086
     */
    public static void main(String[] args) {
        Arrays.stream(solution("banana")).forEach(System.out::println);
    }

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];

        for (int i=1; i<=s.length(); i++) {

            int idx = s.substring(0,i-1).lastIndexOf(s.charAt(i-1));
            if (idx > -1) {
                answer[i-1] = i - idx -  1;
            } else {
                answer[i-1] = -1;
            }
        }

        return answer;
    }
}
