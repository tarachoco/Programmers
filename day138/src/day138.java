public class day138 {
    /*
        약수의 개수와 덧셈
        https://school.programmers.co.kr/learn/courses/30/lessons/77884
     */
    public static void main(String[] args) {
        System.out.printf(""+solution(13, 17));
    }

    public static int solution(int left, int right) {
        int answer = 0;

        for (int i=left; i<=right; i++) {
            int count = getCount(i);

            if (count % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }

    public static int getCount(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) count++;
            else if (n % i == 0) count += 2;
        }
        return count;
    }
}
