    import java.util.LinkedList;
    import java.util.Queue;

public class day37 {
    /*
        다리를 건너는 트럭
        1초에 한 칸씩
        https://school.programmers.co.kr/learn/courses/30/lessons/42583?language=java
     */
    public static void main(String[] args) {
        int[] truck_weights = {7,4,5,6};
        System.out.println(solution(2, 10, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        int i = 0;
        int bridge_weight = 0;

        while (i < truck_weights.length) {
            int truck = truck_weights[i];

            if (queue.size() == bridge_length) {
                // 다리를 다 건넜다
                bridge_weight-= queue.poll();
            }

            if (bridge_weight + truck <= weight) {
                queue.add(truck);
                bridge_weight+=truck;
                i++;
            } else {
                queue.add(0);
            }

            answer++;
        }

        return answer + bridge_length;
    }
}
