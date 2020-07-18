
public class TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    TennisPlayer player1 = new TennisPlayer();
    TennisPlayer player2 =new TennisPlayer();

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        P1res = player1.getScoreValueAsString();
        P2res = player2.getScoreValueAsString();
        score = P1res + "-" + P2res;

        if (player1.hasSameScoreAs(player2) && !player1.isDeuceWith(player2)) {
            score = player1.getScoreValueAsString();
            score += "-All";
        }

        if (player1.isDeuceWith(player2))
            score = "Deuce";

        if (player1.isAtAdvantage(player2)) {
            score = "Advantage player1";
        }

        if (player2.isAtAdvantage(player1)) {
            score = "Advantage player2";
        }

        if (player1.hasWonAgainst(player2)) {
            score = "Win for player1";
        }
        if (player2.hasWonAgainst(player1)) {
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
        player1.addScore();
    }

    public void P2Score() {
        P2point++;
        player2.addScore();
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}
