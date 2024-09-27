import java.util.ArrayList;
import java.util.List;

public class day56 {
    /*
        피로도
        https://school.programmers.co.kr/learn/courses/30/lessons/87946
     */
    public static void main(String[] args) {
//        int[][] dungeons = {{80,20},{50,40},{30,10}};
        int[][] dungeons = {{40,20},{40,30},{40,40},{40,50}};
        System.out.printf("" + solution(100, dungeons));
    }

    private static int answer = 0;

    public static int solution(int k, int[][] dungeons) {
        List<Integer> remains = new ArrayList<>();

        for (int i=0; i<dungeons.length; i++) {
            remains.add(i);
        }

        for (int i=0; i<dungeons.length; i++) {
            List<Integer> r = new ArrayList<>();
            r.addAll(remains);
            r.remove(i);
            dfs(k-dungeons[i][1], dungeons, r);
        }

        return answer;
    }

    public static void dfs (int k, int[][] dungeons, List<Integer> remains) {

        // 기저사례 1. remains 가 남아있지 않으면 모든 던전을 다 돌았다
        if (remains.size() == 0) {
            answer = dungeons.length;
            return;
        }

        for (int i=0; i<remains.size(); i++) {
            // 기저사례 2. k가 현재 소모 필요한 피로도보다 적다면 더이상 돌 수 있는 던전이 없다.
            if ( k < dungeons[remains.get(i)][0]) {
                answer = Math.max(answer, dungeons.length - remains.size());
                continue;
            }
            List<Integer> r = new ArrayList<>();
            r.addAll(remains);
            r.remove(i);
            dfs(k-dungeons[remains.get(i)][1], dungeons, r);
        }
    }
}
