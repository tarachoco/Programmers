public class day76 {
    /*
        선입 선출 스케줄링
        https://school.programmers.co.kr/learn/courses/30/lessons/12920
     */
    public static void main(String[] args) {
        int n = 6;
        int[] cores = {1, 2, 3};
        System.out.printf("" + solution(n, cores));
    }

    public static int solution(int n, int[] cores) {
        int answer = 0;

        return answer;
    }

    /*
        정확성은 성공이나 효율성은 낮음.
        이분탐색으로 시간복잡도 단축 필요 
     */
//    public static int solution(int n, int[] cores) {
//        int answer = 0;
//        int index = cores.length;
//        int step = 0;
//
//        while (index < n) {
//            step++;
//
//            for (int i=0; i<cores.length; i++) {
//                if (step % cores[i] == 0) {
//                    index++;
//                    if (index == n) {
//                        answer = i+1;
//                        break;
//                    }
//                }
//            }
//        }
//
//        return answer;
//    }
}
