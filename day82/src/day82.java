public class day82 {
    /*
        광물 캐기
        https://school.programmers.co.kr/learn/courses/30/lessons/172927
     */
    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        System.out.printf(""+solution(picks, minerals));
    }

    /*
               다 | 철 | 돌
          다 |  1 | 1 | 1
          철 |  5 | 1 | 1
          돌 | 25 | 5 | 1

          광석 5개씩 묶어 피로도 계산후 내림차로 정렬하여 다이아 곡괭이부터 사용하자
     */
    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        //마인이 작업을 끝내기까지 필요한 최소한의 피로도를 return

        int cnt = Math.min(minerals.length/5+1, picks[0]+picks[1]+picks[2]);
        int[][] group = new int[cnt][3]; // 광물별 피로도 계산산

       int dp=0, ip=0, sp=0;

        for(int i=0; i<minerals.length; i+=5){

            if(i/5==cnt){
                break;
            }

            for(int j=i; j<i+5; j++){

                switch (minerals[j]) {
                    case "diamond":
                        dp += 1;
                        ip += 5;
                        sp += 25;
                        break;
                    case "iron":
                        dp += 1;
                        ip += 1;
                        sp += 5;
                        break;
                    default:
                        dp += 1;
                        ip += 1;
                        sp += 1;
                        break;
                }

                if(j==minerals.length-1){
                    break;
                }

            }

            group[i/5][0] = dp;
            group[i/5][1] = ip;
            group[i/5][2] = sp;

            dp = ip = sp = 0;
        }
        
        return answer;
    }
}
