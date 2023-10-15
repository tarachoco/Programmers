import java.util.Arrays;
import java.util.Collections;

public class day34 {
    /*
        할인 행사
        https://school.programmers.co.kr/learn/courses/30/lessons/131127/solution_groups?language=java
     */
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(solution(want, number, discount));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for (int i=0, size=discount.length; i<size; i++) {
            for (int j=0; j<want.length; j++) {
                int count = Collections.frequency(Arrays.asList(Arrays.copyOfRange(discount,i,i+10)), want[j]);
                if (count < number[j]) {
                    break;
                }
                if (j==want.length-1) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
