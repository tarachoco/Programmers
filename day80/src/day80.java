public class day80 {
    
    /*
        숫자 타자 대회
        https://school.programmers.co.kr/learn/courses/30/lessons/136797

        1 2 3
        4 5 6
        7 8 9
        * 0 #
     */
    public static void main(String[] args) {
        String numbers = "1756";
        System.out.printf(solution(numbers)+"");
    }

    /*
        최소 가중치로 노드를 순회해야함.
        => 다익스트라로 비용을 계산하자
        => dp로 각 비용을 계산해둬도 좋다.
     */
    public static int solution(String numbers) {
        int answer = 0;

        return answer;
    }
}
