import java.time.LocalDate;

public class day140 {
    /*
        2016년
        https://school.programmers.co.kr/learn/courses/30/lessons/12901
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(5,24));
    }

    public static String solution(int a, int b) {
        String answer = "";

        String[] dayOfWeek = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        LocalDate date = LocalDate.of(2016, a, b);

        answer = dayOfWeek[date.getDayOfWeek().getValue()-1];

        return answer;
    }
}
