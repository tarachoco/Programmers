import java.util.*;

public class day33 {
    /*
        완주하지 못한 선수
        https://school.programmers.co.kr/learn/courses/30/lessons/42576/solution_groups?language=java
     */
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i=0; i<participant.length; i++) {
            if (completion.length == i || !participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }

        return answer;
    }
}
