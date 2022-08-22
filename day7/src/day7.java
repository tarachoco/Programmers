import jdk.nashorn.internal.ir.SplitReturn;

public class day7 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.printf("result = " + solution.solution("aabbaccc")); // 7
//        System.out.printf("result = " + solution.solution("ababcdcdababcdcd")); // 9
//        System.out.printf("result = " + solution.solution("abcabcdede")); // 8
//        System.out.printf("result = " + solution.solution("abcabcabcabcdedededededeee")); // 16
//        System.out.printf("result = " + solution.solution("xababcdcdababcdcd")); // 17
//        String test = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        String test = "xxxxxxxxxxyyy";
//        System.out.printf("result = " + solution.solution(test)); // 5
    }
}

/*
    문자열 압축
 */

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for(int i=1; i<=s.length()/2; i++){
            String tget = s.substring(0,i);
            String tempStr = s;
            int cnt = 1;
            int prev = 0;
            for(int j=i; j<=s.length();j+=i){
                if(j+i > s.length()){
                    if(cnt > 1) {
                        String replaceTget = s.substring(prev, j);
                        tempStr = tempStr.replace(replaceTget, String.valueOf(cnt) + tget);
                    }
                    break;
                }
                String nextTget = s.substring(j,j+i);
                if(tget.equals(nextTget)){
                    cnt++;
                }else{
                    if( cnt > 1 ) {
                        String replaceTget = s.substring(prev, j);
                        tempStr = tempStr.replace(replaceTget, String.valueOf(cnt) + tget);
                    }
                    tget = nextTget;
                    cnt=1;
                    prev=j;
                }
            }
            answer = Math.min(answer,tempStr.length());
        }

        return answer;
    }
}