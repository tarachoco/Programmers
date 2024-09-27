import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class day100 {
    /*
        택배상자
        https://school.programmers.co.kr/learn/courses/30/lessons/131704
     */
    public static void main(String[] args) {
        int[] order = {5, 4, 3, 2, 1};
        System.out.printf(""+solution(order));
    }

    public static int solution(int[] order) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        int orderIdx = 0;

        for (int i=1; i<=order.length; i++) {
            if (order[orderIdx] == i) {
                answer++;
                orderIdx++;
                continue;
            }

            while (!stack.isEmpty() && stack.peek() == order[orderIdx]) {
                answer++;
                stack.pop();
                orderIdx++;
            }

            stack.push(i);

        }

        while (!stack.isEmpty()) {
            if (order[orderIdx] == stack.peek()) {
                answer++;
                stack.pop();
                orderIdx++;
            } else {
                break;
            }
        }

        return answer;
    }
}
