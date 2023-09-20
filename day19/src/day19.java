import java.util.Arrays;
import java.util.function.Predicate;

public class day19 {
    /*
        H-Index
        https://school.programmers.co.kr/learn/courses/30/lessons/42747
     */
    public static void main(String[] args) {
        int[] citations = {4, 4, 2, 2};
        int result = solution(citations);
        System.out.println(result);
    }

    public static int solution(int[] citations) {
        int answer = 0;
        int h = 0;
        Arrays.sort(citations);

        for (int i=0; i<citations.length; i++) {
            h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
