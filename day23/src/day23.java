import java.util.Arrays;

public class day23 {
    /*
        K번째수
        https://school.programmers.co.kr/learn/courses/30/lessons/42748
     */
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Arrays.stream(solution(array, commands)).forEach(System.out::println);
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i=0; i<commands.length; i++) {
            int[] arr = Arrays.copyOfRange(array,commands[i][0]-1, commands[i][1]);
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2]-1];
        }

        return answer;
    }
}
