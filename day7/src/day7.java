public class day7 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.printf("result = " + solution.solution("aabbaccc")); // 7
//        System.out.printf("result = " + solution.solution("ababcdcdababcdcd")); // 9
//        System.out.printf("result = " + solution.solution("abcabcdede")); // 8
//        System.out.printf("result = " + solution.solution("abcabcabcabcdededededede")); // 14
//        System.out.printf("result = " + solution.solution("xababcdcdababcdcd")); // 17
    }
}

//xababcdcdababcdcd

class Solution {
    public int solution(String s) {
        int answer = 0;
        int strLength = s.length();

        for(int i=1;i<s.length();i++){
            int cnt = 0;
            int prev = 0;
            String strTemp = s;
            String tget = s.substring(prev,i);
            for(int j=prev;j<strTemp.length();j+=i){
                if(strTemp.substring(j,tget.length()).equals(tget)){
                    cnt++;
                }else{
                    System.out.printf("tget="+tget+", cnt="+cnt+"\n");
                    strTemp = strTemp.replace(tget,String.valueOf(cnt));
                    continue;
                }
            }

            strLength = Math.min(strTemp.length(),strLength);
        }

        answer = strLength;

        return answer;
    }
}