package main;

import chainofresponsibility.ScoreCalculator;
import chainofresponsibility.Winning;

public class Game {

    private Player player1;
    private Player player2;

    private ScoreCalculator scoreCalculator;

    public Game(String playerName1, String playerName2) {
        this.player1 = new Player(playerName1);
        this.player2 = new Player(playerName2);

        scoreCalculator = new Winning();
    }

    public void wonScore(String playerName) {
        if (playerName.equals(player1.getName()))
            player1.wonScore();
        else
            player2.wonScore();
    }

    public String getScore() {
        return scoreCalculator.calculate(player1, player2);
    }
}