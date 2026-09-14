import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day92 {
    /*
        가장 긴 팰린드롬
        https://school.programmers.co.kr/learn/courses/30/lessons/12904
     */
    public static void main(String[] args) {
//        String s = "abacde";
//        String s = "hannah";
        String s = "asdfasdf";
//        String s = "abcdcba";
        System.out.printf("" + solution(s));
    }

    // 마나커 알고리즘
    public static int solution(String s) {
        int answer = 0;

        if (s.length() == 0) {
            return 0;
        }

        List<String> sb = new ArrayList<>();
        sb.add("#");
        for (int i=0; i<s.length(); i++) {
            sb.add(String.valueOf(s.charAt(i)));
            sb.add("#");
        }

        String[] arr = sb.toArray(new String[sb.size()]);
        int[] count = new int[arr.length];

        int r = 0, p = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i <= r) {
                count[i] = Math.min(count[2 * p - i], r - i);
            } else {
                count[i] = 0;
            }

            while (i - count[i] - 1 >= 0 && i + count[i] + 1 < arr.length && arr[i - count[i] - 1].equals(arr[i + count[i] + 1])) {
                count[i]++;
            }

            if (r < i + count[i]) {
                r = i + count[i];
                p = i;
            }
        }

        Arrays.sort(count);
        answer = count[count.length-1];

        return answer;
    }
}
