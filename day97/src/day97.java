import java.util.*;

public class day97 {
    /*
        호텔 방 배정
        https://school.programmers.co.kr/learn/courses/30/lessons/64063
     */
    public static void main(String[] args) {
        long[] room_number = {1, 3, 4, 1, 3, 1};
        Arrays.stream(solution(6, room_number)).forEach(System.out::println);
    }

    static HashMap<Long, Long> map = new HashMap<>();

    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i=0; i<room_number.length; i++) {
            answer[i] = findRoom(room_number[i]);
        }

        return answer;
    }

    public static long findRoom(long room_number) {
        if (!map.containsKey(room_number)) {
            map.put(room_number, room_number+1);
            return room_number;
        }

        long next = findRoom(map.get(room_number));
        map.put(room_number, next);
        return next;
    }

    /*
        정확도는 성공이나 효율성 실패
     */
//    public static long[] solution(long k, long[] room_number) {
//        long[] answer = new long[room_number.length];
//
//        Set<Long> set = new HashSet<>();
//
//        for (int i=0; i<room_number.length; i++) {
//            while (set.contains(room_number[i])) {
//                room_number[i]++;
//            }
//            set.add(room_number[i]);
//            answer[i] = room_number[i];
//        }
//
//        return answer;
//    }
}
