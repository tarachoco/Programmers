import java.util.Arrays;

public class day15 {
    /*
        탐욕법
        - #42862 체육복
        https://school.programmers.co.kr/learn/courses/30/lessons/42862
     */
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {3};

        int result = solution(n, lost, reserve);
        System.out.printf("result="+result);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n+2];

        Arrays.fill(students, 1);

        for (int l : lost) {
            students[l]--;
        }

        for (int r : reserve) {
            students[r]++;
        }

        int i=1;

        if (students[i] == 0 && n>1) {
            if (students[i+1] == 2) {
                students[i+1]--;
                answer++;
            }
        } else {
            answer++;
        }

        for (i=2; i<=n; i++) {
            if ( students[i] == 0 ) {
                if (students[i-1] == 2) {
                    answer++;
                } else if (students[i+1] == 2) {
                    students[i+1]--;
                    answer++;
                }
            } else {
                answer++;
            }
        }

        return answer;
    }
}
