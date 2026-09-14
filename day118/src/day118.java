public class day118 {
    /*
        가운데 글자 가져오기
        https://school.programmers.co.kr/learn/courses/30/lessons/12903
     */
    public static void main(String[] args) {
        System.out.printf(""+solution("abcde"));
    }

    public static String solution(String s) {
        return s.length() % 2 == 0 ? s.substring(s.length()/2-1, s.length()/2 + 1) : String.valueOf(s.charAt(s.length()/2));
    }
}
