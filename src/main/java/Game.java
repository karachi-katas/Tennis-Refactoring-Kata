public class Game {

    private Player player1;
    private Player player2;

    public Game(String playerName1, String playerName2) {
        this.player1 = new Player(playerName1);
        this.player2 = new Player(playerName2);
    }

    public void wonScore(String playerName) {
        if (playerName.equals(player1.getName()))
            player1.wonScore();
        else
            player2.wonScore();
    }

    public String getScore() {
        if (hasWinningConditionReached()) {
            return String.format("Win for %s", getPlayerNameWithGreaterScore());
        }

        else if (hasAdvantageConditionReached()) {
            return String.format("Advantage %s", getPlayerNameWithGreaterScore());
        }

        else if (hasLoveConditionReached() || hasNotDeuceAndNotEqualConditionReached()) {
            return String.format("%s-%s", player1.getScoreString(), player2.getScoreString());
        }

        else if (hasDeuceConditionReached()) {
            return "Deuce";
        }

        return String.format("%s-All", player1.getScoreString());
    }

    private boolean hasDeuceConditionReached() {
        return player1.isDeuceWith(player2);
    }

    private boolean hasNotDeuceAndNotEqualConditionReached() {
        return player1.isNotDeuceAndGreaterThan(player2) || player2.isNotDeuceAndGreaterThan(player1);
    }

    private boolean hasLoveConditionReached() {
        return player1.isLoveOver(player2) || player2.isLoveOver(player1);
    }

    private boolean hasAdvantageConditionReached() {
        return player1.hasAdvantageOver(player2) || player2.hasAdvantageOver(player1);
    }

    private boolean hasWinningConditionReached() {
        return player1.isWinnerOver(player2) || player2.isWinnerOver(player1);
    }

    private String getPlayerNameWithGreaterScore() {
        return (player1.getScore() > player2.getScore()) ? player1.getName() : player2.getName();
    }
}