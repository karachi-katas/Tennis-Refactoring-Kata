
public class TennisGame {
    public static final int MIN_DEUCE_POINT = 3;
    public static final int MIN_WINNING_DIFF = 2;

    private Player player1;
    private Player player2;

    public TennisGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        String score = "";
        if (player1.getPoint() == player2.getPoint() && player1.getPoint().score < MIN_DEUCE_POINT) {
            score = player1.getPoint().value + "-All";
        }
        if (player1.getPoint().equals(player2.getPoint()) && player1.getPoint().score >= MIN_DEUCE_POINT) {
            score = "Deuce";
        }

        if (player1.getPoint() != player2.getPoint() && player1.getPoint().score < MIN_DEUCE_POINT) {
            score = player1.getPoint().value + "-" + player2.getPoint().value;
        }

        if (player1.getPoint().score > player2.getPoint().score && player2.getPoint().score >= MIN_DEUCE_POINT) {
            score = "Advantage player1";
        }

        if (player2.getPoint().score > player1.getPoint().score && player1.getPoint().score >= MIN_DEUCE_POINT) {
            score = "Advantage player2";
        }

        if (player1.getPoint().score >= 4 && player2.getPoint().score >= 0 && (player1.getPoint().score - player2.getPoint().score) >= MIN_WINNING_DIFF) {
            score = "Win for player1";
        }
        if (player2.getPoint().score >= 4 && player1.getPoint().score >= 0 && (player2.getPoint().score - player1.getPoint().score) >= MIN_WINNING_DIFF) {
            score = "Win for player2";
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
        player1.increment();
    }

    public void P2Score() {
        player2.increment();
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            P1Score();
        else
            P2Score();
    }
}