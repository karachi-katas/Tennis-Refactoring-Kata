package chainofresponsibility;

public class Last extends ScoreCalculator {
    @Override
    protected boolean conditionTrue() {
        return true;
    }

    @Override
    protected String getResult() {
        return String.format("%s-All", player1.getScoreString());
    }
}
