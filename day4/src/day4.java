import static java.lang.Math.max;

public class day4 {


    /*

    동적계획법이란 어느 문제를 해결하기 위해 문제들을 하위 여러개로 쪼개고, 그 값들을 변수에 저장하여
    필요할 때 마다 꺼내쓰는 알고리즘 방식

    아래 문제의 경우 큰 값과 현재 머니의 합을 dp에 저장하고.. 다음번 계산 시 해당 값을 비교하는 방식

     */

    public static void main(String[] args) {
//        int[] money = {1,3,4,1};
//        int[] money = {11,0,2,5,100,100,85,1}; // 198
        int[] money = {1000,1,0,1,2,1000,0}; // 2001
        System.out.printf(String.valueOf(Solution.solution(money)));
    }
}

class Solution {
    public static int solution(int[] money) {
        int answer = 0;
        int l = money.length;
        int[] dp1 = new int[l];
        int[] dp2 = new int[l];

        //첫번째 집 털도록 dp[0],[1] 구성
        dp1[0] = money[0];
        dp1[1] = money[0];

        //첫번째 집은 안훔치므로 0으로 세팅
        dp2[0] = 0;
        dp2[1] = money[1];

        for(int i=2; i<l; i++){
            dp1[i] =  max(dp1[i-2]+money[i],dp1[i-1]);
            dp2[i] =  max(dp2[i-2]+money[i],dp2[i-1]);
        }

        answer = max(dp1[l-2], dp2[l-1]);

        return answer;
    }
}

