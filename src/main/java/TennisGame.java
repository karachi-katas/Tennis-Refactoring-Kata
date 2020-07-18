
public class TennisGame {

    private String player1Name;
    private String player2Name;

    TennisPlayer player1 = new TennisPlayer();
    TennisPlayer player2 = new TennisPlayer();

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {

        GameState gameState = getGameState(player1, player2);

        if(!gameState.equals(GameState.OTHER)){
            return gameState.gameScore;
        }
        return getFormattedGameScore();
    }

    private String getFormattedGameScore() {
        if (player1.hasSameScoreAs(player2) && player1.isNotDeuceWith(player2)) {
            return player1.getScoreAsString() + "-All";
        } else {
            return String.format("%s-%s", player1.getScoreAsString(), player2.getScoreAsString());
        }
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
        player1.addScore();
    }

    public void P2Score() {
        player2.addScore();
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
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
        return GameState.OTHER;
    }
}
