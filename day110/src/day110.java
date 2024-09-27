public class day110 {
    /*
        문자열 다루기 기본
        https://school.programmers.co.kr/learn/courses/30/lessons/12918
     */
    public static void main(String[] args) {
        System.out.printf(""+solution("a234"));
        System.out.printf(""+solution("1234"));
    }
    public static boolean solution(String s) {
        boolean answer = false;

        if (s.length() == 4 || s.length() == 6) {
            answer = s.chars().allMatch(Character::isDigit);
        }

        return answer;
    }
}
