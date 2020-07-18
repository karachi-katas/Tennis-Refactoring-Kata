public class TennisPlayer {

    int score;
    String name;

    public TennisPlayer(String name) {
        this.score = 0;
        this.name = name;

    }

    public String getScoreAsString() {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        throw new CannotRepresentScoreAsStringException();
    }

    public boolean isAtAdvantage(TennisPlayer player2) {
        return score > player2.score && score - player2.score < 2 && player2.score >= 3;
    }

    public boolean hasWonAgainst(TennisPlayer player2) {
        return score >=4 && player2.score >=0 && (score - player2.score) >=2;
    }

    public void addScore() {
        this.score++;
    }

    public boolean isDeuceWith(TennisPlayer player2) {
        return score == player2.score && score >= 3;
    }
    public boolean isNotDeuceWith(TennisPlayer player2) {
        return !isDeuceWith(player2);
    }

    public boolean hasSameScoreAs(TennisPlayer player2) {
        return score == player2.score;

    }

    public boolean scored(String player) {
        return this.name.equals(player);
    }
}
