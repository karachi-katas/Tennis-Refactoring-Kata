
public class TennisGame {

    private String player1Name;
    private String player2Name;

    TennisPlayer player1 = new TennisPlayer("player1");
    TennisPlayer player2 = new TennisPlayer("player2");

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {

        GameState gameState = getGameState(player1, player2);

        if (gameState.equals(GameState.OTHER)){
            return getFormattedGameScore();
        } else if(gameState.equals(GameState.SAME_SCORES)){
            return getFormattedGameScoreWhenScoreIsTie();
        } else {
            return gameState.formattedGameScore;
        }
    }

    private String getFormattedGameScore() {
        return String.format("%s-%s", player1.getScoreAsString(), player2.getScoreAsString());
    }

    private String getFormattedGameScoreWhenScoreIsTie() {
        return player1.getScoreAsString() + "-All";
    }


    public void wonPoint(String player) {
        if(player1.scored(player)){
            player1.addScore();
        } else {
            player2.addScore();
        }
    }

    public GameState getGameState(TennisPlayer player1, TennisPlayer player2){
        if (player1.isDeuceWith(player2))
            return GameState.DEUCE;

        if (player1.isAtAdvantage(player2)) {
            return  GameState.PLAYER_1_ADVANTAGE;
        }

        if (player2.isAtAdvantage(player1)) {
            return  GameState.PLAYER_2_ADVANTAGE;
        }

        if (player1.hasWonAgainst(player2)) {
            return  GameState.PLAYER_1_WON;
        }

        if (player2.hasWonAgainst(player1)) {
            return  GameState.PLAYER_2_WON;
        }

        if (player1.hasSameScoreAs(player2) && player1.isNotDeuceWith(player2)) {
            return GameState.SAME_SCORES;
        }
        return GameState.OTHER;
    }
}
