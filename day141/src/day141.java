import java.util.HashMap;

public class day141 {
    /*
        의상
        https://school.programmers.co.kr/learn/courses/30/lessons/42578
     */
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.printf(""+solution(clothes));
    }

    public static int solution(String[][] clothes) {
         int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        // 옷 종류 세팅
        for (String[] item : clothes) {
            if (map.containsKey(item[1])) {
                map.replace(item[1], map.get(item[1]) + 1);
            } else {
                map.put(item[1], 1);
            }
        }

        // 조합 수 구하기
        for (String key : map.keySet()) {
            answer *= 1 * map.get(key) + 1;
        }

        return answer - 1;
    }
}
