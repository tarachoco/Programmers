public class day24 {
    /*
        내적
        https://school.programmers.co.kr/learn/courses/30/lessons/70128
     */
    public static void main(String[] args) {
        int[] a = {-1,0,1};
        int[] b = {1,0,-1};
        System.out.println(solution(a,b));
    }

    // 벡터를 수처럼 곱하여 구한다.
    public static int solution(int[] a, int[] b) {
        int answer = 0;

        for (int i=0; i<a.length; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }
}
