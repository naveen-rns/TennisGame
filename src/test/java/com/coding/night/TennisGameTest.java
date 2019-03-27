package com.coding.night;

import org.junit.Assert;
import org.junit.Test;

public class TennisGameTest {

    @Test
    public void testScoreEnum(){
        int score = 3;
        Assert.assertTrue(ScoreEnum.FORTY.equals(ScoreEnum.getScore(score)));
    }

    @Test
    public void testPlayer1Scores(){
        TennisGame game = new TennisGame();
        String player1Score = game.player1Scores();
        Assert.assertEquals(player1Score, ScoreEnum.FIFTEEN.name());
    }

    @Test
    public void testPlayer1ScoreTwice(){
        TennisGame game = new TennisGame();
        game.player1Scores();
        game.player1Scores();
        Assert.assertEquals(game.getPlayer1CurrentScore(), ScoreEnum.THIRTY);
    }

    @Test
    public void testGameScore(){
        TennisGame game = new TennisGame();
        game.player1Scores();
        game.player1Scores();
        Assert.assertEquals(game.getGameScore(), ScoreEnum.THIRTY + " - " + ScoreEnum.LOVE);
    }

    @Test
    public void testGameScoreLoveAll(){
        TennisGame game = new TennisGame();
        Assert.assertEquals(game.getGameScore(), "Love All");
    }

    @Test
    public void testGameScoreDuece(){
        TennisGame game = new TennisGame();
        game.player1Scores();
        game.player2Scores();
        game.player1Scores();
        game.player2Scores();
        game.player1Scores();
        game.player2Scores();
        Assert.assertEquals(game.getGameScore(), "Duece");
    }

    @Test
    public void testPlayer1Win(){
        TennisGame game = new TennisGame();
        game.player1Scores();
        game.player1Scores();
        game.player1Scores();
        game.player1Scores();
        Assert.assertEquals(game.getGameScore(), "Player 1 Won");
    }


    @Test
    public void testPlayer2Advantage(){
        TennisGame game = new TennisGame();
        game.player1Scores();
        game.player2Scores();
        game.player1Scores();
        game.player2Scores();
        game.player1Scores();
        game.player2Scores();
        game.player2Scores();
        Assert.assertEquals(game.getGameScore(), "Player 2 Advantage");
    }

    @Test
    public void testPlayer1WinAfterAdvantage(){
        TennisGame game = new TennisGame();
        game.player1Scores();
        game.player2Scores();
        game.player1Scores();
        game.player2Scores();
        game.player1Scores();
        game.player2Scores();
        game.player1Scores();
        game.player2Scores();
        game.player1Scores();
        game.player1Scores();
        Assert.assertEquals(game.getGameScore(), "Player 1 Won");
    }

}
