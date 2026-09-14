import java.util.Arrays;

public class day120 {
    /*
        평균 구하기
        https://school.programmers.co.kr/learn/courses/30/lessons/12944/solution_groups?language=java
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(new int[]{1,2,3,4}));
    }

    public static double solution(int[] arr) {
        double sum = Arrays.stream(arr).sum();
        return  sum / arr.length;
    }
}
