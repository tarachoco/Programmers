import java.util.Stack;

public class day55 {
    /*
        괄호 회전하기
        https://school.programmers.co.kr/learn/courses/30/lessons/76502
     */
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
    }

    public static int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();

            // 괄호 회전
            String str = s.substring(i, s.length()) + s.substring(0, i);

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}
