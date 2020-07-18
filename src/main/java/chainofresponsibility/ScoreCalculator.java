package chainofresponsibility;

import main.Player;

public abstract class ScoreCalculator {
    protected Player player1;
    protected Player player2;
    protected ScoreCalculator next;

    public String calculate(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        if (this.conditionTrue()) {
            return this.getResult();
        }

        return (this.next != null) ? this.next.calculate(player1, player2) : "";
    }

    protected abstract boolean conditionTrue();
    protected abstract String getResult();
}
