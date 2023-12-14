import java.util.HashSet;
import java.util.Set;

public class day56 {
    /*
        피로도
        https://school.programmers.co.kr/learn/courses/30/lessons/87946
     */
    public static void main(String[] args) {

    }

    private static int answer = 0;

    public static int solution(int k, int[][] dungeons) {
        Set<Integer> remains = new HashSet<>();

        for (int i=0; i<dungeons.length; i++) {
            remains.add(i);
        }

        for (int i=0; i<dungeons.length; i++) {
            dfs(k-dungeons[i][1], dungeons, remains);
        }

        return answer;
    }

    public static void dfs (int k, int[][] dungeons, Set<Integer> remains) {
        for (int i=0; i<remains.size(); i++) {
            dfs(k, dungeons, remains);
        }
    }
}
