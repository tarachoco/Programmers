import java.util.Arrays;
import java.util.Stack;

public class day38 {
    /*
        주식가격
        https://school.programmers.co.kr/learn/courses/30/lessons/42584
        스택에 가격이 아닌 인덱스 값을 넣어 참조,,
     */
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,1};
        int[] results = solution(prices);
        Arrays.stream(results).forEach(System.out::println);
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        int i=0;

        while (i<prices.length) {

            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek() ;
                stack.pop();
            }
            stack.push(i);

            i++;
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            answer[pop] = prices.length - pop - 1;
        }

        return answer;
    }
}
