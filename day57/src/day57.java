import java.util.*;

public class day57 {
    /*
        전력망을 둘로 나누기
        https://school.programmers.co.kr/learn/courses/30/lessons/86971
        자기 자식의 노드 개수를 세는 방법도 고려해볼 것
     */
    public static void main(String[] args) {
        int[][] wires = {{1,2 },{2,7},{3,7},{3,4},{4,5},{6,7}};
//        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.printf(""+solution(7,wires));
    }

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i=0; i<wires.length; i++) {
            Set<Integer> groupA = new HashSet<>();
            Set<Integer> groupB = new HashSet<>();

            groupA.add(wires[i][0]);
            groupB.add(wires[i][1]);

            Queue<int[]> queue = new LinkedList<>();
            for (int j=0; j<wires.length; j++) {
                if (i==j) {
                    continue;
                }
                queue.offer(wires[j]);
            }

            while (queue.size() > 0) {
                int[] wire = queue.poll();
                if (groupA.contains(wire[0]) || groupA.contains(wire[1])) {
                    groupA.add(wire[0]);
                    groupA.add(wire[1]);
                } else if (groupB.contains(wire[0]) || groupB.contains(wire[1])) {
                    groupB.add(wire[0]);
                    groupB.add(wire[1]);
                } else {
                    queue.offer(wire);
                }
            }

            answer = Math.min(Math.abs(groupA.size() - groupB.size()), answer);
        }

        return answer;
    }
}
