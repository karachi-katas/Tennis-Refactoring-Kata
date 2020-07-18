import java.util.HashMap;
import java.util.Map;

public class Player {
    private static Map<Integer, String> pointMap = new HashMap<Integer, String>() {{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forty");
    }};

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
        return points >= 4 && other.points >= 0 && (points - other.points) >= 2;
    }

    boolean hasAdvantageOver(Player other) {
        return points > other.points && other.points >= 3;
    }

    boolean isLoveOver(Player other) {
        return points > 0 && other.points == 0;
    }

    boolean isDeuceWith(Player other) {
        return points == other.points && points >= 3;
    }

    boolean isNotDeuceAndEqualScoreWith(Player other) {
        return points == other.points && points < 4;
    }

    boolean isNotDeuceAndGreaterThan(Player other) {
        return points > other.points && points < 4;
    }

    public String getPointsString() {
        return pointMap.getOrDefault(points, "");
    }
}
