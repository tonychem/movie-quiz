package ru.yandex.tonychem.javamoviequizz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.yandex.tonychem.javamoviequizz.model.DifficultyMode;
import ru.yandex.tonychem.javamoviequizz.model.Movie;

import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("select count(movie) from Movie movie where movie.rating >= :rating")
    Long getMovieCount(Double rating);

    @Query("select movie.id from Movie movie where movie.rating >= :rating")
    List<Long> getMovieIdsForMode(Double rating);
}
