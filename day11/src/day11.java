import java.util.Arrays;

public class day11 {
    /* 뒤에서부터 큰 수 찾기 */
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        solution(numbers);
    }

    public static int[] solution(int numbers[]) {
        int numbers_len = numbers.length;
        int[] answer = new int[numbers_len];

        Arrays.fill(answer, -1);

        for (int i=0; i<numbers_len; i++) {
            for (int j=i+1; j<numbers_len; j++) {
                if (numbers[i] < numbers[j]) {
                    answer [i] = numbers[j];
                    break;
                }
            }
        }

        Arrays.stream(answer).forEach(System.out::println);

        return answer;
    }
}