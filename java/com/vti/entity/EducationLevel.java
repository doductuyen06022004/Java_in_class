package com.vti.entity;

public enum EducationLevel {

    UNIVERSITY("Đại học", 4, 210),
    COLLEGE("Cao đẳng", 3, 150);

    private final String levelName;
    private final int trainingYears;
    private final int requiredCredits;

    EducationLevel(String levelName, int trainingYears, int requiredCredits) {
        this.levelName = levelName;
        this.trainingYears = trainingYears;
        this.requiredCredits = requiredCredits;
    }

    public String getLevelName() {
        return levelName;
    }

    public int getTrainingYears() {
        return trainingYears;
    }

    public int getRequiredCredits() {
        return requiredCredits;
    }
}
