public class ScoreCard {
    private int score = 0;
    private String player;

    public ScoreCard(String player) {
        this.player = player;
    }

    final static private ScoreNames[] scoreNames = new ScoreNames[] { ScoreNames.Love, ScoreNames.Fifteen, ScoreNames.Thirty, ScoreNames.Forty };

    public void increment() {
        ++score;
    }

    public ScoreNames getScore() {
        if (score < scoreNames.length) {
            return scoreNames[score];
        } else {
            return ScoreNames.Greater;
        }
    }

    public static boolean areEqual(ScoreCard first, ScoreCard second) {
        return first.score == second.score;
    }

    public boolean isNotDeuceWorthy() {
        return score < 3;
    }

    public int difference(ScoreCard other) {
        return Math.abs(this.score - other.score);
    }

    public static String getBetterPlayer(ScoreCard card1, ScoreCard card2) {
        if (card1.score > card2.score) return card1.player;
        else return card2.player;
    }
}
