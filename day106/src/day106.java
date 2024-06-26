import java.util.*;

public class day106 {
    /*
        소수 찾기
        https://school.programmers.co.kr/learn/courses/30/lessons/42839
     */
    public static void main(String[] args) {
        System.out.printf(""+solution("011"));
    }

    static int result = 0;
    static Set<String> set;

    public static int solution(String numbers) {
        int answer = 0;
        String[] arr = numbers.split("");
        set = new HashSet<>();

        for (int i=0; i<numbers.length(); i++) {
            boolean[] visited = new boolean[numbers.length()];
            char n = numbers.charAt(i);
            if ('0' != n) {
                if (isPrime(String.valueOf(n))) {
                    set.add(String.valueOf(n));
                }
                visited[i] = true;
                dfs(String.valueOf(n), arr, visited);
                visited[i] = false;
            }
        }

        answer = set.size();

        return answer;
    }

    public static void dfs(String n, String[] arr, boolean[] visited) {
        for (int i=0; i<arr.length; i++) {
            if (!visited[i]) {
                if (isPrime(n+arr[i])) {
                    set.add(String.valueOf(n+arr[i]));
                }
                visited[i] = true;
                dfs(n+arr[i], arr, visited);
                visited[i] = false;
            }
        }
    }

    // 에라토스테네스 체
    public static boolean isPrime(String s) {
        int n = Integer.parseInt(s);

        if (n < 2) {
            return false;
        }

        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
          if (n % i == 0) {
              return false;
          }
        }
        return true;
    }
}
