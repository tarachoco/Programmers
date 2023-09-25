import java.util.Arrays;

public class day22 {
    /*
        햄버거 만들기
        https://school.programmers.co.kr/learn/courses/30/lessons/133502
     */
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(ingredient));
    }

    public static int solution(int[] ingredient) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();

        Arrays.stream(ingredient).forEach(i->sb.append(i));
        String ingredients = sb.toString();

        while (ingredients.contains("1231")) {
            ingredients = ingredients.replaceFirst("1231","");
            answer++;
        }

        return answer;
    }
}
