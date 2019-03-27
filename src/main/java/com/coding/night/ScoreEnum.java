package com.coding.night;

public enum ScoreEnum {

    LOVE (0),
    FIFTEEN (1),
    THIRTY (2),
    FORTY (3),
    ADVANTAGE (4),
    GAMEWIN(5);

    private int index;

    ScoreEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static ScoreEnum getScore(int index){
        for(ScoreEnum score : ScoreEnum.values()){
            if(score.getIndex() == index){
                return score;
            }
        }
        return null;
    }
}
