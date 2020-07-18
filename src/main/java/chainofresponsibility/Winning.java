package chainofresponsibility;

public class Winning extends ScoreCalculator {

    public Winning() {
        this.next = new Advantage();
    }

    @Override
    protected boolean conditionTrue() {
        return player1.isWinnerOver(player2) || player2.isWinnerOver(player1);
    }

    @Override
    protected String getResult() {
        return String.format("Win for %s", getPlayerNameWithGreaterScore());
    }

    private String getPlayerNameWithGreaterScore() {
        return (player1.getScore() > player2.getScore()) ? player1.getName() : player2.getName();
    }
}
