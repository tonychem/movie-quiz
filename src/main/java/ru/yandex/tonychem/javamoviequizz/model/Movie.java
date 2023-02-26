package ru.yandex.tonychem.javamoviequizz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ElementCollection
    @CollectionTable(name = "movies_links", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "link")
    private List<String> links;

    @Column(name = "rating", nullable = false)
    private Double rating;
}
