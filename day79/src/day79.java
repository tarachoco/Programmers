public class day79 {

    /*
        사칙연산
        https://school.programmers.co.kr/learn/courses/30/lessons/1843
     */
    public static void main(String[] args) {
//        String[] arr = {"1", "-", "3", "+", "5", "-", "8"};
        String[] arr = {"5", "-", "3", "+", "1", "+", "2", "-", "4"};
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
    public static int solution(String arr[]) {
        int answer = -1;
        return answer;
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
