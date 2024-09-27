import java.util.Arrays;
import java.util.Stack;

public class day11 {
    /* 뒤에서부터 큰 수 찾기 */
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        solution(numbers);
    }

    public static int[] solution(int numbers[]) {
        int[] answer = new int[numbers.length];
		Arrays.fill(answer, -1);

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < numbers.length; i++) {
			while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
				answer[stack.pop()] = numbers[i];
			}

			stack.push(i);
		}

		return answer;
    }
}