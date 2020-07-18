public enum GameState {
    DEUCE("Deuce"),
    PLAYER_1_ADVANTAGE("Advantage player1"),
    PLAYER_2_ADVANTAGE("Advantage player2"),
    PLAYER_1_WON("Win for player1"),
    PLAYER_2_WON("Win for player2"),
    OTHER("N/A"),
    SAME_SCORES("N/A");



    String formattedGameScore;

    GameState(String formattedGameScore) {
        this.formattedGameScore = formattedGameScore;
    }
}
