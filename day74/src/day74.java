import java.util.Arrays;
import java.util.Comparator;

public class day74 {
    /*
        단속카메라
        https://school.programmers.co.kr/learn/courses/30/lessons/42884\
        탐욕법 - 그리디 알고리즘
     */
    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.printf(""+solution(routes));
    }


    public static int solution(int[][] routes) {
        // 종료지점 순으로 정렬
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        // 첫번째 종료지점
        int endPoint = routes[0][1];
        int answer = 1;

        // routes 순회하면서 현재 끝점보다 크면 엔드포인트 재지정 및 단속카메라를 추가한다.
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > endPoint) {
                answer++;
                endPoint = routes[i][1];
            }
        }
        return answer;
    }
}
