public class day139 {
    /*
        음양 더하기
        https://school.programmers.co.kr/learn/courses/30/lessons/76501
     */
    public static void main(String[] args) {
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};
        System.out.printf(""+solution(absolutes, signs));
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i=0; i<absolutes.length; i++) {
            answer += signs[i] ? absolutes[i] : absolutes[i] * -1;
        }

        return answer;
    }
}
