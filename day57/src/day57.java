import java.util.*;

public class day57 {
    /*
        전력망을 둘로 나누기
        https://school.programmers.co.kr/learn/courses/30/lessons/86971
        자기 자식의 노드 개수를 세는 방법도 고려해볼 것
        UNION-FIND : 합집합 찾기 알고리즘
        https://blog.naver.com/ndb796/221230967614
     */
    public static void main(String[] args) {
//        int[][] wires = {{1,2 },{2,7},{3,7},{3,4},{4,5},{6,7}};
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.printf(""+solutionWithUnionFind(9,wires));
    }

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        Queue<int[]> queue;
        Set<Integer> groupA = new HashSet<>();
        Set<Integer> groupB = new HashSet<>();

        for (int i=0; i<wires.length; i++) {
            groupA = new HashSet<>();
            groupB = new HashSet<>();

            groupA.add(wires[i][0]);
            groupB.add(wires[i][1]);

            queue = new LinkedList<>();
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

    public static int[] parents;
    public static int solutionWithUnionFind(int n, int[][] wires) {
        int answer = 100;
        int idx = 0;
        parents = new int[n+1];
        while(idx < n-1) {
            for (int i=1; i<n+1; i++) {
                parents[i] =i;
            }

            for (int i=0; i<wires.length; i++) {
                if(idx == i) continue;

                int a = wires[i][0];
                int b = wires[i][1];

                union(a,b);
            }


            int tmp =0;
            // 1번 노드는 무조건 A group이라 간주. 찾아서 tmp 더한다.
            for (int i=1; i<n+1; i++) {
                if (find(parents[i]) == 1) {
                    tmp++;
                }
            }

            // 최솟값을 구한다.
            int res = Math.abs(n-2*tmp);

            answer = Math.min(res, answer);
            idx++;
        }

        return answer;
    }

    /*
        부모 노드를 찾는다.
     */
    public static int find(int x) {
        if(parents[x] ==x) return x;
        return find(parents[x]);
    }

    /*
        각 송전탑의 부모 노드를 찾아 값을 업데이트 해준다.
        송전탑 번호 = 배열 인덱스 동일
     */
    public static void union(int x, int y) {
        // x에 더 작은 번호의 노드가 오도록 변경한다.
        int rx = find(x);
        int ry = find(y);
        if (ry < rx) {
            int tmp = rx;
            rx = ry;
            ry = tmp;
        }

        if (rx!=ry) {
            parents[ry]= rx;
        }
    }
}
