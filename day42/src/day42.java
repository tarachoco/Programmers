import java.util.Stack;

public class day42 {
    /*
        짝지어 제거하기
        https://school.programmers.co.kr/learn/courses/30/lessons/12973
     */
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }

    public static int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }

        answer = stack.isEmpty() ? 1 : 0;

        return answer;
    }
}
