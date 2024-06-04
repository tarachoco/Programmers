public class day95 {
    /*
        올바른 괄호의 갯수
        https://school.programmers.co.kr/learn/courses/30/lessons/12929
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(3));
    }

    public static int solution(int n) {
        int answer = dfs(n, 1);
        return answer ;
    }

    public static int dfs(int n, int brackets) {
        if (brackets < 0 || brackets > n) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        return dfs( n, brackets+1) + dfs( n-1, brackets-1);
    }
}
