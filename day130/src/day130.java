public class day130 {
    /*
        부족한 금액 계산하기
        https://school.programmers.co.kr/learn/courses/30/lessons/82612
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(3, 20, 4));
    }

    public static long solution(int price, int money, int count) {

        long answer = sum(price, money, count, 0);

        return answer < 0 ? 0 : answer;
    }

    public static long sum(int price, int money, int count, long sum) {

        if (count == 0) {
            return sum - money;
        }

        return sum(price, money, count-1, sum+(price * count)) ;
    }
}
