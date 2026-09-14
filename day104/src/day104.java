public class day104 {
    /*
        124 나라의 숫자
        https://school.programmers.co.kr/learn/courses/30/lessons/12899
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(123));
    }

    public static String solution(int n) {
        String answer = "";

        StringBuilder sb = new StringBuilder();


        while (n > 0) {
            int sub = n % 3;
            sb.append(sub == 0 ? 4 : sub);
            n = sub == 0 ? (n-1)/3 : n/3;
        }

        sb.reverse();

        answer = sb.toString();

        return answer;
    }
}
