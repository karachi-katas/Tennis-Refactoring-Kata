public class Game {

    public String P1res = "";
    public String P2res = "";

    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        if (player1.isWinnerOver(player2)) {
            return "Win for player1";
        }
        else if (player2.isWinnerOver(player1)) {
            return "Win for player2";
        }

        else if (player1.hasAdvantageOver(player2)) {
            return "Advantage player1";
        }
        else if (player2.hasAdvantageOver(player1)) {
            return "Advantage player2";
        }

        else if (player1.isLoveOver(player2)) {
            return String.format("%s-Love", player1.getPointsString());
        }

        else if (player2.isLoveOver(player1)) {
            return String.format("Love-%s", player2.getPointsString());
        }

        else if (player1.isNotDeuceAndGreaterThan(player2)) {
            return String.format("%s-%s", player1.getPointsString(), player2.getPointsString());
        }
        else if (player2.isNotDeuceAndGreaterThan(player1)) {
            return String.format("%s-%s", player1.getPointsString(), player2.getPointsString());
        }

        else if (player1.isDeuceWith(player2)) {
            return "Deuce";
        }

        else if (player1.isNotDeuceAndEqualScoreWith(player2)) {
            return String.format("%s-All", player1.getPointsString());
        }

        return "";
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1.getName()))
            this.player1.wonPoint();
        else
            this.player2.wonPoint();
    }
}