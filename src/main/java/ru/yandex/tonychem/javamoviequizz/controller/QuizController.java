package ru.yandex.tonychem.javamoviequizz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.tonychem.javamoviequizz.model.DifficultyMode;
import ru.yandex.tonychem.javamoviequizz.model.QuizDto;
import ru.yandex.tonychem.javamoviequizz.service.QuizService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/quiz")
public class QuizController {


    private final QuizService quizService;

    @GetMapping()
    public QuizDto getRandomQuiz(@RequestParam(required = false, defaultValue = "EASY") DifficultyMode mode) {
        return quizService.getRandomQuiz(mode);
    }
}