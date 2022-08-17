import static java.lang.Math.max;

public class day4 {

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
        int[] dp1 = money;
        int[] dp2 = money;

        // sum1
        for(int i=2; i<l-1;i++){
            dp1[i] =  max(dp1[i-2]+money[i],dp1[i-1]);
        }

        System.out.printf("dp1="+dp1[l-1]+"\n");

        for(int i=3; i<l;i++){
            dp2[i] =  max(dp2[i-2]+money[i],dp2[i-1]);
        }

        answer = max(dp1[l-1],dp2[l-1]);

        return answer;
    }
}

