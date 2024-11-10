drop procedure if exists ADD_NEW_SHOW;

DELIMITER //
CREATE PROCEDURE ADD_NEW_SHOW(
in p_movie_id bigint,
in p_screen_id bigint,
in p_date datetime
)
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE j INT DEFAULT 1;
    DECLARE letter CHAR(1) DEFAULT 'A';
    declare v_show_id bigint;
    declare v_seats int;
    START TRANSACTION;
    insert into shows (movie_id, screen_id, show_time) values (p_movie_id, p_screen_id, p_date);

    select id into v_show_id from shows where movie_id = p_movie_id and screen_id = p_screen_id and show_time = p_date;

    select seats into v_seats from screen where id = p_screen_id;

    WHILE i <= v_seats DO
        IF j > 10 THEN
            SET j := 1;
            SET letter := CHAR(ASCII(letter) + 1);
        END IF;

        INSERT INTO seats (seat_no, show_id) VALUES (CONCAT(letter, j), v_show_id);
        SET i := i + 1;
        SET j := j + 1;
    END WHILE;
    COMMIT;
END //

DELIMITER ;