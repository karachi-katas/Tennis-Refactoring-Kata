public class TennisGame {

    private final String DEUCE = "Deuce";

    private ScoreCard player1Score = new ScoreCard("player1");
    private ScoreCard player2Score = new ScoreCard("player2");

    public String getScore() {
        if (isEarlyGame()) {
            return processForEarlyGame();
        }

        return processForLateGame();
    }

    private String processForEarlyGame() {
        if (!ScoreCard.areEqual(player1Score, player2Score)) {
            return player1Score.getScore() + "-" + player2Score.getScore();
        }

        if (player1Score.isNotDeuceWorthy()) return player1Score.getScore() + "-All";
        else                                 return DEUCE;
    }

    private String processForLateGame() {
        int delta = player1Score.difference(player2Score);

        switch (delta) {
            case  0: return DEUCE;
            case  1: return getAdvantageString();
            default: return getWinString();
        }
    }

    private boolean isEarlyGame() {
        return player1Score.getScore() != ScoreNames.Greater && player2Score.getScore() != ScoreNames.Greater;
    }

    private String getAdvantageString() {
        return String.format("Advantage %s", ScoreCard.getBetterPlayer(player1Score, player2Score));
    }

    private String getWinString() {
        return String.format("Win for %s", ScoreCard.getBetterPlayer(player1Score, player2Score));
    }

    public void incrementPlayer1Score() {
        player1Score.increment();
    }

    public void incrementPlayer2Score() {
        player2Score.increment();
    }
}