import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class day115 {
    /*
        제일 작은 수 제거하기
        https://school.programmers.co.kr/learn/courses/30/lessons/12935
     */
    public static void main(String[] args) {
        int[] arr = {10};
        Arrays.stream(solution(arr)).forEach(System.out::println);
    }

    public static int[] solution(int[] arr) {
        List<Integer> list = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int idx = 0;

        for (int i=0; i<arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                idx = i;
            }
            list.add(arr[i]);
        }

        list.remove(idx);

        if (list.size() == 0) {
            list.add(-1);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
