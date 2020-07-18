public class TennisGame {
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";
    private static final String FIFTEEN = "Fifteen";
    private static final String LOVE = "Love";
    private static final String DEUCE = "Deuce";

    private int P1point = 0;
    private int P2point = 0;

    private String[] scoreName = new String[]{ LOVE, FIFTEEN, THIRTY, FORTY };

    public String getScore() {
        String score = "";
        score = below4Counting();
        score = somethingForAbove4Counts(score);
        return score;
    }

    private String somethingForAbove4Counts(String score) {
        score = deuceCondition(score);
        score = advantageCondition(score);
        score = winningConditions(score);
        return score;
    }

    private String winningConditions(String score) {
        int maxPoints = Math.max(P1point, P2point);
        int delta = Math.abs(P1point - P2point);

        if (maxPoints >= 4 && delta >= 2) {
            return "Win for " + getHigherPlayer();
        }

        return score;
    }

    private String advantageCondition(String score) {
        int maxPoints = Math.max(P1point, P2point);
        int delta = Math.abs(P1point - P2point);

        if (maxPoints >= 4 && delta == 1) {
            return "Advantage " + getHigherPlayer();
        }

        return score;
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

    private String deuceCondition(String score) {
        if (P1point == P2point && P1point >= 3)
            score = DEUCE;
        return score;
    }

    private String below4Counting() {
        int maxScore = Math.max(P1point, P2point);
        if (maxScore <= 3) {
            if (P1point == P2point) {
                if (P1point == 3) {
                    return DEUCE;
                }
                return scoreName[P1point] + "-All";
            } else {

                return scoreName[P1point] + "-" + scoreName[P2point];
            }
        }
        return "";
    }

    public void incrementPlayer1Score() {
        P1point++;
    }

    public void incrementPlayer2Score() {
        P2point++;
    }
}