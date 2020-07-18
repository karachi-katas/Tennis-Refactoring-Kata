
public class TennisGame {
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String FIFTEEN = "Fifteen";
    public static final String LOVE = "Love";
    public static final String DEUCE = "Deuce";
    public int P1point = 0;
    public int P2point = 0;
    public String[] scoreName = new String[]{LOVE, FIFTEEN, THIRTY, FORTY};

    public String P1res = "";
    public String P2res = "";


    public String getScore() {
        int maxScore = Math.max(P1point, P2point);
        String score = "";
//        if (maxScore < 3) {
//            if (P1point == P2point) {
//                return P1res + "-All";
//            }
//            else {
//                return P1res + "-" + P2res;
//            }
//            // TODO: Simple Counting Case
//        }
        score = below4Counting(score);
        score  = somethingForAbove4Counts(score);
        return score;
    }

    private String somethingForAbove4Counts(String score) {
        score = deuceCondition(score);
        score = advantageConditions(score);
        score = winningConditions(score);
        return score;
    }


    private String winningConditions(String score) {
        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private String advantageConditions(String score) {
        if (P1point > P2point && P2point >= 3) {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3) {
            score = "Advantage player2";
        }
        return score;
    }

    private String deuceCondition(String score) {
        if (P1point == P2point && P1point >= 3)
            score = DEUCE;
        return score;
    }

    private String below4Counting(String score) {
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

    void incrementPlayer1Score() {
        P1point++;
//        if (P1point < 3) {
//            P1res = scoreName[P1point];
//        }
//        else {
//            if (P1point == P2point) {
//                P1res = DEUCE;
//                P2res = DEUCE;
//            } else {
//
//            }
//        }


    }

    void incrementPlayer2Score() {
        P2point++;
//        P2res = scoreName[P2point];
    }
}