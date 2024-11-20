-- PROCEDURE: public.book_tickets(character varying, character varying, timestamp without time zone)

-- DROP PROCEDURE IF EXISTS public.book_tickets(character varying, character varying, timestamp without time zone);

CREATE OR REPLACE PROCEDURE public.book_tickets(
	IN p_seats character varying,
	IN p_name character varying,
	IN p_showtime timestamp without time zone,
	OUT v_booking_id bigint)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN
	SET LOCAL lock_timeout = '5s';

	EXECUTE FORMAT('SELECT * from seats where id in (%s) for update', p_seats);
	
    INSERT INTO booking(name, booking_time) VALUES (p_name, p_showtime);

	-- Retrieve the booking ID
    SELECT id INTO v_booking_id
    FROM booking
    WHERE name = p_name
      AND booking_time = p_showtime;

    -- Update the seats with the new booking ID
	BEGIN
    	EXECUTE FORMAT('UPDATE seats SET booking_id = %s WHERE id IN (%s)', v_booking_id, p_seats);
	EXCEPTION
    WHEN OTHERS THEN
      -- Handle exceptions, including lock timeouts
      RAISE NOTICE 'Error occurred: %', SQLERRM;
  END;
END;
$BODY$;
ALTER PROCEDURE public.book_tickets(character varying, character varying, timestamp without time zone)
    OWNER TO root;
