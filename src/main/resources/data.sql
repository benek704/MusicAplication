CREATE TABLE Album
(
    id           LONG         NOT NULL AUTO_INCREMENT,
    performer    VARCHAR(255) NOT NULL,
    title        VARCHAR(255) NOT NULL,
    release_date DATE         NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Track
(
    id       LONG         NOT NULL AUTO_INCREMENT,
    title    VARCHAR(255) NOT NULL,
    duration DOUBLE       NOT NULL,
    album_id LONG         NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (album_id) REFERENCES album (id)
);



INSERT INTO Album (PERFORMER, TITLE, RELEASE_DATE)
VALUES ('Michael Jackson', 'Thriller', '1982-11-30'),
       ('Pink Floyd', 'The Wall', '1979-11-30'),
       ('Kimbra', 'Vows', '2011-08-28');

INSERT INTO Track (TITLE, DURATION, ALBUM_ID)
VALUES ('Beat', 03.30, 1),
       ('Smooth Criminal', 04.17, 1),
       ('Another Brick in the Wall', 03.40, 2),
       ('Comfortably Numb', 6.26, 2),
       ('Settle Down', 4.02, 3),
       ('Cameo Lover', 4.02, 3),
       ('Two Way Street', 4.28, 3),
       ('Old Flame', 4.27, 3)
;
