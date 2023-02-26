package ru.yandex.tonychem.javamoviequizz.model;

public enum DifficultyMode {
    EASY(8.2), MEDIUM(6.9), HARD(0.0);

    private Double rating;

    DifficultyMode(Double rating) {
        this.rating = rating;
    }

    public Double getRating() {
        return rating;
    }
}
