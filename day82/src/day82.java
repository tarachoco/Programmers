public class day82 {
    /*
        광물 캐기
        https://school.programmers.co.kr/learn/courses/30/lessons/172927
     */
    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        System.out.printf(""+solution(picks, minerals));
    }

    /*
               다 | 철 | 돌
          다 |  1 | 1 | 1
          철 |  5 | 1 | 1
          돌 | 25 | 5 | 1
          광석 5개씩 묶어 피로도 계산후 내림차로 정렬하여 다이아 곡괭이부터 사용하자
     */
    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        return answer;
    }
}
