public class day96 {
    /*
        쿠키 구입
        https://school.programmers.co.kr/learn/courses/30/lessons/49995
     */
    public static void main(String[] args) {
        int[] cookie = {5,5,5,5};
        System.out.printf(""+solution(cookie));
    }
    
    public static int solution(int[] cookie) {
        int answer = 0;

        // 쿠키[i] 값 기준으로 left, right 늘려가며 비교한다.
        for (int i=0; i<cookie.length-1; i++) {
            int l = i;
            int r = i+1;
            int left = cookie[l];
            int right = cookie[r];

            while (l >= 0 && r < cookie.length) {
                if (left == right) {
                    answer = Math.max(answer, left);
                    l--;
                    if (l >= 0) {
                        left += cookie[l];
                    }
                    r++;
                    if (r < cookie.length) {
                        right += cookie[r];
                    }
                } else if (left > right) {
                    r++;
                    if (r < cookie.length) {
                        right += cookie[r];
                    }
                } else {
                    l--;
                    if (l >= 0) {
                        left += cookie[l];
                    }
                }
            }
        }

        return answer;
    }
}
