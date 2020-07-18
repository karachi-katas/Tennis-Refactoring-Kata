import java.util.HashMap;
import java.util.Map;

public class TennisGame {
    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    public int P1point = 0;
    public int P2point = 0;

    static final Map<Integer, String> scoreToString = new HashMap() {{
        put(LOVE, "Love");
        put(FIFTEEN, "Fifteen");
        put(THIRTY, "Thirty");
        put(FORTY, "Forty");
    }};

    public String getScore() {

        if (player2HasWon()) {
            return "Win for player2";
        }

        if (player1HasWon()) {
            return "Win for player1";
        }

        if (advantageForPlayer2()) {
            return "Advantage player2";
        }

        if (advantageForPlayer1()) {
            return "Advantage player1";
        }

        if (deuce())
            return "Deuce";

        if (scoreAreEqual()) {
            String score = getStringPointValueFor(P1point);
            return score + "-All";
        }

        String P1res = getStringPointValueFor(P1point);
        String P2res = getStringPointValueFor(P2point);
        return P1res + "-" + P2res;
    }

    private boolean advantageForPlayer1() {
        return P1point > P2point && P2point >= FORTY;
    }

    private boolean advantageForPlayer2() {
        return P2point > P1point && P1point >= FORTY;
    }

    private boolean player1HasWon() {
        return P1point > FORTY && P2point >= LOVE && (P1point - P2point) >= THIRTY;
    }

    private boolean player2HasWon() {
        return P2point > FORTY && P1point >= LOVE && (P2point - P1point) >= THIRTY;
    }

    private boolean deuce() {
        return P1point == P2point && P1point >= FORTY;
    }

    private boolean scoreAreEqual() {
        return P1point == P2point && P1point <= FORTY;
    }

    private String getStringPointValueFor(int points) {
        return scoreToString.get(points);
    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}