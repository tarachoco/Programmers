//public class day7 {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
////        System.out.printf("result = " + solution.solution("aabbaccc")); // 7
////        System.out.printf("result = " + solution.solution("ababcdcdababcdcd")); // 9
////        System.out.printf("result = " + solution.solution("abcabcdede")); // 8
//        System.out.printf("result = " + solution.solution("abcabcabcabcdededededede")); // 14
////        System.out.printf("result = " + solution.solution("xababcdcdababcdcd")); // 17
//    }
//}
//
////xababcdcdababcdcd
//
//class Solution {
//    public int solution(String s) {
//        int answer = 0;
//        int leng = s.length();
//        int minStrLength = s.length();
//
//        for(int i=1; i<s.length(); i++){
//            String tget = null;
//            String strTemp = s;
//            int cnt = 1;
//            int prev = 0;
//            for(int j=i; j<leng-i; j+=i){
//                if(j==i){
//                    tget = s.substring(prev,j);
//                }
//                String nextTget = s.substring(j,j+i);
//                System.out.printf("nextTget="+nextTget+"\n");
//                if(s.substring(j,j+i).equals(tget)){
//                    cnt++;
//                    String nextNextTget = s.substring(j+i,j+i*2);
//                    System.out.printf("nextNextTget="+nextNextTget+"\n");
//                    if(j+i*2 >= s.length()){
//                        String replace = s.substring(prev,j+i*2);
//                        System.out.printf("끝이다! 마지막으로 바꿀 내용은? " + replace +", i="+i+"\n");
//                        System.out.printf("그리고 바꿀 대상은 ? " + strTemp+"\n");
//                        strTemp = strTemp+String.valueOf(cnt)+tget;
//                        System.out.printf("길이 바꾸기 1 :" +strTemp+"\n");
//                        minStrLength = Math.min(minStrLength,strTemp.length());
//                        cnt = 1;
//                        prev = j;
//                        continue;
//                    }
//                    if(!nextNextTget.equals(tget)){
//                        if(cnt > 1){
//                            String replace = s.substring(prev,j+i);
//                            strTemp = strTemp.replace(replace,String.valueOf(cnt)+tget);
//                        }
//                    }else{
//                        strTemp = strTemp.replace(tget,"");
//                        continue;
//                    }
//                }else{
//                    tget = s.substring(j,j+i);
//                    cnt = 1;
//                    prev = j;
//                    continue;
//                }
//            }
//            System.out.printf("strTemp="+ strTemp+", minStrLength="+minStrLength+"\n");
//        }
//
//        answer = minStrLength;
//
//        return answer;
//    }
//}