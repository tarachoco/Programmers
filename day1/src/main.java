import java.util.*;

public class main {
    public static void main(String[] args) {
        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
        System.out.printf("answer: " + String.valueOf(solution(arrows)));
    }

    public static class Cursor {
        int x = 0;
        int y = 0;
        boolean checked = false;

        public Cursor(int x, int y, boolean checked){
            this.x = x;
            this.y = y;
            this.checked = checked;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean isChecked() {
            return checked;
        }

        public int hashCode(){
            return Objects.hash(x,y);
        }

        public boolean equals(Object o) {
            return this.x == ((Cursor) o).x && this.y == ((Cursor) o).y;
        }
    }

    public static int solution(int[] arrows) {
        int answer = 0;
        int x = 0;
        int y = 0;
        List<Cursor> room = new ArrayList<Cursor>();

        // #1. 좌표기준 표시 남기기
        for(int arrow : arrows){
            Move move = Move.getDestination(arrow);
            x = x+move.x;
            y = y+move.y;
            room.add(new Cursor(x, y, true));
        }

        room.stream().forEach((cursor) -> {
            System.out.println("x: "+cursor.getX()+", y: "+cursor.getY()+"\n");
        });

        // #2. 좌표 기준으로 계산하기


        return answer;
    }

    public enum Move {
        LEFT(6,-1,0),
        RIGHT(2,0,1),
        UP(0,0,1),
        DOWN(4,0,-1),
        LEFTUP(7,1,1),
        LEFTDOWN(5,1,-1),
        RIGHTUP(1,-1,1),
        RIGHTDOWN(3,-1,-1),
        STOP(9,0,0);

        private int direction;
        private int x;
        private int y;

        Move(int direction, int x, int y){
            this.direction = direction;
            this.x = x;
            this.y = y;
        }

        public static Move getDestination(int direction){
            return Arrays.stream(Move.values())
                    .filter(m -> m.getDirection() == direction).findAny().orElse(Move.STOP);
        }

        public int getDirection(){ return direction; }
    }
}
