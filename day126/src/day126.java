public class day126 {
    /*
        두 정수 사이의 합
        https://school.programmers.co.kr/learn/courses/30/lessons/12912
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(3,5));
    }

    public static long solution(int a, int b) {
        long answer = 0;
        int min = Math.min(a,b);
        int max = Math.max(a,b);

        for (int i=min; i<=max; i++) {
            answer += i;
        }

        return answer;
    }
}
