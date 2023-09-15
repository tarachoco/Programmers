import java.util.Arrays;
import java.util.Collection;

public class day16 {
    /*
     * 모의고사
     * https://school.programmers.co.kr/learn/courses/30/lessons/42840
     */
    public static void main(String[] args) throws Exception {
        int[] answers = { 1,2,3,4,5 };
        int[] results = solution(answers);
        for (int i=0; i<results.length; i++) {
            System.out.println(results[i]);
        }
    }

    public static int[] solution(int[] answers) {
        int[] score = new int[3];

        int[] first = { 1, 2, 3, 4, 5 };
        int[] second = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] third = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        int firstLength = first.length;
        int secondLength = second.length;
        int thirdLength = third.length;

        for (int i=0; i<answers.length; i++) {
            if (answers[i] == first[i%firstLength]) score[0]++;
            if (answers[i] == second[i%secondLength]) score[1]++;
            if (answers[i] == third[i%thirdLength]) score[2]++;
        }
        
        int max = Arrays.stream(score).max().getAsInt();
        int[] answer = new int[(int)Arrays.stream(score).filter(s->s==max).count()];
        int answerCnt = 0;
        for (int i=1; i<=score.length; i++) {
            if (max == score[i-1]) {
                answer[answerCnt] = i;
                answerCnt++;
            } 
        }
        
        return answer;
    }
}
