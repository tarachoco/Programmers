import java.util.*;


/*
    오픈채팅방
 */

public class day9 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] str = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.printf("결과는?:"+ Arrays.toString(solution.solution(str)));
    }
}

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String,String> userInfo = new HashMap<>();

        for(String event : record){
            String[] info = event.split(" ",3);
            Status status = Status.findStatusByEvent(info[0]);
            switch (status){
                case ENTER:
                case CHANGE:
                    userInfo.put(info[1],info[2]);
                    break;
                case LEAVE:
                    break;
                default:
                    // ignore
            }
        }

        List<String> results = new ArrayList<>();
        for(String event : record){
            String[] info = event.split(" ",3);
            Status status = Status.findStatusByEvent(info[0]);
            if(status == Status.CHANGE) continue;
            results.add(String.format(status.getMessage(),userInfo.get(info[1])));
        }

        answer = results.toArray(new String[results.size()]);
        return answer;
    }

    public enum Status{
        ENTER("Enter","%s님이 들어왔습니다."),
        LEAVE("Leave","%s님이 나갔습니다."),
        CHANGE("Change","");

        private String status;
        private String message;

        Status(String status, String message){
            this.status = status;
            this.message = message;
        }

        public String getStatus(){
            return status;
        }

        public String getMessage(){
            return message;
        }

        public static Status findStatusByEvent(String event){
            return Arrays.stream(Status.values()).filter(s->s.getStatus().equals(event)).findAny().orElse(null);
        }
    }
}
