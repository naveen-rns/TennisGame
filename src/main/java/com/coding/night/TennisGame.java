package com.coding.night;

public class TennisGame {
//    final ScoreEnum[] scoreArray = new ScoreEnum[]{ScoreEnum.LOVE, ScoreEnum.FIFTEEN, ScoreEnum.THIRTY, ScoreEnum.FORTY, ScoreEnum.ADVANTAGE};

    ScoreEnum player1CurrentScore = ScoreEnum.LOVE;
    ScoreEnum player2CurrentScore = ScoreEnum.LOVE;

    String gameScore = "Love All";

    public String getGameScore() {
        if(player1CurrentScore == ScoreEnum.LOVE && player2CurrentScore == ScoreEnum.LOVE){
            return "Love All";
        }
        if(player1CurrentScore == ScoreEnum.FORTY && player2CurrentScore == ScoreEnum.FORTY){
            return "Duece";
        }

        if(player1CurrentScore == ScoreEnum.ADVANTAGE){
            return "Player 1 Advantage";
        }

        if(player2CurrentScore == ScoreEnum.ADVANTAGE){
            return "Player 2 Advantage";
        }
        if(player1CurrentScore == ScoreEnum.GAMEWIN){
            return "Player 1 Won";
        }

        if(player2CurrentScore == ScoreEnum.GAMEWIN){
            return "Player 2 Won";
        }

        return player1CurrentScore.name() + " - " + player2CurrentScore.name();
    }

    public String player1Scores() {
        player1CurrentScore = updateWinning(player1CurrentScore.getIndex(), true);
        return player1CurrentScore.name();
    }

    public String player2Scores() {
        player2CurrentScore = updateWinning(player2CurrentScore.getIndex(), false);
        return player2CurrentScore.name();
    }


    private ScoreEnum updateWinning(int currentScore, boolean playerFlag){
//        if(ScoreEnum.getScore(currentScore) == ScoreEnum.ADVANTAGE){
//
//        }
        if(playerFlag && player2CurrentScore == ScoreEnum.ADVANTAGE && ScoreEnum.getScore(currentScore+1) == ScoreEnum.ADVANTAGE){
            player1CurrentScore = ScoreEnum.FORTY;
            player2CurrentScore = ScoreEnum.FORTY;
            return ScoreEnum.FORTY;
        }

        if(!playerFlag && player1CurrentScore == ScoreEnum.ADVANTAGE && ScoreEnum.getScore(currentScore+1) == ScoreEnum.ADVANTAGE){
            player1CurrentScore = ScoreEnum.FORTY;
            player2CurrentScore = ScoreEnum.FORTY;
            return ScoreEnum.FORTY;
        }

        if(!getGameScore().equalsIgnoreCase("Duece") && ScoreEnum.getScore(currentScore) == ScoreEnum.FORTY){
            return ScoreEnum.GAMEWIN;
        }

        if(currentScore < 5){
            return ScoreEnum.getScore(currentScore+1);
        }
        return ScoreEnum.GAMEWIN;

    }

    public ScoreEnum getPlayer1CurrentScore() {
        return player1CurrentScore;
    }

    public ScoreEnum getPlayer2CurrentScore() {
        return player2CurrentScore;
    }


}
