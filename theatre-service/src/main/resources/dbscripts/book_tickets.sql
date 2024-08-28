DELIMITER //

drop procedure book_tickets;

CREATE PROCEDURE BOOK_TICKETS(
    IN p_seats VARCHAR(100),
    IN p_name VARCHAR(50),
    IN p_showtime DATETIME
)
BEGIN
    DECLARE v_booking_id BIGINT;

    -- Step 1: Lock the seats using FOR UPDATE with dynamic SQL
    SET @v_query = CONCAT('SELECT id FROM seats WHERE id IN (', p_seats, ') FOR UPDATE');
    PREPARE stmt FROM @v_query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt; -- Added DEALLOCATE to free resources

    -- Step 2: Insert booking information
    INSERT INTO booking(name, booking_time) VALUES ( p_name, p_showtime);

    -- Step 3: Retrieve the booking ID using correct SELECT INTO syntax
    SELECT id INTO v_booking_id
    FROM booking
    WHERE name = p_name
      AND booking_time = p_showtime;

    -- Step 4: Update the seats with the new booking ID using dynamic SQL
    SET @v_query = CONCAT('UPDATE seats SET booking_id = ', v_booking_id, ' WHERE id IN (', p_seats, ')');
    PREPARE stmt FROM @v_query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt; -- Added DEALLOCATE to free resources
END //

DELIMITER ;
