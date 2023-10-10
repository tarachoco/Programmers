import java.util.Arrays;

public class day31 {
    /*
        전화번호 목록
        https://school.programmers.co.kr/learn/courses/30/lessons/42577
     */
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i=0; i<phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return answer;
    }
}
