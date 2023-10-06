import java.util.HashMap;
import java.util.Map;

public class day29 {
    /*
        추억 점수
        https://school.programmers.co.kr/learn/courses/30/lessons/176963/solution_groups?language=java
     */
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}};

        int[] results = solution(name, yearning, photo);
        System.out.println("end");
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i=0; i<photo.length; i++) {
            int sum = 0;
            for (int j=0; j<photo[i].length; j++) {
                sum += map.getOrDefault(photo[i][j],0);
            }
            answer[i] = sum;
        }

        return answer;
    }
}
