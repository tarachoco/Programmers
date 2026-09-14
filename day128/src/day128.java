public class day128 {
    /*
        수박수박수박수박수박수?
        https://school.programmers.co.kr/learn/courses/30/lessons/12922
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(3));
    }

    public static String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i=1; i<=n; i++) {
            if (i % 2 == 1) {
                sb.append("수");
            } else {
                sb.append("박");
            }
        }

        answer = sb.toString();

        return answer;
    }
}
