import java.util.Arrays;
import java.util.PriorityQueue;

public class day111 {
    /*
        과일 장수
        https://school.programmers.co.kr/learn/courses/30/lessons/135808
     */
    public static void main(String[] args) {
//        int k = 3;
//        int m = 4;
//        int[] score = {1,2,3,1,2,3,1};
//        int k = 4;
//        int m = 3;
//        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        int k = 3;
        int m = 10;
        int[] score = {1, 2, 3, 1,1,1,1};
        System.out.printf(""+solution(k, m, score));
    }
    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for(int i = score.length; i >= m; i -= m){
            answer += score[i - m] * m;
        }

        return answer;
    }
}
