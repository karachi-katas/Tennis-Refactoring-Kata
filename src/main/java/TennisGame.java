
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
        String x = getWinString();
        if (x != null) return x;

        String x1 = getTieString();
        if (x1 != null) return x1;

        String x2 = getAdvantageString();
        if (x2 != null) return x2;

        return player1.getPoint().value + "-" + player2.getPoint().value;
    }

    private String getAdvantageString() {
        if (player1.score > player2.score && player2.score >= MIN_DEUCE_POINT) {
            return "Advantage player1";
        }

        if (player2.score > player1.score && player1.score >= MIN_DEUCE_POINT) {
            return "Advantage player2";
        }
        return null;
    }

    private String getTieString() {
        if (player1.scoreEquals(player2) && player1.score < MIN_DEUCE_POINT) {
            return player1.getPoint().value + "-All";
        }
        if (player1.scoreEquals(player2) && player1.score >= MIN_DEUCE_POINT) {
            return "Deuce";
        }
        return null;
    }

    private String getWinString() {
        if (isWinPlayer1()) {
            return "Win for player1";
        }
        if (isWinPlayer2()) {
            return "Win for player2";
        }
        return null;
    }

    private boolean isWinPlayer2() {
        return player2.score >= MIN_WINNING_SCORE && (player2.score - player1.score) >= MIN_WINNING_DIFF;
    }

    private boolean isWinPlayer1() {
        return player1.score >= MIN_WINNING_SCORE && (player1.score - player2.score) >= MIN_WINNING_DIFF;
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