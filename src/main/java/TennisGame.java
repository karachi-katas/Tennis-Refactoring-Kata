
public class TennisGame {
    public static final int MIN_DEUCE_POINT = 3;
    public static final int MIN_WINNING_DIFF = 2;
    public static final int MIN_WINNING_SCORE = 4;

    private Player player1;
    private Player player2;

    public TennisGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        if (player1.score >= MIN_WINNING_SCORE && (player1.score - player2.score) >= MIN_WINNING_DIFF) {
            return "Win for player1";
        }
        if (player2.score >= MIN_WINNING_SCORE && (player2.score - player1.score) >= MIN_WINNING_DIFF) {
            return "Win for player2";
        }

        if (player1.scoreEquals(player2) && player1.score < MIN_DEUCE_POINT) {
            return player1.getPoint().value + "-All";
        }
        if (player1.scoreEquals(player2) && player1.score >= MIN_DEUCE_POINT) {
            return "Deuce";
        }

        if (!player1.scoreEquals(player2) && (player1.score < MIN_DEUCE_POINT || player2.score < MIN_DEUCE_POINT )) {
            return player1.getPoint().value + "-" + player2.getPoint().value;
        }

        if (player1.score > player2.score && player2.score >= MIN_DEUCE_POINT) {
            return "Advantage player1";
        }

        if (player2.score > player1.score && player1.score >= MIN_DEUCE_POINT) {
            return "Advantage player2";
        }
        return "";
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