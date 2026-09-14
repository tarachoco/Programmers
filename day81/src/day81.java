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

    /*
        (int)Math.log10(213)+1
        추가로 위를 통해 자릿수를 쉽게 구할 수 있음..
        소수 제거 후 1을 더해주자.
        1은 10^0
        10 은 10^1
        100은 10^2
        50은 1.69 ..
     */
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
