import java.util.Arrays;

public class day114 {
    /*
        서울에서 김서방 찾기
        https://school.programmers.co.kr/learn/courses/30/lessons/12919
     */
    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};
        System.out.printf(""+ solution(seoul));
    }
    public static String solution(String[] seoul) {
        return String.format("김서방은 %s에 있다", Arrays.asList(seoul).indexOf("Kim"));
    }
}
