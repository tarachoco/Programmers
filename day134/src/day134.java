public class day134 {
    /*
        콜라츠 추측
        https://school.programmers.co.kr/learn/courses/30/lessons/12943
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(1));
    }

    public static int solution(int num) {

        int answer = 0;

        if ( num == 1 ) {
            return 0;
        }

        int count = 0;
        long n = (long) num;

        while (true) {

            count++;

            if (count > 500) {
                answer = -1;
                break;
            }

            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = (n * 3) + 1;
            }

            if (n == 1) {
                answer = count;
                break;
            }

        }

        return answer;
    }
}
