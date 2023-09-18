import java.util.LinkedList;
import java.util.Queue;

public class day18 {
    /*
        올바른 괄호
        https://school.programmers.co.kr/learn/courses/30/lessons/12909
     */
    public static void main(String[] args) {
        boolean result = solution("(())())");
        System.out.println(result);
    }

    static boolean solution(String s) {
        boolean answer = true;
        int check = 0;
        Queue<Character> queue = new LinkedList<>();

        char[] brackets = s.toCharArray();
        for (int i=0; i<brackets.length; i++) {
            if (!answer) break;
            switch (brackets[i]) {
                case 40:
                    queue.offer(brackets[i]);
                    check++;
                    break;
                case 41:
                    try {
                        if (queue.poll().equals(41)) {
                            answer = false;
                        }
                    } catch (Exception e) {
                        answer = false;
                    } finally {
                        check--;
                    }
                    break;
                default:
                    break;
            }
        }

        if (check != 0) {
            answer = false;
        }

        return answer;
    }
}
