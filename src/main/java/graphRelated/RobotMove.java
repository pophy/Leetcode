package graphRelated;

import org.junit.jupiter.api.Test;

import java.util.Objects;

public class RobotMove {

    public boolean judgeCircle(String moves) {
        Position startPos = new Position(0, 0);
        Position endPos = startPos;
        for (char d : moves.toCharArray()) {
            endPos = move(endPos,d);
        }
        return startPos.equals(endPos);
    }

    public Position move(Position pos, char direction) {
        int x = pos.x;
        int y = pos.y;
        switch (direction) {
            case 'U':
                x += -1;
                break;
            case 'D':
                x += 1;
                break;
            case 'L':
                y += -1;
                break;
            case 'R':
                y += 1;
                break;
        }
        return new Position(x, y);
    }

    private class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }


    }
}
