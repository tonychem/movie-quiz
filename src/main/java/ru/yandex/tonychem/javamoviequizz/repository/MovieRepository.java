package ru.yandex.tonychem.javamoviequizz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.yandex.tonychem.javamoviequizz.model.Movie;


public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("select count(movie) from Movie movie")
    Long getMovieCount();
}
