public class day133 {
    /*
        하샤드 수
        https://school.programmers.co.kr/learn/courses/30/lessons/12947
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(10));
    }

    public static boolean solution(int x) {

        int sum = 0;
        int n = x;

        while ( n > 0 ) {
            sum += n%10;
            n /=10;
        }

        return x % sum == 0 ? true : false;
    }
}
