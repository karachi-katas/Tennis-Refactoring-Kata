public class TennisPlayer {
    private String name;
    private int points;

    public TennisPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void wonPoint() {
        this.points++;
    }
}
