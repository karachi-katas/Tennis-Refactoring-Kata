public class TennisScore {

    int score;

    public TennisScore() {
        this.score = 0;
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
        return null;
    }

    public boolean isDeuce(TennisScore tennisScore) {
        return score == tennisScore.score && score >= 3;
    }

    public boolean isAtAdvantage(TennisScore tennisScore) {
        return score > tennisScore.score && score - tennisScore.score < 2 && score >= 3;
    }

    public void addScore() {
        this.score++;
    }
}
