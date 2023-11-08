public class day45 {
    /*
        점프와 순간이동
        https://school.programmers.co.kr/learn/courses/30/lessons/12980
     */
    public static void main(String[] args) {
        System.out.println(solution(5000));
    }

    public static int solution(int n) {
        int ans = 0;

        while(n > 0) {
            if(n % 2 == 0) {
                n = n / 2;
                continue;
            }
            n--;
            ans++;
        }

        return ans;
    }
}
