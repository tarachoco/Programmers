public class day20 {
    /*
        JadenCase 문자열 만들기
        https://school.programmers.co.kr/learn/courses/30/lessons/12951
     */
    public static void main(String[] args) {
        String result = solution("3people unFollowed me ");
        System.out.println(result);
    }

    public static String solution(String s) {
        if (s.length() == 0) return s;

        int i = 1;

        StringBuilder sb = new StringBuilder(s.toLowerCase());
        sb.replace(0,1, sb.substring(0,1).toUpperCase());

        while (i<s.length()) {
            int start = s.indexOf(" ",i)+1;
            int end = start+1;

            if ( start < 0 || end >= s.length() ) break;
            sb.replace(start,end, sb.substring(start,end).toUpperCase());
            i += end - start;
        }

        return sb.toString();
    }
}
