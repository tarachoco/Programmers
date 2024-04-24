import java.util.Collections;
import java.util.Stack;

public class day81 {
    /*
        마법의 엘리베이터
        https://school.programmers.co.kr/learn/courses/30/lessons/148653
     */
    public static void main(String[] args) {
        int storey = 555	;
        System.out.printf(""+solution(storey));
    }

    public static int solution(int storey) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        while (storey > 0) {
            stack.push(storey % 10);
            storey /= 10;
        }

        Collections.reverse(stack);

        int sub = 0;
        while (!stack.isEmpty()) {
            int number = stack.pop();
            
            // 가중치
            if (sub > 0) {
                number += sub;
                sub = 0;
            }

            if (number == 10) {
                sub = 1;
            } else if (number == 5) {
                if (!stack.isEmpty() && stack.peek() >= 5) {
                    sub = 1;
                }
                answer += (10-number);
            } else if (number > 5) {
                sub = 1;
                answer += (10-number);
            } else {
                sub = 0;
                answer += number;
            }
        }
        answer += sub;

        return answer;
    }
}
