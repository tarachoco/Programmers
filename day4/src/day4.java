import static java.lang.Math.max;

public class day4 {

    public static void main(String[] args) {
        int[] money = {1,2,3,4};
        System.out.printf(String.valueOf(Solution.solution(money)));
    }
}

class Solution {
    public static int solution(int[] money) {
        int answer = 0;
        int sum1 = 0;
        int sum2 = 0;
        boolean gap = false;

        // sum1
        for(int i=0; i<money.length-1;){
            if(i==0) {
                sum1+=money[i];
                i+=1;
                continue;
            }

            if(i==money.length-2){
                if(!gap){
                    sum1+=money[i];
                }
                gap = false;
                break;
            }

            if(money[i] > money[i+1] && !gap){
                sum1 += money[i];
                i+=1;
                gap = true;
            }else{
                sum1 += money[i+1];
                i+=2;
                gap = false;
            }
       }

        //sum2
        for(int i=1; i<money.length;i++){
            if(i==1) {
                sum2+=money[i];
                i+=1;
                continue;
            }

            if(i==money.length-1){
                if(!gap){
                    sum2+=money[i];
                }
                gap = false;
                break;
            }

            if(money[i] > money[i+1] && !gap){
                sum2 += money[i];
                i+=1;
                gap = true;
            }else{
                sum2 += money[i+1];
                i+=2;
                gap = false;
            }
        }

        answer = max(sum1,sum2);

        return answer;
    }
}

