public class TennisGame {
    private static final String LOVE    = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY  = "Thirty";
    private static final String FORTY   = "Forty";

    private static final String DEUCE   = "Deuce";

    private static final String ADVANTAGE = "Advantage %s";
    private static final String WIN       = "Win for %s";

    private int P1point = 0;
    private int P2point = 0;

    private String[] scoreName = new String[] { LOVE, FIFTEEN, THIRTY, FORTY };

    public String getScore() {
        int maxPoints = Math.max(P1point, P2point);

        if (maxPoints < 4) {
            return processForEarlyGame();
        }

        return processForLateGame();
    }

    private String processForEarlyGame() {
        if (P1point != P2point) {
            return scoreName[P1point] + "-" + scoreName[P2point];
        }

        if (P1point < 3) return scoreName[P1point] + "-All";
        else             return DEUCE;
    }

    private String processForLateGame() {
        int delta = Math.abs(P1point - P2point);

        switch (delta) {
            case  0: return DEUCE;
            case  1: return getAdvantageString();
            default: return getWinString();
        }
    }

    private String getAdvantageString() {
        return String.format(ADVANTAGE, getHigherPlayer());
    }

    private String getWinString() {
        return String.format(WIN, getHigherPlayer());
    }

    private String getHigherPlayer() {
        if (P1point > P2point) {
            return "player1";
        } else if (P2point > P1point) {
            return "player2";
        } else {
            return "";
        }
    }

    public void incrementPlayer1Score() {
        P1point++;
    }

    public void incrementPlayer2Score() {
        P2point++;
    }
}