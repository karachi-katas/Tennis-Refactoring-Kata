package chainofresponsibility;

public class LoveOrSomething extends ScoreCalculator {
    LoveOrSomething() {
        this.next = new Deuce();
    }

    @Override
    protected boolean conditionTrue() {
        return hasLoveConditionReached() || hasNotDeuceAndNotEqualConditionReached();
    }

    @Override
    protected String getResult() {
        return String.format("%s-%s", player1.getScoreString(), player2.getScoreString());
    }

    private boolean hasNotDeuceAndNotEqualConditionReached() {
        return player1.isNotDeuceAndGreaterThan(player2) || player2.isNotDeuceAndGreaterThan(player1);
    }

    private boolean hasLoveConditionReached() {
        return player1.isLoveOver(player2) || player2.isLoveOver(player1);
    }
}
