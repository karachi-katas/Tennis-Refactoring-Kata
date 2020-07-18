package chainofresponsibility;

public class Advantage extends ScoreCalculator{

    public Advantage() {
        this.next = new LoveOrSomething();
    }

    @Override
    protected boolean conditionTrue() {
        return player1.hasAdvantageOver(player2) || player2.hasAdvantageOver(player1);
    }

    @Override
    protected String getResult() {
        return String.format("Advantage %s", getPlayerNameWithGreaterScore());
    }

    private String getPlayerNameWithGreaterScore() {
        return (player1.getScore() > player2.getScore()) ? player1.getName() : player2.getName();
    }
}
