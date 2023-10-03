import java.util.*;

public class day27 {
    /*
        귤 고르기
        https://school.programmers.co.kr/learn/courses/30/lessons/138476/solution_groups?language=java
     */
    public static void main(String[] args) {
        int[] tangerine = {1};
        System.out.println(solution(1, tangerine));
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());

        long sum = 0;
        for (int i=0; sum<k; i++) {
            sum += list.get(i);
            answer++;
        }

        return answer;
    }
}
