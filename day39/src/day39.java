public class day39 {
    /*
        문자열 나누기
        https://school.programmers.co.kr/learn/courses/30/lessons/140108
     */
    public static void main(String[] args) {
        System.out.println(solution("banana"));
    }

    public static int solution(String s) {
        int answer = 0;

        while (s.length() > 0) {
            answer++;

            char t = s.charAt(0);
            int a = 1;
            int b = 0;
            for (int i=1; i<s.length(); i++) {
                if (t == s.charAt(i)) {
                    a++;
                } else {
                    b++;
                }

                if (a==b) {
                    break;
                }
            }
            s = s.substring(a+b);
        }

        return answer;
    }
}
