import java.util.Arrays;

public class day40 {
    /*
        이진변환 반복하기
        https://school.programmers.co.kr/learn/courses/30/lessons/70129
     */
    public static void main(String[] args) {
        int[] results = solution("011010");
        Arrays.stream(results).forEach(System.out::println);
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];

        while (s.length() > 1) {

            int cnt = 0;
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '0') {
                    answer[1]++;
                } else {
                    cnt++;
                }
            }
            // 10진수를 2진수로 변환
            s = Integer.toBinaryString(cnt);
            answer[0]++;
        }

        return answer;
    }
}
