
public class TennisGame {
    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";


    public String getScore() {
        String score = "";

        if (P2point > FORTY && P1point >= LOVE && (P2point - P1point) >= THIRTY) {
            return "Win for player2";
        }

        if (P1point > FORTY && P2point >= LOVE && (P1point - P2point) >= THIRTY) {
            return "Win for player1";
        }

        if (P2point > P1point && P1point >= FORTY) {
            return "Advantage player2";
        }

        if (P1point > P2point && P2point >= FORTY) {
            return "Advantage player1";
        }

        if (deuce())
            return "Deuce";

        if (scoreAreEqual()) {
            score = getStringPointValueFor(P1point);
            return score + "-All";
        }

        P1res = getStringPointValueFor(P1point);
        P2res = getStringPointValueFor(P2point);
        return P1res + "-" + P2res;
    }

    private boolean playerOneAhead(int P1point, int P2point) {
        return P1point > P2point && P1point <= FORTY;
    }

    private boolean playerOneAheadAndPlayerTwoIsLove(int P1point, int P2point) {
        return P1point > LOVE && P2point == LOVE;
    }

    private boolean deuce() {
        return P1point == P2point && P1point >= FORTY;
    }

    private boolean scoreAreEqual() {
        return P1point == P2point && P1point <= FORTY;
    }

    private String getStringPointValueFor(int points) {
        if (points == LOVE)
            return "Love";
        if (points == FIFTEEN)
            return "Fifteen";
        if (points == THIRTY)
            return "Thirty";
        if (points == FORTY)
            return "Forty";

        return "";
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