public class Player {
    private String name;
    private int points;

    public Player(String name) {
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

    boolean isWinnerOver(Player other) {
        return getPoints() >= 4 && other.getPoints() >= 0 && (getPoints() - other.getPoints()) >= 2;
    }

    boolean hasAdvantangeOver(Player other) {
        return getPoints() > other.getPoints() && other.getPoints() >= 3;
    }

    boolean isLoveOver(Player other) {
        return getPoints() > 0 && other.getPoints() == 0;
    }

    boolean isDeuceWith(Player other) {
        return getPoints() == other.getPoints() && getPoints() >= 3;
    }

    boolean isNotDeuceAndEqualScoreWith(Player other) {
        return getPoints() == other.getPoints() && getPoints() < 4;
    }

    boolean isNotDeuceAndGreaterThan(Player other) {
        return getPoints() > other.getPoints() && getPoints() < 4;
    }
}
