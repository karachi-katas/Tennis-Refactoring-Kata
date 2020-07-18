package chainofresponsibility;

public class Deuce extends ScoreCalculator {

    public Deuce() {
        this.next = new Last();
    }

    @Override
    protected boolean conditionTrue() {
        return hasDeuceConditionReached();
    }

    @Override
    protected String getResult() {
        return "Deuce";
    }

    private boolean hasDeuceConditionReached() {
        return player1.isDeuceWith(player2);
    }
}


