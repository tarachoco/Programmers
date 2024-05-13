public class day79 {

    /*
        사칙연산
        https://school.programmers.co.kr/learn/courses/30/lessons/1843
     */
    public static void main(String[] args) {
//        String[] arr = {"1", "-", "3", "+", "5", "-", "8"};
//        String[] arr = {"5", "-", "3", "+", "1", "+", "2", "-", "4"};
//        String[] arr = {"5", "+", "3", "-", "1", "+", "2", "-", "4"};
//        String[] arr = {"1", "+", "2", "+", "3", "+", "4", "+", "5"};

        String[] arr = {"5", "-", "10", "+", "1", "+", "2", "-", "4"}; // -4
        System.out.printf(""+solution(arr));
    }

    /*
        점화식 잘못세웠다...
        dp 3차원 배열을 사용해서 풀이 필요하다.

        [규칙]
        a+b 의 최댓값 -> a는 최댓값, b도 최댓값
        a-b 의 최댓값 -> a는 최댓값, b는 최솟값
        a+b 의 최솟값 -> a는 최솟값, b도 최솟값
        a-b 의 최솟값 -> a는 최솟값, b는 최댓값
     */
    public static int[][][] dp;
    public static boolean[][][] visited;
    public static int numbers[];
    public static String operations[];

    public static int solution(String arr[]) {
        int answer = -1;
        // 숫자랑 부호 개수
        int size = arr.length/2+1;

        // dp 초기화
        //dp[0] : 최솟값
        //dp[1] : 최댓값
        dp = new int[2][size][size];
        numbers = new int[size];
        operations = new String[size-1];
        visited = new boolean[2][size][size];

        int n1 = 0;
        int o1 = 0;

        numbers[n1++] = Integer.parseInt(arr[0]);

        for (int i=1; i<arr.length; i++) {
            if (i%2 == 0) {
                numbers[n1++] = Integer.parseInt(arr[i]);
//                numbers[n1++] = arr[i-1].equals("+") ? Integer.parseInt(arr[i]) : -Integer.parseInt(arr[i]);
            } else {
                operations[o1++] = arr[i];
            }
        }

        answer = calculate(1, 0, size-1);

        return answer;
    }

    /*
        a+b -> a=max, b=max
        a-b -> a=max, b=min
        -(a+b) -> a=min, b=min
        -(a-b) -> a=min, b=max

        operation
            0:minus : min
            1:plus : max
     */
    public static int calculate(int operation, int start, int end) {

        // 마지막 숫자 하나가 선택된 경우
        if (start == end) {
            dp[operation][start][end] = numbers[start];
            return dp[operation][start][end];
        }

        // 방문한 값인 경우 기존 값을 재사용한다.
        if (visited[operation][start][end]) {
            return dp[operation][start][end];
        } else {
            visited[operation][start][end] = true;
        }

        int temp = (operation == 1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = start; i<end; i++) {
            if (operation == 1) {
                 if ("+".equals(operations[i])) {
                    temp = Math.max(temp, calculate(1, start, i)+calculate(1,i+1,end));
                } else {
                    temp = Math.max(temp, calculate(1, start, i)-calculate(0,i+1,end));
                }
            } else {
                if ("+".equals(operations[i])) {
                    temp = Math.min(temp, calculate(0, start, i)+calculate(0,i+1,end));
                } else {
                    temp = Math.min(temp, calculate(0, start, i)-calculate(1,i+1,end));
                }
            }
        }

        dp[operation][start][end] = temp;

        return temp;
    }

//    public static int solution(String arr[]) {
//        int answer = -1;
//
//        String arr2[] = arr.clone();
//
//        for (int i=0; i<arr.length-1; i=i+2) {
//            int a1 = apply(arr[i], arr[i+1], arr[i+2]);
//            int a2 = i >= arr.length - 3 ? Integer.MIN_VALUE : apply(arr[i], arr[i+1], String.valueOf(apply(arr[i+2], arr[i+3], arr[i+4])));
//
//            if (a1 > a2) {
//                arr[i+2] = String.valueOf(a1);
//            } else {
//                arr[i+4] = String.valueOf(a2);
//                i+=2;
//            }
//        }
//
//        for (int i=arr2.length-1; i>1; i=i-2) {
//            int a1 = apply(arr2[i-2], arr2[i-1], arr2[i]);
//            int a2 = i < 3 ? Integer.MIN_VALUE : apply(String.valueOf(apply(arr2[i-2], arr2[i-3], arr2[i-4])), arr2[i-1], arr2[i] );
//
//            if (a1 > a2) {
//                arr2[i-2] = String.valueOf(a1);
//            } else {
//                arr2[i-4] = String.valueOf(a2);
//                i-=2;
//            }
//        }
//
//        answer = Math.max(Integer.parseInt(arr[arr.length-1]),  Integer.parseInt(arr2[0]));
//
//        return answer;
//    }
//
//    public static int apply (String start, String oper, String end) {
//        int a1 = Integer.parseInt(start);
//        int a2 = Integer.parseInt(end);
//
//        if ("+".equals(oper)) {
//            return a1 + a2;
//        } else {
//            return a1 - a2;
//        }
//    }
}
