
public class TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    TennisPlayer p1TennisPlayer = new TennisPlayer();
    TennisPlayer p2TennisPlayer =new TennisPlayer();

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (P1point == P2point && P1point < 4) {
            score = p1TennisPlayer.getScoreValueAsString();
            score += "-All";
        }
        if (P1point == P2point && P1point >= 3)
            score = "Deuce";

        if (P1point > 0 && P2point == 0) {
            P1res = p1TennisPlayer.getScoreValueAsString();
            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (P2point > 0 && P1point == 0) {
            P2res = p2TennisPlayer.getScoreValueAsString();
            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (P1point > P2point && P1point < 4) {
            P1res = p1TennisPlayer.getScoreValueAsString();
            P2res = p2TennisPlayer.getScoreValueAsString();
            score = P1res + "-" + P2res;
        }
        if (P2point > P1point && P2point < 4) {
            P1res = p1TennisPlayer.getScoreValueAsString();
            P2res = p2TennisPlayer.getScoreValueAsString();
            score = P1res + "-" + P2res;
        }

        if (p1TennisPlayer.isAtAdvantage(p2TennisPlayer)) {
            score = "Advantage player1";
        }

        if (p2TennisPlayer.isAtAdvantage(p1TennisPlayer)) {
            score = "Advantage player2";
        }

        if (p1TennisPlayer.hasWonAgainst(p2TennisPlayer)) {
            score = "Win for player1";
        }
        if (p2TennisPlayer.hasWonAgainst(p1TennisPlayer)) {
            score = "Win for player2";
        }
        return score;
    }

    private boolean whenPlayersHaveEqualScoreAndNotDeuce() {
        return P1point == P2point && P1point < 4;
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
        p1TennisPlayer.addScore();
    }

    public void P2Score() {
        P2point++;
        p2TennisPlayer.addScore();
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}
