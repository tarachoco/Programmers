
import java.util.Arrays;
import java.util.Map;

public class day58 {
    /*
        카펫
        https://school.programmers.co.kr/learn/courses/30/lessons/42842
     */
    public static void main(String[] args) {
        Arrays.stream(solution(24, 24)).forEach(System.out::println);
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int tiles = brown + yellow;

        int sqrt = (int) Math.sqrt(tiles);

        for(int i = 3; i <= sqrt; i++){
           if(tiles % i == 0){
               int x = i;
               int y = tiles / i;
               if ((x - 2) * (y - 2) == yellow) {
                   answer[0] = Math.max(x,y);
                   answer[1] = Math.min(x,y);
                   break;
               }
            }
        }

        return answer;
    }
}
