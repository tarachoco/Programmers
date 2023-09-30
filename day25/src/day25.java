public class day25 {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    /*
        피보나치 수
        https://school.programmers.co.kr/learn/courses/30/lessons/12945
     */
    public static int solution(int n) {
        int answer = 0;
        int[] array = new int[n];

        array[0] = 1;
        array[1] = 1;

        // 오버플로우 문제 때문에 각 값을 1234567을 나눠주자 아님 long을 쓰던가
        for (int i=2; i<n; i++) {
            array[i] = (array[i-1] + array[i-2]) % 1234567;
        }

        answer = array[n-1];

        return answer;
    }
}
