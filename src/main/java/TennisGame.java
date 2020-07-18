
public class TennisGame {
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String FIFTEEN = "Fifteen";
    public static final String LOVE = "Love";
    public static final String DEUCE = "Deuce";
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";

    public String getScore() {
        String score = "";

        score = equalAndBelow4(score);
        score = deuceCondition(score);
        score = player1InitialAdvantage(score);
        score = player2InitialAdvantage(score);
        score = lessThan4Counting(score);
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

    private String lessThan4Counting(String score) {
        if (P1point > P2point && P1point < 4) {
            if (P1point == 2)
                P1res = THIRTY;
            if (P1point == 3)
                P1res = FORTY;
            if (P2point == 1)
                P2res = FIFTEEN;
            if (P2point == 2)
                P2res = THIRTY;
            score = P1res + "-" + P2res;
        }

        if (P2point > P1point && P2point < 4) {
            if (P2point == 2)
                P2res = THIRTY;
            if (P2point == 3)
                P2res = FORTY;
            if (P1point == 1)
                P1res = FIFTEEN;
            if (P1point == 2)
                P1res = THIRTY;
            score = P1res + "-" + P2res;
        }
        return score;
    }

    private String player2InitialAdvantage(String score) {
        if (P2point > 0 && P1point == 0) {
            if (P2point == 1)
                P2res = FIFTEEN;
            if (P2point == 2)
                P2res = THIRTY;
            if (P2point == 3)
                P2res = FORTY;

            P1res = LOVE;
            score = P1res + "-" + P2res;
        }
        return score;
    }

    private String player1InitialAdvantage(String score) {
        if (P1point > 0 && P2point == 0) {
            if (P1point == 1)
                P1res = FIFTEEN;
            if (P1point == 2)
                P1res = THIRTY;
            if (P1point == 3)
                P1res = FORTY;

            P2res = LOVE;
            score = P1res + "-" + P2res;
        }
        return score;
    }

    private String deuceCondition(String score) {
        if (P1point == P2point && P1point >= 3)
            score = DEUCE;
        return score;
    }

    private String equalAndBelow4(String score) {
        if (P1point == P2point && P1point < 4) {
            if (P1point == 0)
                score = LOVE;
            if (P1point == 1)
                score = FIFTEEN;
            if (P1point == 2)
                score = THIRTY;
            score += "-All";
        }

        return score;
    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

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