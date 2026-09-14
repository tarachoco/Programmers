public class day89 {
    /*
        기지국 설치
        https://school.programmers.co.kr/learn/courses/30/lessons/12979
     */
    public static void main(String[] args) {
        int n = 11;
        int[] stations = {4, 11};
        int w = 1;
//        int n = 16;
//        int[] stations = {9};
//        int w = 2;
//        int n = 10;
//        int[] stations = {};
//        int w = 2;
        System.out.printf(""+solution(n, stations, w));
    }

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int now = 1;
        int stationsIdx = 0;

        while (now <= n) {
            if ( stationsIdx >= stations.length || now < stations[stationsIdx] - w ) {
                answer++;
                now += 2 * w + 1;
            } else {
                now = stations[stationsIdx] + w + 1;
                stationsIdx++;
            }
        }

        return answer;
    }
}
