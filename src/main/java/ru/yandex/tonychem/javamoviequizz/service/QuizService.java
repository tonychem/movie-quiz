package ru.yandex.tonychem.javamoviequizz.service;

import ru.yandex.tonychem.javamoviequizz.model.DifficultyMode;
import ru.yandex.tonychem.javamoviequizz.model.QuizDto;

import java.io.IOException;

public interface QuizService {
    QuizDto getRandomQuiz(DifficultyMode mode);
}
