public class day132 {
    /*
        정수 제곱근 판별
        https://school.programmers.co.kr/learn/courses/30/lessons/12934
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(3));
    }

    public static long solution(long n) {

        double temp = Math.sqrt(n);

        if ( temp % 1 != 0 ) {
            return -1;
        }

        return (long) Math.pow((long) temp+1, 2);
    }

}
