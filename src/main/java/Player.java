import java.util.HashMap;
import java.util.Map;

public class Player {
    private static Map<Integer, String> scoreMap = new HashMap<Integer, String>() {{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forty");
    }};

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void wonScore() {
        this.score++;
    }

    boolean isWinnerOver(Player other) {
        return score >= 4 && other.score >= 0 && (score - other.score) >= 2;
    }

    boolean hasAdvantageOver(Player other) {
        return score > other.score && other.score >= 3;
    }

    boolean isDeuceWith(Player other) {
        return score == other.score && score >= 3;
    }

    boolean isNotDeuceAndEqualScoreWith(Player other) {
        return score == other.score && score < 4;
    }

    boolean isLoveOver(Player other) {
        return score > 0 && other.score == 0;
    }

    boolean isNotDeuceAndGreaterThan(Player other) {
        return score > other.score && score < 4;
    }

    public String getScoreString() {
        return scoreMap.getOrDefault(score, "");
    }
}
