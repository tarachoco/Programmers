import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class day47 {
    /*
        달리기 경주
        https://school.programmers.co.kr/learn/courses/30/lessons/178871/solution_groups?language=java
     */
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        Arrays.stream(solution(players, callings)).forEach(System.out::println);
    }

    public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> locations = new HashMap<>();
        String[] race = new String[players.length];

        for (int i=0; i<players.length; i++) {
            locations.put(players[i],i);
            race[i] = players[i];
        }

        for (String player : callings) {
            int target = locations.get(player);
            String a = race[target];
            race[target] = race[target-1];
            race[target-1] = a;
            locations.put(player, target-1);
            locations.put(race[target], target);
        }

        return race;
    }
}
