create or replace procedure add_new_show(
	p_movie_id BIGINT,
    p_screen_id BIGINT,
    p_date TIMESTAMP 
) 
LANGUAGE plpgsql
AS $$
DECLARE
    i INT DEFAULT 1;
    j INT DEFAULT 1;
    letter CHAR(1) DEFAULT 'A';
    v_show_id BIGINT;
    v_seats INT;
BEGIN
    -- Insert the new show
    INSERT INTO showings (movie_id, screen_id, show_time) 
    VALUES (p_movie_id, p_screen_id, p_date);

    -- Retrieve the ID of the newly inserted show
    SELECT id INTO v_show_id 
    FROM showings 
    WHERE movie_id = p_movie_id AND screen_id = p_screen_id AND show_time = p_date;

    -- Retrieve the number of seats from the screen
    SELECT seats INTO v_seats 
    FROM screen 
    WHERE id = p_screen_id;

    -- Loop to create seat entries for the show
    WHILE i <= v_seats LOOP
        IF j > 10 THEN
            j := 1;
            letter := CHR(ASCII(letter) + 1);
        END IF;

        INSERT INTO seats (seat_no, show_id) 
        VALUES (CONCAT(letter, j), v_show_id);

        i := i + 1;
        j := j + 1;
    END LOOP;
END;
$$;
