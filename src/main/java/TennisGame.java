public class TennisGame {

    public String P1res = "";
    public String P2res = "";

    private TennisPlayer player1;
    private TennisPlayer player2;

    public TennisGame(TennisPlayer player1, TennisPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        if (player1.getPoints() >= 4 && player2.getPoints() >= 0 && (player1.getPoints() - player2.getPoints()) >= 2) {
            return "Win for player1";
        }
        else if (player2.getPoints() >= 4 && player1.getPoints() >= 0 && (player2.getPoints() - player1.getPoints()) >= 2) {
            return "Win for player2";
        }

        else if (player1.getPoints() > player2.getPoints() && player2.getPoints() >= 3) {
            return "Advantage player1";
        }
        else if (player2.getPoints() > player1.getPoints() && player1.getPoints() >= 3) {
            return "Advantage player2";
        }

        else if (player1.getPoints() > 0 && player2.getPoints() == 0) {
            if (player1.getPoints() == 1)
                P1res = "Fifteen";
            if (player1.getPoints() == 2)
                P1res = "Thirty";
            if (player1.getPoints() == 3)
                P1res = "Forty";

            P2res = "Love";
            return P1res + "-" + P2res;
        }
        else if (player2.getPoints() > 0 && player1.getPoints() == 0) {
            if (player2.getPoints() == 1)
                P2res = "Fifteen";
            if (player2.getPoints() == 2)
                P2res = "Thirty";
            if (player2.getPoints() == 3)
                P2res = "Forty";

            P1res = "Love";
            return P1res + "-" + P2res;
        }

        else if (player1.getPoints() > player2.getPoints() && player1.getPoints() < 4) {
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
        else if (player2.getPoints() > player1.getPoints() && player2.getPoints() < 4) {
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

        else if (player1.getPoints() == player2.getPoints() && player1.getPoints() >= 3)
            return "Deuce";

        else if (player1.getPoints() == player2.getPoints() && player1.getPoints() < 4) {
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