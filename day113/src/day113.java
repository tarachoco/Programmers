public class day113 {
    /*
        문자열 내 p와 y의 개수
        https://school.programmers.co.kr/learn/courses/30/lessons/12916
     */
    public static void main(String[] args) {
        System.out.printf(""+solution("pPoooyY"));
    }
    public static boolean solution(String s) {

        long p = s.chars().filter(c->c == 'p' || c == 'P').count();
        long y = s.chars().filter(c->c == 'y' || c == 'Y').count();

        return p == y;
    }
}
