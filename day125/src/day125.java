public class day125 {
    /*
        나머지가 1이 되는 수 찾기
        https://school.programmers.co.kr/learn/courses/30/lessons/87389
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(12));
    }

    public static int solution(int n) {
        int answer = 0;

        for (int i=1; i<n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
