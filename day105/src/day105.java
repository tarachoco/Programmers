public class day105 {
    /*
        큰 수 만들기
        https://school.programmers.co.kr/learn/courses/30/lessons/42883
     */
    public static void main(String[] args) {
        /*
            정답: 987654
            9876543214, 4

            정답: 432
            4321, 1
         */
        System.out.printf(""+solution("9876543214", 4));
    }

    public static String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<number.length(); i++) {

            int a = number.charAt(i) - '0';

            if (a == 9) {
                sb.append(number.charAt(i));
                continue;
            }

            boolean isSmall = false;

            for (int j=1; j<=k && i+j<number.length(); j++) {

                if (a < number.charAt(i+j) - '0') {
                    isSmall = true;
                    break;
                }

            }

            if (isSmall || k == number.length() - i) {
                k--;
                continue;
            }

            sb.append(number.charAt(i));
        }

        String answer = k > 0 ? sb.substring(0, sb.length()-1-k) : sb.toString();

        return answer;
    }
}
