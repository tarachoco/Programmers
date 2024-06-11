import java.util.Arrays;

public class day98 {
    /*
        단어 퍼즐
        https://school.programmers.co.kr/learn/courses/30/lessons/12983
     */
    public static void main(String[] args) {
//        String[] strs = {"ba","an","nan","ban","n"};
        String[] strs = {"ba","na","n","a"};
//        String[] strs = {"app","ap","p","l","e","ple","pp"};
//        String[] strs = {"fal","ll","g","in","fa","li","n","l"}; //falling
        System.out.printf(""+solution(strs, "banana"));
    }
    
    /*
        뒤에서부터 단어 비교 진행해야 결합 조건을 확인할 수 있음
     */
    public static int solution(String[] strs, String t) {
        int answer = 0;

        int[] dp = new int[t.length()+1];

        for (int i=1; i<=t.length(); i++) {
            for (String s : strs) {

                // 단어길이 맞지 않음
                if (i - s.length() < 0) {
                    continue;
                }

                if (t.substring(i-s.length(), i).equals(s)) {
                    if ( i - s.length() == 0 ) {
                        dp[i] = 1;
                        continue;
                    }

                    dp[i] = dp[i] == 0 ? dp[i - s.length()] + 1 : Math.min(dp[i], dp[i - s.length()] + 1);

                }
            }
        }

        answer = dp[t.length()] == 0 ? -1 : dp[t.length()];

        return answer;
    }

    /*
        dfs 시간 초과
     */
//    static int result = Integer.MAX_VALUE;
//
//    public static int solution(String[] strs, String t) {
//        int answer = 0;
//
//        for (int i=0; i<strs.length; i++) {
//            if (t.startsWith(strs[i])) {
//                dfs(strs, strs[i], t, 1);
//            }
//        }
//
//        answer = result < Integer.MAX_VALUE ? result : -1;
//
//        return answer;
//    }
//
//    public static void dfs(String[] strs, String str, String t, int i) {
//        if (str.equals(t)) {
//            result = Math.min(result, i);
//            return;
//        }
//
//        if (i >= result) {
//            return;
//        }
//
//        for (int j=0; j<strs.length; j++) {
//            if (t.startsWith(str+strs[j])) {
//                dfs(strs, str+strs[j], t, i+1);
//            }
//        }
//    }
}
