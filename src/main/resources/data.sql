CREATE TABLE IF NOT EXISTS movies
(
    id
    int8
    GENERATED
    BY
    DEFAULT AS
    IDENTITY
    PRIMARY
    KEY,
    name
    text
    NOT
    NULL
);

CREATE TABLE IF NOT EXISTS movies_links
(
    movie_id int8 REFERENCES movies
(
    id
) ON DELETE CASCADE,
    link text NOT NULL
    );