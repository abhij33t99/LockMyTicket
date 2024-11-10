CREATE OR REPLACE PROCEDURE BOOK_TICKETS(
    p_seats VARCHAR,
    p_name VARCHAR(50),
    p_showtime TIMESTAMP
)AS $$
DECLARE
    v_booking_id BIGINT;
BEGIN
	SET LOCAL lock_timeout = '5s';

    INSERT INTO booking(name, booking_time) VALUES (p_name, p_showtime);

	-- Retrieve the booking ID
    SELECT id INTO v_booking_id
    FROM booking
    WHERE name = p_name
      AND booking_time = p_showtime;

    -- Update the seats with the new booking ID
	BEGIN
    	EXECUTE FORMAT('UPDATE seats SET booking_id = %s WHERE id IN (%s) FOR UPDATE', v_booking_id, p_seats);
	EXCEPTION
    WHEN OTHERS THEN
      -- Handle exceptions, including lock timeouts
      RAISE NOTICE 'Error occurred: %', SQLERRM;
  END;
END;
$$ LANGUAGE plpgsql;
