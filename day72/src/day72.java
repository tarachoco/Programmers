import com.sun.istack.internal.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class day72 {
    /*
        베스트앨범
        https://school.programmers.co.kr/learn/courses/30/lessons/42579
     */
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        Arrays.stream(solution(genres, plays)).forEach(System.out::println);
    }

    public static int[] solution(String[] genres, int[] plays) {
        int limit = 2;
        Map<String, Album> map = new HashMap<>();

        for (int i=0; i<genres.length; i++) {
            if (map.containsKey(genres[i])) {
                map.get(genres[i]).count+=plays[i];
                map.get(genres[i]).songList.add(i);
            } else {
                Album album = new Album(genres[i], plays[i], new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return plays[o2] - plays[o1];
                    }
                }));
                album.songList.offer(i);
                map.put(genres[i], album);
            }
        }

        List<Album> list = map.values().stream()
                .sorted(Comparator.comparingInt(o -> o.count))
                .collect(Collectors.toList());

        List<Integer> answer = new ArrayList<>();
        for (Album album : list) {
            int cnt = 0;
            while (cnt < limit && !album.songList.isEmpty()) {
                answer.add(album.songList.poll());
                cnt++;
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }

    public static class Album {
        String genre;
        int count;
        PriorityQueue<Integer> songList;

        public Album(String genre, int count, PriorityQueue<Integer> songList) {
            this.genre = genre;
            this.count = count;
            this.songList = songList;
        }
    }
}
