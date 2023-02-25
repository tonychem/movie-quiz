package ru.yandex.tonychem.javamoviequizz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Data
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
}
