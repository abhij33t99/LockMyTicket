
CREATE TABLE city (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE theatre (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50),
    city_id BIGINT NOT NULL,
    FOREIGN KEY (city_id) REFERENCES city(id)
);

CREATE TABLE movie (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE screen (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    theatre_id BIGINT NOT NULL,
    seats INT NOT NULL,
    FOREIGN KEY (theatre_id) REFERENCES theatre(id)
);

CREATE TABLE shows (
    id BIGSERIAL PRIMARY KEY,
    movie_id BIGINT NOT NULL,
    screen_id BIGINT NOT NULL,
    show_time TIMESTAMP NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movie(id),
    FOREIGN KEY (screen_id) REFERENCES screen(id)
);

CREATE TABLE booking (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    booking_time TIMESTAMP NOT NULL
);

CREATE TABLE seats (
    id BIGSERIAL PRIMARY KEY,
    seat_no VARCHAR(50),
    show_id BIGINT NOT NULL,
    booking_id BIGINT,
    FOREIGN KEY (show_id) REFERENCES showings(id),
    FOREIGN KEY (booking_id) REFERENCES booking(id)
);

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(200) NOT NULL
);