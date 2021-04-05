import org.testng.annotations.Test;

public class Hanoi {

    public void play(int rest, int down, String from, String to, String help) {
        if (rest == 1) {
            System.out.println("move " + down + " from " + from + " to " + to);
        } else {
            play(rest-1,down-1,from,help,to);
            play(1,down,from,to,help);
            play(rest-1,down-1,help,to,from);
        }
    }

    @Test
    public void test() {
        play(3,3,"left","right","help");
    }
}
