import java.util.stream.IntStream;

public class day109 {
    /*
        핸드폰 번호 가리기
        https://school.programmers.co.kr/learn/courses/30/lessons/12948
     */
    public static void main(String[] args) {
        System.out.printf(""+solution("01033334444"));
    }

    public static String solution(String phone_number) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        IntStream.range(0,phone_number.length()-4).forEach((i)->{ sb.append("*"); });
        sb.append(phone_number.substring(phone_number.length()-4));

        answer = sb.toString();

        return answer;
    }
}
