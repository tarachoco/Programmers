import java.util.Arrays;

public class day14 {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int result = solution(people, 100);
        System.out.printf("result="+result);
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;

        if (people.length == 1) return 1;

        Arrays.sort(people);

        int head = 0;
        int tail = people.length-1;

        while (tail >= head) {
            if (people[head] + people[tail] > limit) {
                answer++;
                tail--;
            } else {
                answer++;
                head++;
                tail--;
            }
        }

        return answer;
    }
}
