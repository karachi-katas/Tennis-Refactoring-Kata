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

        else if (player1.hasAdvantangeOver(player2)) {
            return "Advantage player1";
        }
        else if (player2.hasAdvantangeOver(player1)) {
            return "Advantage player2";
        }

        else if (player1.isLoveOver(player2)) {
            if (player1.getPoints() == 1)
                P1res = "Fifteen";
            if (player1.getPoints() == 2)
                P1res = "Thirty";
            if (player1.getPoints() == 3)
                P1res = "Forty";

            P2res = "Love";
            return P1res + "-" + P2res;
        }
        else if (player2.isLoveOver(player1)) {
            if (player2.getPoints() == 1)
                P2res = "Fifteen";
            if (player2.getPoints() == 2)
                P2res = "Thirty";
            if (player2.getPoints() == 3)
                P2res = "Forty";

            P1res = "Love";
            return P1res + "-" + P2res;
        }

        else if (player1.isNotDeuceAndGreaterThan(player2)) {
            if (player1.getPoints() == 2)
                P1res = "Thirty";
            if (player1.getPoints() == 3)
                P1res = "Forty";
            if (player2.getPoints() == 1)
                P2res = "Fifteen";
            if (player2.getPoints() == 2)
                P2res = "Thirty";
            return P1res + "-" + P2res;
        }
        else if (player2.isNotDeuceAndGreaterThan(player1)) {
            if (player2.getPoints() == 2)
                P2res = "Thirty";
            if (player2.getPoints() == 3)
                P2res = "Forty";
            if (player1.getPoints() == 1)
                P1res = "Fifteen";
            if (player1.getPoints() == 2)
                P1res = "Thirty";
            return P1res + "-" + P2res;
        }

        else if (player1.isDeuceWith(player2))
            return "Deuce";

        else if (player1.isNotDeuceAndEqualScoreWith(player2)) {
            if (player1.getPoints() == 0)
                return "Love-All";
            if (player1.getPoints() == 1)
                return "Fifteen-All";
            if (player1.getPoints() == 2)
                return "Thirty-All";
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