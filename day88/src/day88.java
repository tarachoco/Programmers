import static java.lang.Math.atan;
import static java.lang.Math.max;

public class day88 {
    /*
        스티커 모으기(2)
        https://school.programmers.co.kr/learn/courses/30/lessons/12971
     */
    public static void main(String[] args) {
        int[] sticker = {1, 3, 2, 5, 4};
        System.out.printf(""+solution(sticker));
    }

    /*
        도둑질(day4)랑 동일한 문제
     */
    public static int solution(int sticker[]) {
        int answer = 0;

        if (sticker.length == 1) {
            return sticker[0];
        } else if (sticker.length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }

        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];

        dp1[0] = sticker[0];
        dp1[1] = sticker[0];

        dp2[0] = 0;
        dp2[1] = sticker[1];

        for(int i=2; i<sticker.length; i++){
            dp1[i] =  max(dp1[i-2]+sticker[i],dp1[i-1]);
            dp2[i] =  max(dp2[i-2]+sticker[i],dp2[i-1]);
        }

        answer = max(dp1[sticker.length-2], dp2[sticker.length-1]);

        return answer;
    }
}
