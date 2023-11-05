import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class day44 {
    /*
        롤케이크 자르기
        https://school.programmers.co.kr/learn/courses/30/lessons/132265/questions?page=3
     */
    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(solution(topping));
    }

    public static int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int t : topping) {
            map.put(t, map.getOrDefault(t,0)+1);
        }

        for (int t : topping) {

            // set에 토핑을 추가해준만큼 맵에 저장된 토핑 개수를 하나 지운다.
            map.put(t, map.get(t)-1);
            set.add(t);

            if(map.get(t) == 0) {
                map.remove(t);
            }

            // 두 사이즈가 동일하면 공평하게 나뉜 것으로 본다.
            if(map.size() == set.size()) {
                answer++;
            }

        }

        return answer;
    }
}
