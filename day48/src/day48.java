import java.util.Arrays;

public class day48 {
    /*
        성격 유형 검사하기
        https://school.programmers.co.kr/learn/courses/30/lessons/118666
     */
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(solution(survey, choices));
    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] results = new int[4];

        for (int i=0; i<survey.length; i++) {

            int score = ScoreInfo.getScoreById(choices[i]);

            if (score == 0) {
                continue;
            } else if (score > 0) {
                results[getPosition(survey[i].charAt(1))] += score;
            } else {
                results[getPosition(survey[i].charAt(0))] += score;
            }

        }

        return answer;
    }

    public static int getPosition(char s) {
        switch (s) {
            case 'R':
            case 'T':
                return 0;
            case 'C':
            case 'F':
                return 1;
            case 'J':
            case 'M':
                return 2;
            case 'A':
            case 'N':
                return 3;
            default:
                break;
        }
        return -1;
    }

    public static enum ScoreInfo {
        TRD_DEC (1, -3),
        SEC_DEC (2, -2),
        FST_DEC (3, -1),
        MAINTENANCE (4, 0),
        FST_INC (5, 1),
        SEC_INC (6, 2),
        TRD_INC (7, 3),
        ;

        private int id;
        private int score;

        ScoreInfo(int id, int score) {
            this.id = id;
            this.score = score;
        }

        public int getId() {
            return id;
        }

        public int getScore() {
            return score;
        }

        public static int getScoreById(int id) {
            return Arrays.stream(ScoreInfo.values()).filter(s -> s.getId() == id).findAny().get().getScore();
        }
    }
}
