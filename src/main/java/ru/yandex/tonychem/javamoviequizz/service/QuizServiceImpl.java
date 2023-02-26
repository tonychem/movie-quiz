package ru.yandex.tonychem.javamoviequizz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.tonychem.javamoviequizz.model.DifficultyMode;
import ru.yandex.tonychem.javamoviequizz.model.Movie;
import ru.yandex.tonychem.javamoviequizz.model.QuizDto;
import ru.yandex.tonychem.javamoviequizz.repository.MovieRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
    private final MovieRepository movieRepository;

    @Override
    public QuizDto getRandomQuiz(DifficultyMode mode) {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();

        // Выбираем фильм
        List<Long> appropriateMovieIdsList = movieRepository.getMovieIdsForMode(mode.getRating());
        Movie chosenMovie;

        do {
            int randIndex = rnd.nextInt(appropriateMovieIdsList.size());
            chosenMovie = movieRepository.findById(appropriateMovieIdsList.get(randIndex)).orElse(null);
        } while (chosenMovie == null);

        //Выбираем ссылку на картинку
        List<String> links = chosenMovie.getLinks();
        int randPicIndex = rnd.nextInt(links.size());
        String pictureLink = links.get(randPicIndex);


        //Формируем рандомные названия фильмов
        List<String> options = new ArrayList<>();
        while (true) {
            List<Long> probableIds = getThreeProbableMovieOptions(appropriateMovieIdsList, chosenMovie.getId());
            List<String> optionNames = movieRepository.findAllById(probableIds).stream()
                    .map(Movie::getName)
                    .toList();

            if (!optionNames.isEmpty() && optionNames.size() == 3 && !optionNames.contains(chosenMovie.getName())) {
                options.addAll(optionNames);
                break;
            }
        }
        options.add(chosenMovie.getName());

        //Миксуем список
        Collections.shuffle(options);

        //Ищем индекс
        int indexInTheAnswerArray = options.indexOf(chosenMovie.getName());

        //формируем dto
        QuizDto dto = new QuizDto();
        dto.setAnswer(indexInTheAnswerArray);
        dto.setPicture(pictureLink);
        dto.setOptions(options);

        return dto;
    }

    private List<Long> getThreeProbableMovieOptions(List<Long> listOfIds, Long excludeId) {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        List<Long> probableIds = new ArrayList<>();

        while (probableIds.size() != 3) {
            int randomIndex = rnd.nextInt(listOfIds.size());

            if (!listOfIds.get(randomIndex).equals(excludeId)) {
                probableIds.add(listOfIds.get(randomIndex));
            }
        }

        return probableIds;
    }

}
