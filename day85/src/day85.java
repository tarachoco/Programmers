import java.util.*;

public class day85 {
    /*
        보석 쇼핑
        https://school.programmers.co.kr/learn/courses/30/lessons/67258
     */
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//        String[] gems = {"AA", "AB", "AC", "AA", "AC"};
//        String[] gems = {"XYZ", "XYZ", "XYZ"};
//        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
//        String[] gems = {"test"};
        int[] answer = solution(gems);
        System.out.printf(answer[0]+","+answer[1]);
    }

    /*
        투포인터 문제
        첫번째 보석이 2개 이상일 경우 구간 첫번째 보석을 제거한다.
     */
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];

        // #1 중복 제거한 보석 종류 구하기
        int kinds = (int) Arrays.stream(gems).distinct().count();
        Set<String> temp = new HashSet<>();

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;

        while (end < gems.length) {

            temp.add(gems[end]);

            if (temp.size() == kinds) {
                if (min > (end - start)) {
                    min = end - start;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
            }

            if (end > start && gems[end].equals(gems[start])) {
                start++;
                end = start+1;
                temp.clear();
                temp.add(gems[start]);
            } else {
                end++;
            }
        }

        return answer;
    }
}
