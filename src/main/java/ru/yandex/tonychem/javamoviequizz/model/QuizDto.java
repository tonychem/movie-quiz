package ru.yandex.tonychem.javamoviequizz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    private String picture;
    private List<String> options;
    private Integer answer;
}
