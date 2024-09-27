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
        
        // 마지막으로 작업을 받은 시간을 구하기 위한 변수
        int min = 0;
        int max = 10000*n;

        int time = 0;
        int count = 0;

        // 이진탐색을 통해 마지막 작업을 수행하는 시간을 구한다.
        while (true) {
            
            int mid = (min+max)/2;
            count = calculate(mid, cores);

            if (min > max) {
                break;
            }

            // 작업 시간 갱신
            if (count >= n) { 
                max = mid-1;
                time = mid;
            } else {
                min = mid+1;
            }
        }

        count-=n;
        for (int i = cores.length-1; i>=0; i--){
            if (time % cores[i] == 0) {
                if (count == 0) {
                    answer = i+1;
                    break;
                }
                count--;
            }
        }

        return answer;
    }

    public static int calculate (int time, int[] cores) {

        if (time == 0) {
            return cores.length;
        }

        int count = cores.length; 
        
        // time까지 코어가 처리 가능한 작업 개수 갱신
        for(int i = 0; i<cores.length; i++){
            count += (time/cores[i]);
        }

        return count;
    }

    /*
        정확성은 성공이나 효율성에서 실패남
        이진탐색으로 시간복잡도 단축 필요
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
