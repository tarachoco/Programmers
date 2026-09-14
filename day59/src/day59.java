
import java.util.Arrays;

public class day59 {
    /*
        이모티콘 할인 행사
        https://school.programmers.co.kr/learn/courses/30/lessons/150368
     */
    public static void main(String[] args) {
//        int[][] users = {{40, 10000}, {25, 10000}};
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
//        int[] emoticons = {7000, 9000};
        int[] emoticons = {1300, 1500, 1600, 4900};

        Arrays.stream(solution(users, emoticons)).forEach(System.out::println);
    }

    static int[] discounts = {10, 20, 30, 40};
    static int member = 0;
    static int profit = 0;

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        find(0, users, emoticons, new int[emoticons.length]);

        answer[0] = member;
        answer[1] = profit;

        return answer;
    }

    /*
        할인종류 ^ 이모티콘 개수 이므로 완전탐색이다.
        탐색 여부 불필요
     */
    public static void find(int depth, int[][] users, int[] emoticons, int[] discountsCase) {
        if (depth == emoticons.length) {
            int mem = 0;
            int total = 0;

            for (int i=0; i<users.length; i++) {
                int sum = 0;
                for (int j=0; j<emoticons.length; j++) {
                    if (users[i][0] > discountsCase[j]) {
                        continue;
                    }

                    int price = emoticons[j] * (100 - discountsCase[j]) / 100;

                    if (price+sum >= users[i][1]) {
                        mem++;
                        sum=0;
                        break;
                    } else {
                        sum+=price;
                    }
                }
                total+=sum;
            }

            if ( mem > member ) {
                member = mem;
                profit = total;
            } else if (mem == member && total > profit) {
                profit = total;
            }

            return;
        }
        for (int i=0; i<4; i++) {
            discountsCase[depth] = discounts[i];
            find(depth+1, users, emoticons, discountsCase);
        }
    }
}
